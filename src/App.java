public class App {
    public static void main(String[] args) throws Exception {
        UserService userService = new UserService();

        // Registrando um usuário de teste
        userService.registerUser("testuser@example.com", "testpassword");
    }
}
