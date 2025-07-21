

import java.rmi.RemoteException;
import java.util.List;

import javax.jws.WebService;

public interface ConsultationDetails {
    String reservarConsulta(ConsultaRequest request)throws RemoteException;
    String listarConsultas(int userId) throws RemoteException;
    String updateConsulta(UpdateConsultaRequest request) throws RemoteException;
    String cancelarConsulta(CancelarConsultaRequest request) throws RemoteException;
    String loginUser(UserRequest request) throws RemoteException;
    String RegistarUser(UserRequest request) throws RemoteException;

}