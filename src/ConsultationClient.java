import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class ConsultationClient {
    public static void main(String[] args) {
        try {
            String serverURL = "rmi://" + "192.168.56.101" + "/ConsultationServer";
            ConsultationServerIntf server = (ConsultationServerIntf) Naming.lookup(serverURL);

            Scanner scanner = new Scanner(System.in);
            boolean isRunning = true; // Controle geral do programa

            UserService userService = new UserService();

            System.out.println("Bem-vindo ao Sistema de Consultas!");

            while (isRunning) { 
                boolean isLoggedIn = false;
                int userId = -1;

                // Menu inicial para login ou registo
                while (!isLoggedIn && isRunning) {
                    System.out.println("\n--- Menu Inicial ---");
                    System.out.println("1. Fazer Login");
                    System.out.println("2. Registar Conta");
                    System.out.println("3. Sair");
                    System.out.print("Escolha uma opção: ");
                    String choice = scanner.next();
                    scanner.nextLine(); 

                    switch (choice) {
                        case "1":
                            // Login
                            System.out.print("Email: ");
                            String username = scanner.nextLine();
                            System.out.print("Password: ");
                            String password = scanner.nextLine();

                            userId = userService.loginUser(username, password);

                            if (userId != -1) {
                                System.out.println("Login realizado com sucesso!");
                                System.out.println("Id: " + userId);
                                server.setUserSession(userId);
                                isLoggedIn = true;
                            } else {
                                System.out.println("Credenciais inválidas. Tente novamente.");
                            }
                            break;

                        case "2":
                            // Registo
                            System.out.print("Email: ");
                            String newUsername = scanner.nextLine();
                            
                            System.out.print("Password: ");
                            String newPassword = scanner.nextLine();

                            String registrationResult = userService.ResgistarUser(newUsername, newPassword);
                            System.out.println(registrationResult);
                            break;

                        case "3":
                            // Sair do programa
                            System.out.println("A encerrar o programa...");
                            isRunning = false;
                            break;

                        default:
                            System.out.println("Opção inválida. Por favor, tente novamente.");
                            break;
                    }
                }

                // Menu principal, se o usuário estiver logado
                while (isLoggedIn && isRunning) {
                    System.out.println("\n--- Menu de Consultas ---");
                    System.out.println("1. Marcar uma consulta");
                    System.out.println("2. Listar todas as consultas");
                    System.out.println("3. Remarcar uma consulta");
                    System.out.println("4. Remover uma consulta");
                    System.out.println("5. Sair");
                    System.out.print("Escolha uma opção: ");

                    String option = scanner.next();
                    scanner.nextLine();
                    String respostaServidor = "";

                    switch (option) {
                        case "1":
                            // Marcar consulta
                            System.out.print("Nome da Clínica: ");
                            String novaClinica = scanner.nextLine();

                            System.out.print("Especialidade: ");
                            String novaEspecialidade = scanner.nextLine();

                            System.out.print("Data e Hora (YYYY-MM-DD HH:MM): ");
                            String novaData = scanner.nextLine();

                            respostaServidor = server.reservarConsulta(novaClinica, novaEspecialidade, novaData);
                            System.out.println(respostaServidor);
                            break;

                        case "2":
                            // Listar consultas
                            List<String> consultas = server.listarConsultas();
                            System.out.println("\n---| Consultas |---");

                            if (consultas.isEmpty()) {
                                System.out.println("Não tem nenhuma consulta agendada.");
                            }

                            for (String consulta : consultas) {
                                System.out.println(consulta);
                            }
                            break;

                        case "3":
                            // Remarcar consulta
                            System.out.print("ID da Consulta a ser atualizada: ");
                            int consultaId = scanner.nextInt();
                            scanner.nextLine(); // Consumir quebra de linha

                            System.out.print("Nova Data e Hora (YYYY-MM-DD HH:MM): ");
                            String novaDataAtualizada = scanner.nextLine();

                            respostaServidor = server.updateConsulta(consultaId, novaDataAtualizada);
                            System.out.println(respostaServidor);
                            break;

                        case "4":
                            // Desmarcar consulta
                            System.out.print("ID da Consulta a ser removida: ");
                            int consultaRemoverId = scanner.nextInt();

                            respostaServidor = server.cancelarConsulta(consultaRemoverId);
                            System.out.println(respostaServidor);
                            break;

                        case "5":
                            // Voltar ao menu inicial
                            System.out.println("Terminando sessão e voltando ao menu inicial...");
                            isLoggedIn = false; // Termina o loop do menu principal
                            break;

                        default:
                            System.out.println("Opção inválida. Por favor, tente novamente.");
                            break;
                    }
                }
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro no cliente RMI: " + e);
            e.printStackTrace();
        }
    }
}