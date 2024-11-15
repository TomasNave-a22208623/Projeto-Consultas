import java.net.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ConsultationServer {
    public static void main(String[] args) throws MalformedURLException {
        try{
            ConsultationServerImpl serverImpl = new ConsultationServerImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            Naming.rebind("ConsultationServer",serverImpl);
            System.out.println("Servidor RMI iniciado com sucesso");

        }catch (RemoteException e){
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }



    }
}
