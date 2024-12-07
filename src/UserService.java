import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    public int loginUser(String username, String password) {
        String sql = "SELECT id FROM users WHERE username = ? AND password = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id"); // Retorna o ID do utilizador.
            } else {
                System.out.println("Credenciais inválidas!");
                return -1; // Login falhou.
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // Retorna -1 em caso de erro.
        }
    }


    public String ResgistarUser(String username, String password) {
        String insertConsultaSql = "INSERT INTO users (email , password) VALUES (?,?)";

        try (Connection connection = DatabaseConnection.getConnection();PreparedStatement stmt = connection.prepareStatement(insertConsultaSql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();

            return "Conta criada com sucesso";
        


        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao verificar disponibilidade de medicos";
        }
    }
}