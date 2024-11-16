import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class ConsultationClient {
    public static void main(String[] args) {
        try {
            String serverURL = "rmi://" + args[0] + "/ConsultationServer";
            ConsultationServerIntf server = (ConsultationServerIntf) Naming.lookup(serverURL);

            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            while (!exit) {
                System.out.println("\n--- Menu de Consulta ---");
                System.out.println("1. Adicionar uma consulta");
                System.out.println("2. Listar todas as consultas");
                System.out.println("3. Atualizar uma consulta");
                System.out.println("4. Remover uma consulta");
                System.out.print("Escolha uma opcao: ");
                
                int option = scanner.nextInt();
                scanner.nextLine();

                int userId = 1;
                String respostaServidor = "";

                switch (option) {
                    case 1:
                        
                        System.out.print("Nome da Clinica: ");
                        String novaClinica = scanner.nextLine();

                        System.out.print("Especialidade: ");
                        String novaEspecialidade = scanner.nextLine();

                        System.out.print("Data e Hora (YYYY-MM-DD HH:MM): ");
                        String novaData = scanner.nextLine();
                        
                        respostaServidor = server.reservarConsulta(novaClinica, novaEspecialidade, novaData, userId);
                        System.out.println(respostaServidor);
                        break;

                    case 2:
                        
                        List<String> consultas = server.listarConsultas(userId);
                        System.out.println("\n---| Consultas |---");
                        
                        if(consultas.size()==0){
                            System.out.println("Nao tem nenhuma consulta agendada");
                        }

                        for(String consulta : consultas){
                            System.out.println(consulta);
                        }
                        break;

                    case 3:
                        System.out.print("ID da Consulta a ser atualizada: ");
                        int consultaId = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Novo nome da Clinica: ");
                        novaClinica = scanner.nextLine();

                        System.out.print("Nova Especialidade: ");
                        novaEspecialidade = scanner.nextLine();

                        System.out.print("Nova Data e Hora (YYYY-MM-DD HH:MM): ");
                        novaData = scanner.nextLine();

                        respostaServidor = server.updateConsulta(consultaId, novaClinica, novaEspecialidade, novaData , userId);
                        System.out.println(respostaServidor);
                        break;

                    case 4:
                        System.out.print("ID da Consulta a ser removida: ");
                        consultaId = scanner.nextInt();

                        respostaServidor = server.cancelarConsulta(consultaId);
                        System.out.println(respostaServidor);
                        break;

                    default:
                        System.out.println("Opcao invalida. Por favor, tente novamente.");
                        break;
                }
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro no cliente RMI: " + e);
            e.printStackTrace();
        }
    }
}