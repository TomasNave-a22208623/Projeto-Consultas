import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsultationService {

    public String reservarConsulta(String clinica , String especialidade , String dataHora , int userId ){
        
        //-------------------------------Verificar se o horario é valido------------------------------------------------------------//
        
        List<String> horasValidos = Arrays.asList("08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00");

        String hora = dataHora.split(" ")[1];

        if(!horasValidos.contains(hora)){
            return "O horario fornecido invalido";
        }
        

        //-------------------------------Verificar se a clinica recebida existe---------------------------------------------------------//
        int clinicaId = -1;
        String checkclinicaSql = "SELECT clinic_id FROM clinics WHERE name = ?";
        try(Connection conct = DatabaseConnection.getConnection(); PreparedStatement stmt = conct.prepareStatement(checkclinicaSql)){
            stmt.setString(1, clinica);

            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){
                clinicaId = resultSet.getInt("clinic_id");
            }else{
                return "A clinica fornecido nao existe";
            }


        }catch(SQLException e){
            e.printStackTrace();
            return "Erro ao verificar a clínica fornecida";
        }

        //-----------------------------Verificar se a especialidade recebida existe-------------------------------------------------//

        int especialidadeId = -1;
        String checkEspecialidadeSql = "SELECT specialty_id FROM specialties WHERE name = ?";
        try(Connection conct = DatabaseConnection.getConnection(); PreparedStatement stmt = conct.prepareStatement(checkEspecialidadeSql)){
            stmt.setString(1, especialidade);

            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){
                clinicaId = resultSet.getInt("specialty_id");
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
            return "Erro ao verificar a disponibilidade da especialidade na clínica";
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
                return "Nao ha medicos disponíveis para a especialidade selecionada na data e hora especificadas";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao verificar disponibilidade de médicos";
        }

    }
    


    public void cancelarConsulta(int consultationId){
        String sql = "DELETE FROM consultations WHERE  consultation_id = ?";
        
        try(Connection conct = DatabaseConnection.getConnection(); PreparedStatement stmt = conct.prepareStatement(sql)){
            stmt.setInt(1, consultationId);
            stmt.executeUpdate();

            System.out.println("Consulta removida com sucesso!!");


        }catch(SQLException e){
            e.printStackTrace();
        }

    }


    public void updateConsulta(int consultationId , String novaclinica , String novaEspecialidade , String novaData){
        String sql = "UPDATE consultations SET clinic_name = ? , specialty = ? , date_time = ? WHERE  consultation_id = ?";
        
        try(Connection conct = DatabaseConnection.getConnection(); PreparedStatement stmt = conct.prepareStatement(sql)){
            stmt.setString(1, novaclinica);
            stmt.setString(2, novaEspecialidade);
            stmt.setString(3, novaData);
            stmt.setInt(4, consultationId);
            stmt.executeUpdate();

            System.out.println("Consulta alterada com sucesso!!");


        }catch(SQLException e){
            e.printStackTrace();
        }



    }

    public List<String> listarConsultas(int userID){

        String sql = "SELECT * FROM consultations  WHERE user_id = ?";
        List<String> consultas = new ArrayList<>();
        
        try(Connection conct = DatabaseConnection.getConnection(); PreparedStatement stmt = conct.prepareStatement(sql)){
            
            stmt.setInt(1, userID);
            
            ResultSet resultado = stmt.executeQuery();

            System.out.println("consultas encontradas para "+ userID);
            
            while(resultado.next()){
                String consulta = "ID: " + resultado.getInt("consultation_id") +
                                      ", Clinic: " + resultado.getString("clinic_name") +
                                      ", Specialty: " + resultado.getString("specialty") +
                                      ", Date & Time: " + resultado.getString("date_time");

                consultas.add(consulta);
            }


        }catch(SQLException e){
            e.printStackTrace();
        }

        return consultas;

    }

}
 







