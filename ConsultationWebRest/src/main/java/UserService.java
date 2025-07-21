
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    public List<String> loginUser(String email, String password) {
    	
    	System.out.println(email);
    	System.out.println(password);
    	
    	List<String> listaDeRetornos =  new ArrayList<>();
    	
    	String[] emailRepartido = email.split("@");
    	
    	if(emailRepartido.length != 2) {
    		listaDeRetornos.add("-1");
    		listaDeRetornos.add("O email fornecido tem um formato incorreto");
    		return listaDeRetornos;
    	}

        String partes[] = emailRepartido[1].split("\\.");
        
        if(partes.length != 2) {
        	listaDeRetornos.add("-1");
    		listaDeRetornos.add("O email fornecido tem um formato incorreto");
    		return listaDeRetornos;
    	}
    	
    	
    	
        String sql = "SELECT user_id, password FROM users WHERE email = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");

                String decryptedStoredPassword = PasswordEncryptor.decrypt(storedPassword);

                if (decryptedStoredPassword.equals(password)) {
                	int userId_int = resultSet.getInt("user_id");
                	listaDeRetornos.add(String.valueOf(userId_int));
            		return listaDeRetornos;
                } else {
                	listaDeRetornos.add("-1");
            		listaDeRetornos.add("Credenciais inválidas!");
            		return listaDeRetornos;
                }
            } else {
            	listaDeRetornos.add("-1");
        		listaDeRetornos.add("Email não encontrado!");
        		return listaDeRetornos;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            listaDeRetornos.add("-1");
    		listaDeRetornos.add("Erro ao consultar base de dados");
    		return listaDeRetornos;
        }
    }

    

    public String RegistarUser(String email, String password) {
    	
    	String[] emailRepartido = email.split("@");
    	
    	if(emailRepartido.length != 2) {
    		return "O email fornecido tem um formato incorreto";
    	}

        String partes[] = emailRepartido[1].split("\\.");
        
        if(partes.length != 2) {
    		return "O email fornecido tem um formato incorreto";
    	}
    	
    	
    	
    	
    	String verificarEmailSql = "SELECT user_id FROM users WHERE email = ?";        
        try (Connection connection = DatabaseConnection.getConnection();PreparedStatement stmt = connection.prepareStatement(verificarEmailSql)) {
            stmt.setString(1, email);

            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()) {
            	return "O email fornecido já se encontra associado a uma conta";
            }
        


        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao verificar email";
        }
    
        String insertConsultaSql = "INSERT INTO users (email ,password) VALUES (?,?)";        
        try (Connection connection = DatabaseConnection.getConnection();PreparedStatement stmt = connection.prepareStatement(insertConsultaSql)) {
        	String encryptedPassword = PasswordEncryptor.encrypt(password); 
            stmt.setString(1, email);
            stmt.setString(2, encryptedPassword);
            stmt.executeUpdate();
             
            return "Conta criada com sucesso";
        
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao criar conta";
        }
    }
}