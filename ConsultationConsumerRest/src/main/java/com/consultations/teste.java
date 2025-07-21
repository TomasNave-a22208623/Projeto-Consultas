package com.consultations;

import java.util.List;

public class teste {

	
	
	public static void main(String[] args) {
		
		try { 
		ConsultationConsumer consultationConsumer = new ConsultationConsumer();	
		
		
		 List<String> consultas = consultationConsumer.listarConsultas(4);
         System.out.println("\n---| Consultas |---");

         if (consultas.isEmpty()) {
             System.out.println("Não tem nenhuma consulta agendada.");
         }

         for (String consulta : consultas) {
             System.out.println(consulta);
         }
		
		
		
		String respostaServidor = consultationConsumer.cancelarConsulta(12, 1);
        System.out.println(respostaServidor);
		
		
		
		
		
	    respostaServidor = consultationConsumer.updateConsulta(12, "2024-12-17 15:00" , 1);
        System.out.println(respostaServidor);
		
		
		
		
		
		
		List<String> resposta = consultationConsumer.loginUser("tomas.silvanave@gmail.com","tominho123");
        String userIdString = resposta.get(0); 
        
        System.out.println("IdString: " + userIdString);

        int userId = Integer.parseInt(userIdString);
        System.out.println("Id: " + userId);

        if (userId != -1) {
            System.out.println("Login realizado com sucesso!");
            System.out.println("Id: " + userId);
            
        }else {
        	String loginMessage = resposta.get(1); 
        	System.out.println(loginMessage);
        }
		
          
     
		
		
		
		
		
          respostaServidor = consultationConsumer.reservarConsulta("A", "Clinica Geral", "2024-12-14 13:00", 1);
          System.out.println(respostaServidor);
		
		
		
		
		
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
