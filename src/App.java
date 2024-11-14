import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        UserService userService = new UserService();
            ///yasgdashdjkashfhas
        // Registrando um usuário de test
        
        ConsultationService consultationService = new ConsultationService();

        List<String> consultations = consultationService.listarConsultas(1);
            consultations.forEach(System.out::println);
        
    }
}
