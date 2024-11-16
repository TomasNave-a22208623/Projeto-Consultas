import java.util.List;
import java.rmi.*;
import java.rmi.server.*;


public class ConsultationServerImpl extends UnicastRemoteObject implements ConsultationServerIntf {

    private ConsultationService consultationService;

    public ConsultationServerImpl() throws RemoteException {
        this.consultationService = new ConsultationService();
    }

    @Override
    public String reservarConsulta(String clinicName, String specialty, String dateTime, int userId) throws RemoteException {
        return consultationService.reservarConsulta(clinicName, specialty, dateTime, userId);
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
    public String cancelarConsulta(int consultationId) throws RemoteException {
        return consultationService.cancelarConsulta(consultationId);
    }
}