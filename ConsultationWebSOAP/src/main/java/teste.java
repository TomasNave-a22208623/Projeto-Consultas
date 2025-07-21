import java.rmi.RemoteException;
import java.util.List;

public class teste {

	public static void main(String[] args) throws RemoteException {
		
		ConsultationUtility consultation = new ConsultationUtility();
		
		List<String> resposta = consultation.loginUser("tomas.silvanave@gmail.com", "tominho123");
        String userIdString = resposta.get(0); 
        
        System.out.println("IdString: " + userIdString);

        int userId = Integer.parseInt(userIdString);
        System.out.println("Id: " + userId);

        if (userId != -1) {
            System.out.println("Login realizado com sucesso!");
            System.out.println("Id: " + userId);
            
        }else {
        	String loginMessage = resposta.get(1); 
        	System.out.println(loginMessage);
        }
        
	
	}
}
