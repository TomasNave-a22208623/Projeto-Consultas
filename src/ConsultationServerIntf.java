import java.rmi.*;
import java.util.List;

public interface ConsultationServerIntf extends Remote{
    void reservarConsulta(String clinicName, String specialty, String dateTime, int userId) throws RemoteException;
    List<String> listarConsultas(int userID) throws RemoteException;
    void updateConsulta(int consultationId, String newClinicName, String newSpecialty, String newDateTime) throws RemoteException;
    void cancelarConsulta(int consultationId) throws RemoteException;
}
