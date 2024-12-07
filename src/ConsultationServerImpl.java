import java.util.List;
import java.rmi.*;
import java.rmi.server.*;


public class ConsultationServerImpl extends UnicastRemoteObject implements ConsultationServerIntf {

    private ConsultationService consultationService;

    public ConsultationServerImpl() throws RemoteException {
        this.consultationService = new ConsultationService();
    }

    @Override
    public void setUserSession(int userId) throws RemoteException {
        consultationService.setUser(userId);
        System.out.println("Sessão do utilizador definida. ID: " + userId);
    }

    @Override
    public String reservarConsulta(String clinicName, String specialty, String dateTime) throws RemoteException {
        return consultationService.reservarConsulta(clinicName, specialty, dateTime);
    }

    @Override
    public List<String> listarConsultas() throws RemoteException {
        return consultationService.listarConsultas();
    }

    @Override
    public String updateConsulta(int consultaId ,String novaData) throws RemoteException {
        return consultationService.updateConsulta(consultaId, novaData);
    }

    @Override
    public String cancelarConsulta(int consultationId) throws RemoteException {
        return consultationService.cancelarConsulta(consultationId);
    }
}