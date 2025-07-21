package com.consultations;
import java.util.List;
import java.util.Scanner;


public class ConsultationClient {

    public static void main(String[] args) {       
    	
        try { 
        	
        	ConsultationConsumer consultationConsumer = new ConsultationConsumer();
    
            Scanner scanner = new Scanner(System.in);
            boolean isRunning = true; 

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
                            String email = scanner.nextLine();
                            System.out.print("Password: ");
                            String password = scanner.nextLine();

                            System.out.print("\n-------------------------\n\n");
                            List<String> resposta = consultationConsumer.loginUser(email,password);
                            String userIdString = resposta.get(0); 

                            userId = Integer.parseInt(userIdString);

                            if (userId != -1) {
                                System.out.println("Login realizado com sucesso! | Id: " + userId);
                                isLoggedIn = true;
                            }else {
                            	String loginMessage = resposta.get(1); 
                            	System.out.println(loginMessage);
                            }
                            System.out.print("\n-------------------------\n");
                            break;

                        case "2":
                            // Registo
                            System.out.print("Email: ");
                            String newEmail = scanner.nextLine();
                            
                            System.out.print("Password: ");
                            String newPassword = scanner.nextLine();
                            
                            System.out.print("\n-------------------------\n\n");
                            String registrationResult = consultationConsumer.registarUser(newEmail,newPassword);
                            System.out.println(registrationResult);
                            System.out.print("\n-------------------------\n");
                            break;

                        case "3":
                            // Sair do programa
                        	System.out.print("\n-------------------------\n\n");
                            System.out.println("A encerrar o programa...");
                            isRunning = false;
                            System.out.print("\n-------------------------\n");
                            break;

                        default:
                        	System.out.print("\n-------------------------\n\n");
                            System.out.println("Opção inválida. Por favor, tente novamente.");
                            System.out.print("\n-------------------------\n");
                            break;
                    }
                }

               
                while (isLoggedIn && isRunning) {
                    System.out.println("\n--- Menu de Consultas ---");
                    System.out.println("1. Marcar uma consulta");
                    System.out.println("2. Listar todas as consultas");
                    System.out.println("3. Remarcar uma consulta");
                    System.out.println("4. Remover uma consulta");
                    System.out.println("5. Ver consultas possiveis");
                    System.out.println("6. Sair");
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
                            
                            System.out.print("\n-------------------------\n\n");
                            respostaServidor = consultationConsumer.reservarConsulta(novaClinica, novaEspecialidade, novaData, userId);
                            System.out.println(respostaServidor);
                            System.out.print("\n-------------------------\n");
                            break;

                        case "2":
                            // Listar consultas
                            List<String> consultas = consultationConsumer.listarConsultas(userId);
                            System.out.println("\n---| Consultas |---");

                            for (String consulta : consultas) {
                                System.out.println(consulta);
                            }
                            break;

                        case "3":
                        	// Remarcar consultas
                            String consultaId;
                            int consultaIdInt = -1;
                            boolean isValidId = false;

                            while (!isValidId) {
                                System.out.print("ID da Consulta a ser atualizada: ");
                                consultaId = scanner.next();
                                
                                boolean isNumeric = true;
                                for (char c : consultaId.toCharArray()) {
                                    if (!Character.isDigit(c)) {
                                        isNumeric = false;
                                        System.out.println("Erro: O ID da consulta deve ser um número inteiro. Tente novamente.\n");
                                        break;
                                    }
                                }
                                
                                if (isNumeric == true) { 
                                    consultaIdInt = Integer.parseInt(consultaId); 
                                    isValidId = true;
                                } 
                            }

                            scanner.nextLine(); 
                            System.out.print("Nova Data e Hora (YYYY-MM-DD HH:MM): ");
                            String novaDataAtualizada = scanner.nextLine();
                            
                            System.out.print("\n-------------------------\n\n");
                            respostaServidor = consultationConsumer.updateConsulta(consultaIdInt, novaDataAtualizada, userId);
                            System.out.println(respostaServidor);
                            System.out.print("\n-------------------------\n");
                            break;

                        case "4":
                            // Desmarcar consulta
                            String consultaRemoverId;
                            int consultaRemoverIdInt = -1;
                            boolean isValidId1 = false;

                            while (!isValidId1) {
                                System.out.print("ID da Consulta a ser Removido: ");
                                consultaRemoverId = scanner.next();
                                
                                boolean isNumeric = true;
                                for (char c : consultaRemoverId.toCharArray()) {
                                    if (!Character.isDigit(c)) {
                                        isNumeric = false;
                                        System.out.println("Erro: O ID da consulta deve ser um número inteiro. Tente novamente.\n");
                                        break;
                                    }
                                }
                                
                                if (isNumeric == true) { 
                                	consultaRemoverIdInt = Integer.parseInt(consultaRemoverId); 
                                    isValidId1 = true;
                                } 
                            }
                            System.out.print("\n-------------------------\n\n");
                            respostaServidor = consultationConsumer.cancelarConsulta(consultaRemoverIdInt, userId);
                            System.out.println(respostaServidor);
                            System.out.print("\n-------------------------\n");
                            break;
                        
                            
                            
                        case "5":
                            // Especialidades
                        	System.out.println("\n----- Clinicas -----");
                        	System.out.println("\nClinica A:");
                        	System.out.println("\n Especialidades:");
                        	System.out.println("  ClinicaGeral");
                        	System.out.println("  Pediatria");
                        	System.out.println("  Cardiologia");
                        	System.out.println("  Ginecologia");
                        	
                        	System.out.println("\nClinica B:");
                        	System.out.println("\n Especialidades:");
                        	System.out.println("  ClinicaGeral");
                        	System.out.println("  Ginecologia");
                        	System.out.println("  Hematologia");
                        	
                        	
                        	System.out.println("\nClinica C:");
                        	System.out.println("\n Especialidades:");
                        	System.out.println("  Medicina Tropical");
                        	System.out.println("  Neurologia");
                        	
                        	System.out.println("\nClinica D:");
                        	System.out.println("\n Especialidades:");
                        	System.out.println("  Oftalmologia");
                        	System.out.println("  Oncologia");
                        	System.out.println("  Otorrinolaringologia");
                        	System.out.println("\n--------------------");
                        							
                        	
                            break;
                            
                        case "6":
                            // Voltar ao menu inicial
                        	System.out.print("\n-------------------------\n\n");
                            System.out.println("Terminando sessão e voltando ao menu inicial...");
                            isLoggedIn = false; 
                            System.out.print("\n-------------------------\n");
                            break;

                        default:
                        	System.out.print("\n-------------------------\n\n");
                            System.out.println("Opção inválida. Por favor, tente novamente.");
                            System.out.print("\n-------------------------\n");
                            break;
                    }
                }
            }

            scanner.close();
          
          
          } catch (SecurityException e) {

            e.printStackTrace();

          } catch (IllegalArgumentException e) {

            e.printStackTrace();

          } catch (Exception e) {
              System.out.println("Erro no cliente RMI: " + e);
              e.printStackTrace();
          }
    }
}