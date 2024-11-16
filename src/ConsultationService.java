import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsultationService {

    //------------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------(Reservar)---------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------------------------

    public String reservarConsulta(String clinica , String especialidade , String dataHora , int userId ){
        

        

        //-------------------------------Verificar se a clinica recebida existe---------------------------------------------------------//
        int clinicaId = -1;
        String checkclinicaSql = "SELECT clinic_id FROM clinics WHERE name = ?";
        try(Connection conct = DatabaseConnection.getConnection(); PreparedStatement stmt = conct.prepareStatement(checkclinicaSql)){
            stmt.setString(1, clinica);

            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){
                clinicaId = resultSet.getInt("clinic_id");
            }else{
                return "A clinica fornecida nao existe";
            }


        }catch(SQLException e){
            e.printStackTrace();
            return "Erro ao verificar a clinica fornecida";
        }

        //-----------------------------Verificar se a especialidade recebida existe-------------------------------------------------//

        int especialidadeId = -1;
        String checkEspecialidadeSql = "SELECT specialty_id FROM specialties WHERE name = ?";
        try(Connection conct = DatabaseConnection.getConnection(); PreparedStatement stmt = conct.prepareStatement(checkEspecialidadeSql)){
            stmt.setString(1, especialidade);

            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){
                especialidadeId = resultSet.getInt("specialty_id");
            }else{
                return "A especialidade fornecido nao existe";
            }


        }catch(SQLException e){
            e.printStackTrace();
            return "Erro ao verificar a especialidade fornecida";
        }

        //------------------Verificar se a especialidade recebida está disponivel na clinica recebida---------------------------//

        String checkEspecClinicaSql = "SELECT COUNT(*) FROM doctors WHERE clinic_id = ? AND specialty_id = ?";
        try(Connection conct = DatabaseConnection.getConnection(); PreparedStatement stmt = conct.prepareStatement(checkEspecClinicaSql)){
            stmt.setInt(1, clinicaId);
            stmt.setInt(2, especialidadeId);

            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next() && resultSet.getInt(1) == 0){ //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                return "A especialidade fornecida nao esta disponivel na clinica fornecida";
            }

        }catch(SQLException e){
            e.printStackTrace();
            return "Erro ao verificar a disponibilidade da especialidade na clinica";
        }

        //-------------------------------Verificar se o horario é valido------------------------------------------------------------//
        
                List<String> horasValidos = Arrays.asList("08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00");

                String hora = dataHora.split(" ")[1];
        
                if(!horasValidos.contains(hora)){
                    return "O horario fornecido invalido";
                }

        //------------------Verificar se existe um medico disponivel para o horario recebido----------------------------------//

        String checkDisponiblidadeSql = 
        "SELECT d.doctor_id FROM doctors d " +
        "LEFT JOIN consultations c ON d.doctor_id = c.doctor_id AND c.date_time = ? " +
        "WHERE d.specialty_id = ? AND d.clinic_id = ? AND c.consultation_id IS NULL " +
        "LIMIT 1";

        try (Connection conct = DatabaseConnection.getConnection(); 
            PreparedStatement stmt = conct.prepareStatement(checkDisponiblidadeSql)) {

            stmt.setString(1, dataHora);
            stmt.setInt(2, especialidadeId); 
            stmt.setInt(3, clinicaId);

            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                int doutorDisponivelId = resultSet.getInt("doctor_id");

            //-------Se a query retornar alguma linha quer dizer que existe um medico sem consulta a essa hora-----------------//
                String insertConsultaSql = 
                    "INSERT INTO consultations (clinic_id, specialty_id, date_time, user_id, doctor_id) VALUES (?,?,?,?,?)";

                try (PreparedStatement insertStmt = conct.prepareStatement(insertConsultaSql)) {
                    insertStmt.setInt(1, clinicaId);  
                    insertStmt.setInt(2, especialidadeId); 
                    insertStmt.setString(3, dataHora);
                    insertStmt.setInt(4, userId);
                    insertStmt.setInt(5, doutorDisponivelId);
                    insertStmt.executeUpdate();

                    return "Consulta marcada com sucesso";
                }
            } else {
                return "Nao ha medicos disponiveis para a especialidade selecionada na data e hora especificadas";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao verificar disponibilidade de medicos";
        }

    }

     //------------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------(Cancelar)---------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------------------------



    public String cancelarConsulta(int consultationId){

        //-----------------------------Verificar se a consullta existe---------------------------------//

        String checkConsultaIDSql = "SELECT FROM consultations WHERE  consultation_id = ?";
        
        try(Connection conct = DatabaseConnection.getConnection(); PreparedStatement stmt = conct.prepareStatement(checkConsultaIDSql)){
            stmt.setInt(1, consultationId);

            ResultSet resultSet = stmt.executeQuery();
            if(!resultSet.next()){
                return "A consulta fornecida nao existe";
            }

        }catch(SQLException e){
            e.printStackTrace();
            return "Erro ao verificar a consulta fornecida";
        }


        //----------------------------------Delete Consulta--------------------------------------------//

        String deleteConsultaSql = "DELETE FROM consultations WHERE  consultation_id = ?";
        
        try(Connection conct = DatabaseConnection.getConnection(); PreparedStatement stmt = conct.prepareStatement(deleteConsultaSql)){
            stmt.setInt(1, consultationId);
            stmt.executeUpdate();

            System.out.println("Consulta removida com sucesso!!");


        }catch(SQLException e){
            e.printStackTrace();
            return "Erro ao remover a consulta";
        }

        return "Erro inesperado ao remover a consulta";
    }


    //------------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------(Update)---------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------------------------





    public String updateConsulta(int consultaId , String novaclinica , String novaEspecialidade , String novaData , int userId){

        
        //-----------------------------Verificar se a consulta existe---------------------------------------------------//

        String checkConsultaIDSql = "SELECT FROM consultations WHERE  consultation_id = ?";
        
        try(Connection conct = DatabaseConnection.getConnection(); PreparedStatement stmt = conct.prepareStatement(checkConsultaIDSql)){
            stmt.setInt(1, consultaId);

            ResultSet resultSet = stmt.executeQuery();
            if(!resultSet.next()){
                return "A consulta fornecida nao existe";
            }

        }catch(SQLException e){
            e.printStackTrace();
            return "Erro ao verificar a consulta fornecida";
        }


        
        

        //-------------------------------Verificar se a clinica recebida existe---------------------------------------------------------//
       int clinicaId = -1;
        String checkclinicaSql = "SELECT clinic_id FROM clinics WHERE name = ?";
        try(Connection conct = DatabaseConnection.getConnection(); PreparedStatement stmt = conct.prepareStatement(checkclinicaSql)){
            stmt.setString(1, novaclinica);

            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){
                clinicaId = resultSet.getInt("clinic_id");
            }else{
                return "A clinica fornecida nao existe";
            }


        }catch(SQLException e){
            e.printStackTrace();
            return "Erro ao verificar a clinica fornecida";
        } 

        //-----------------------------Verificar se a especialidade recebida existe-------------------------------------------------//

        int especialidadeId = -1;
        String checkEspecialidadeSql = "SELECT specialty_id FROM specialties WHERE name = ?";
        try(Connection conct = DatabaseConnection.getConnection(); PreparedStatement stmt = conct.prepareStatement(checkEspecialidadeSql)){
            stmt.setString(1, novaEspecialidade);

            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){
                clinicaId = resultSet.getInt("specialty_id");
            }else{
                return "A especialidade fornecida nao existe";
            }


        }catch(SQLException e){
            e.printStackTrace();
            return "Erro ao verificar a especialidade fornecida";
        }

        //------------------Verificar se a especialidade recebida está disponivel na clinica recebida---------------------------//

        String checkEspecClinicaSql = "SELECT COUNT(*) FROM doctors WHERE clinic_id = ? AND specialty_id = ?";
        try(Connection conct = DatabaseConnection.getConnection(); PreparedStatement stmt = conct.prepareStatement(checkEspecClinicaSql)){
            stmt.setInt(1, clinicaId);
            stmt.setInt(2, especialidadeId);

            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next() && resultSet.getInt(1) == 0){ //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                return "A especialidade fornecida nao esta disponivel na clinica fornecida";
            }

        }catch(SQLException e){
            e.printStackTrace();
            return "Erro ao verificar a disponibilidade da especialidade na clinica";
        }


        //-------------------------------Verificar se o horario é valido------------------------------------------------------------//
        
                List<String> horasValidos = Arrays.asList("08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00");

                String hora = novaData.split(" ")[1];
        
                if(!horasValidos.contains(hora)){
                    return "Horario fornecido invalido";
                }

        //------------------Verificar se existe um medico disponivel para o horario recebido----------------------------------//

        String checkDisponiblidadeSql = 
        "SELECT d.doctor_id FROM doctors d " +
        "LEFT JOIN consultations c ON d.doctor_id = c.doctor_id AND c.date_time = ? " +
        "WHERE d.specialty_id = ? AND d.clinic_id = ? AND c.consultation_id IS NULL " +
        "LIMIT 1";

        try (Connection conct = DatabaseConnection.getConnection(); 
            PreparedStatement stmt = conct.prepareStatement(checkDisponiblidadeSql)) {

            stmt.setString(1, novaData);
            stmt.setInt(2, especialidadeId); 
            stmt.setInt(3, clinicaId);

            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                int doutorDisponivelId = resultSet.getInt("doctor_id");

            //-------Se a query retornar alguma linha quer dizer que existe um medico sem consulta a essa hora-----------------//
                String updateConsultaSql = "UPDATE consultations SET clinic_name = ? , specialty = ? , date_time = ? WHERE  consultation_id = ?";

                try (PreparedStatement insertStmt = conct.prepareStatement(updateConsultaSql)) {
                    insertStmt.setInt(1, clinicaId);  
                    insertStmt.setInt(2, especialidadeId); 
                    insertStmt.setString(3, novaData);
                    insertStmt.setInt(4, userId);
                    insertStmt.setInt(5, doutorDisponivelId);
                    insertStmt.executeUpdate();

                    return "Consulta atualizada com sucesso";
                }
            } else {
                return "Nao ha medicos disponiveis para a especialidade selecionada na data e hora especificadas";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao verificar disponibilidade de medicos";
        }

    }

    //------------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------(listar Consultas)------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------------------------



    public List<String> listarConsultas(int userID){

        String sql = "SELECT * FROM consultations  WHERE user_id = ?";
        List<String> consultas = new ArrayList<>();
        
        try(Connection conct = DatabaseConnection.getConnection(); PreparedStatement stmt = conct.prepareStatement(sql)){
            
            stmt.setInt(1, userID);
            
            ResultSet resultado = stmt.executeQuery();

            System.out.println("consultas encontradas para "+ userID);
            
            while(resultado.next()){

                String clinicaId  = resultado.getString("clinic_id");
                String especialidadeId = resultado.getString("specialty_id");

                String clinica= "";
                String checkclinicaSql = "SELECT name FROM clinics WHERE clinic_id = ?";
            
            
                try(Connection conct1 = DatabaseConnection.getConnection(); PreparedStatement stmt1 = conct1.prepareStatement(checkclinicaSql)){
                    stmt1.setString(1, clinicaId);

                    ResultSet resultSet = stmt1.executeQuery();
                    if(resultSet.next()){
                        clinica = resultSet.getString("name");
                    }


                }catch(SQLException e){
                    e.printStackTrace();
                }    




                String especialidade= "";
                String checkespecialidadeSql = "SELECT name FROM specialties WHERE specialty_id = ?";

                try(Connection conct2 = DatabaseConnection.getConnection(); PreparedStatement stmt2 = conct2.prepareStatement(checkespecialidadeSql)){
                    stmt2.setString(1, especialidadeId);

                    ResultSet resultSet = stmt2.executeQuery();
                    if(resultSet.next()){
                        especialidade = resultSet.getString("name");
                    }


                }catch(SQLException e){
                    e.printStackTrace();
                }  



                String consulta = "ID: " + resultado.getInt("consultation_id") +
                                      ", Clinic: " + clinica +
                                      ", Specialty: " + especialidade +
                                      ", Date & Time: " + resultado.getString("date_time");

                consultas.add(consulta);
            }


        }catch(SQLException e){
            e.printStackTrace();
        }

        return consultas;

    }

}





