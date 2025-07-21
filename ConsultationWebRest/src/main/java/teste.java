import java.util.List;

public class teste {

	
	public static void main(String[] args) {
		
		
		
		
		try { 
	ConsultationDetailsImpl consultationConsumer = new ConsultationDetailsImpl();		
	
	ConsultaRequest consulta1 = new ConsultaRequest("A", "Clinica Geral", "2024-12-14 13:00", 1);

	CancelarConsultaRequest cancelar = new CancelarConsultaRequest();
	
	cancelar.setConsultationId(14);
	cancelar.setUserId(1);
	

	String consultas = consultationConsumer.listarConsultas(4);
    System.out.println("\n---| Consultas |---");


        System.out.println(consultas);
    
	
	String respostaServidor = consultationConsumer.cancelarConsulta(cancelar);
    System.out.println(respostaServidor);
	
	
	
	
	 respostaServidor = consultationConsumer.reservarConsulta(consulta1);
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
