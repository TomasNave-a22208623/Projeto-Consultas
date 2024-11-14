import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultationService {

    public void reservarConsulta(String clinica , String especialidade , String dataHora , int userId ){
        /*Exemplo de Date Time : "2024-10-27 19:00" */

        String sql = "INSERT INTO consultations (clinic_name , specialty, date_time , user_id) VALUES (?,?,?,?)";

        try(Connection conct = DatabaseConnection.getConnection(); PreparedStatement stmt = conct.prepareStatement(sql)){
            stmt.setString(1, clinica);
            stmt.setString(2, especialidade);
            stmt.setString(3, dataHora);
            stmt.setInt(4, userId);
            stmt.executeUpdate();

            System.out.println("Consulta marcada com sucesso!!");


        }catch(SQLException e){
            e.printStackTrace();
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


    public void updateConsulta(int consultationId , String novaClinica , String novaEspecialidade , String novaData){
        String sql = "UPDATE consultations SET clinic_name = ? , specialty = ? , date_time = ? WHERE  consultation_id = ?";
        
        try(Connection conct = DatabaseConnection.getConnection(); PreparedStatement stmt = conct.prepareStatement(sql)){
            stmt.setString(1, novaClinica);
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
 







