
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;
import javax.ws.rs.QueryParam;


	@Consumes("application/json")
	@Produces("application/json")
	public class ConsultationDetailsImpl implements ConsultationDetails{

		
		

	    @POST
	    @Path("/reservarConsulta")
	    public String reservarConsulta(ConsultaRequest request)throws RemoteException {
	    	
            try {
            	
            	
            	System.out.println("Conectando ao RMI...");
                String serverURL = "rmi://" + "192.168.56.101" + "/ConsultationServer"; 
                ConsultationServerIntf server = (ConsultationServerIntf) Naming.lookup(serverURL); 
                System.out.println("Conectado ao RMI...");
                server.setUserSession(request.getUserId());   
                return server.reservarConsulta(request.getClinica(), request.getEspecialidade(), request.getDataHora());
            } catch (Exception e) {
                System.out.println("Exception: " + e);
                throw new RemoteException("Falhou ao reservar consulta", e);
            }
        }

	    @GET
	    @Path("/listarConsultas")
	    public String listarConsultas(@QueryParam("userId") int userId) throws RemoteException {
	        try {
	            System.out.println("Conectando ao RMI...");
	            String serverURL = "rmi://192.168.56.101/ConsultationServer";
	            ConsultationServerIntf server = (ConsultationServerIntf) Naming.lookup(serverURL);
	            System.out.println("Conectado ao RMI...");
	            server.setUserSession(userId);

	            List<String> resposta = server.listarConsultas();

	            if (resposta != null && !resposta.isEmpty()) {
	                StringBuilder responseBuilder = new StringBuilder();
	                for (String item : resposta) {
	                    responseBuilder.append(item).append(";");
	                }
	                return responseBuilder.toString().trim();
	            } else {
	                return "Não tem nenhuma consulta agendada.";
	            }
	        } catch (Exception e) {
	            System.out.println("Exception: " + e);
	            throw new RemoteException("Falhou ao listar consultas", e);
	        }
	    }
	    
	    


	    @POST
	    @Path("/updateConsulta")
	    public String updateConsulta(UpdateConsultaRequest request) throws RemoteException {
            try {
            	  System.out.println("Conectando ao RMI...");
                  String serverURL = "rmi://" + "192.168.56.101" + "/ConsultationServer"; 
                             ConsultationServerIntf server = (ConsultationServerIntf) Naming.lookup(serverURL); 
                  System.out.println("Conectado ao RMI...");
                  server.setUserSession(request.getUserId());
                  return server.updateConsulta(request.getConsultaId() ,request.getNovaData());
                }
                catch(Exception e) {
                  System.out.println("Exception: " + e);
                  throw new RemoteException("Falhou ao remarcar consulta", e);
                }
        }

	    
	    
	    
	    
	    
	    @POST
	    @Path("/cancelarConsulta")
		public String cancelarConsulta(CancelarConsultaRequest request) throws RemoteException {
	    	try {
	    	      String serverURL = "rmi://" + "192.168.56.101" + "/ConsultationServer"; 
	    	                 ConsultationServerIntf server = (ConsultationServerIntf) Naming.lookup(serverURL);
	    	      
	    	      int userId = request.getUserId();
	    	      System.out.println(userId);
	    	      server.setUserSession(userId);
	    	      int consultationId = request.getConsultationId();
	    	      System.out.println(consultationId);
	    	      return server.cancelarConsulta(consultationId);
	    	    }
	    	    catch(Exception e) {
	    	      System.out.println("Exception: " + e);
	    	      throw new RemoteException("Falhou ao cancelar consulta", e);
	    	    }
	    }

	    @POST
	    @Path("/loginUser")
		 public String loginUser(UserRequest request) throws RemoteException {
	        try {
	             UserService userService = new UserService(); 
	             List<String> resposta = userService.loginUser(request.getEmail() , request.getPassword());
	             StringBuilder responseBuilder = new StringBuilder();
	             for (String item : resposta) {
	                 responseBuilder.append(item).append(";"); 
	             }
	             
	              return responseBuilder.toString().trim();
	            }
	            catch(Exception e) {
	              System.out.println("Exception: " + e);
	              throw new RemoteException("Falhou ao fazer login", e);
	            }
	   }

	    @POST
	    @Path("/RegistarUser")
		 public String RegistarUser(UserRequest request) throws RemoteException {
	        try {
	             UserService userService = new UserService();             
	              return userService.RegistarUser(request.getEmail() , request.getPassword());
	            }
	            catch(Exception e) {
	              System.out.println("Exception: " + e);
	              throw new RemoteException("Falhou ao fazer login", e);
	            }
	    }
	}