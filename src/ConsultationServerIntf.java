import java.rmi.*;
import java.util.List;

public interface ConsultationServerIntf extends Remote{
    String reservarConsulta(String clinicName, String specialty, String dateTime, int userId) throws RemoteException;
    List<String> listarConsultas(int userID) throws RemoteException;
    String updateConsulta(int consultaId ,String novaData , int userId) throws RemoteException;
    String cancelarConsulta(int consultationId) throws RemoteException;
}
