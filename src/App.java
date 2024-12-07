import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        UserService userService = new UserService();
         // ahahahahahhahahahahahahah
        
        ConsultationServerImpl consult = new ConsultationServerImpl();

        List<String> consultations = consult.listarConsultas();
            consultations.forEach(System.out::println);
        
    }
}
