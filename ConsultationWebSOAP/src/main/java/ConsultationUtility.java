import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import javax.jws.WebService;

@WebService(targetNamespace = "http://default_package/", portName = "ConsultationUtilityPort", serviceName = "ConsultationUtilityService")
public class ConsultationUtility {
	
	public String reservarConsulta(String clinicName, String specialty, String dateTime, int userId ) throws RemoteException {
    	try {
    	      String serverURL = "rmi://" + "192.168.56.101" + "/ConsultationServer"; 
    	                 ConsultationServerIntf server = (ConsultationServerIntf) Naming.lookup(serverURL); 
    	      
    	      server.setUserSession(userId);           
    	      return server.reservarConsulta(clinicName, specialty, dateTime);
    	    }
    	    catch(Exception e) {
    	      System.out.println("Exception: " + e);
    	      throw new RemoteException("Falhou ao reservar consulta", e);
    	    }
    }    
	
	
	public List<String> listarConsultas(int userId) throws RemoteException {
    	try {
    	      String serverURL = "rmi://" + "192.168.56.101" + "/ConsultationServer"; 
    	                 ConsultationServerIntf server = (ConsultationServerIntf) Naming.lookup(serverURL); 
    	      server.setUserSession(userId);
    	      return server.listarConsultas();
    	    }
    	    catch(Exception e) {
    	      System.out.println("Exception: " + e);
    	      throw new RemoteException("Falhou ao listar consultas", e);
    	    }
    } 
	
	
	public String updateConsulta(int consultaId ,String novaData, int userId) throws RemoteException {
    	try {
    	      String serverURL = "rmi://" + "192.168.56.101" + "/ConsultationServer"; 
    	                 ConsultationServerIntf server = (ConsultationServerIntf) Naming.lookup(serverURL); 
    	      server.setUserSession(userId);
    	      return server.updateConsulta(consultaId ,novaData);
    	    }
    	    catch(Exception e) {
    	      System.out.println("Exception: " + e);
    	      throw new RemoteException("Falhou ao remarcar consulta", e);
    	    }
    }
	
	public String cancelarConsulta(int consultationId, int userId) throws RemoteException {
    	try {
    	      String serverURL = "rmi://" + "192.168.56.101" + "/ConsultationServer"; 
    	                 ConsultationServerIntf server = (ConsultationServerIntf) Naming.lookup(serverURL); 
    	      server.setUserSession(userId);
    	      return server.cancelarConsulta(consultationId);
    	    }
    	    catch(Exception e) {
    	      System.out.println("Exception: " + e);
    	      throw new RemoteException("Falhou ao cancelar consulta", e);
    	    }
    }
	
	public List<String> loginUser(String email, String password) throws RemoteException {
        try {
             UserService userService = new UserService();             
              return userService.loginUser(email , password);
            }
            catch(Exception e) {
              System.out.println("Exception: " + e);
              throw new RemoteException("Falhou ao fazer login", e);
            }
   }

 public String RegistarUser(String email, String password) throws RemoteException {
        try {
             UserService userService = new UserService();             
              return userService.RegistarUser(email , password);
            }
            catch(Exception e) {
              System.out.println("Exception: " + e);
              throw new RemoteException("Falhou ao fazer login", e);
            }
    }
	
	
	

}
