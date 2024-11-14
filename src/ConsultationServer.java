import java.net.*;
import java.rmi.*;

public class ConsultationServer {
    public static void main(String[] args) throws MalformedURLException {
        try{
            ConsultationServerImpl serverImpl = new ConsultationServerImpl();
            Naming.rebind("ConsultationServer",serverImpl);
            System.out.println("Servidor RMI iniciado com sucesso");

        }catch (RemoteException e){
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }



    }
}
