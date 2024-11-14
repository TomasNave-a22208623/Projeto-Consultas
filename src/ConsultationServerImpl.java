import java.util.List;
import java.rmi.*;
import java.rmi.server.*;


public class ConsultationServerImpl extends UnicastRemoteObject implements ConsultationServerIntf {

    private ConsultationService consultationService;

    public ConsultationServerImpl() throws RemoteException {
        this.consultationService = new ConsultationService();
    }

    @Override
    public void reservarConsulta(String clinicName, String specialty, String dateTime, int userId) throws RemoteException {
        consultationService.reservarConsulta(clinicName, specialty, dateTime, userId);
    }

    @Override
    public List<String> listarConsultas(int userID) throws RemoteException {
        return consultationService.listarConsultas(userID);
    }

    @Override
    public void updateConsulta(int consultationId, String novaClinica, String novaEspecialidade, String novaData) throws RemoteException {
        consultationService.updateConsulta(consultationId, novaClinica,novaEspecialidade, novaData);
    }

    @Override
    public void cancelarConsulta(int consultationId) throws RemoteException {
        consultationService.cancelarConsulta(consultationId);
    }
}