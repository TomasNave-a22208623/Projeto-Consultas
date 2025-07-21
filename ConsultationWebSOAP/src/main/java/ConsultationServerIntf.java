import java.rmi.*;

import java.util.List;

public interface ConsultationServerIntf extends Remote{
    String reservarConsulta(String clinicName, String specialty, String dateTime) throws RemoteException;
    List<String> listarConsultas() throws RemoteException;
    String updateConsulta(int consultaId ,String novaData) throws RemoteException;
    String cancelarConsulta(int consultationId) throws RemoteException;
    void setUserSession(int userId) throws RemoteException;
}

