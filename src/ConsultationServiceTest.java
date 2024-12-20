import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;




public class ConsultationServiceTest {

    public ConsultationService ConsultationService = new ConsultationService();

    @Test 
    public void revervarConsulta(){

        ConsultationService.setUser(2);

        /* 

        // ------------------------- Teste Hora Invalida --------------------------------------------------
        String resultHoraInv = ConsultationService.reservarConsulta("A", "Cardiologia", "2024-11-16 07:00");
        assertEquals("O horario fornecido invalido",resultHoraInv);



        // ------------------------- Teste Minutos Invalidos --------------------------------------------------
        String resultMinutosInv = ConsultationService.reservarConsulta("A", "Cardiologia", "2024-11-16 10:32");
        assertEquals("O horario fornecido invalido",resultMinutosInv);



        // ------------------------- Teste Clinica Invalida --------------------------------------------------
        String resultClinicaInv = ConsultationService.reservarConsulta("H", "Cardiologia", "2024-11-16 10:00");
        assertEquals("A clinica fornecida nao existe",resultClinicaInv);


        // ------------------------- Teste especialidade Invalida --------------------------------------------------
        String resultEspInv = ConsultationService.reservarConsulta("A", "dibil", "2024-11-16 10:00" );
        assertEquals("A especialidade fornecido nao existe", resultEspInv);


        // ------------------------- Teste especialidade que nao existe na clinica --------------------------------------------------
        String resultEspCliniInv = ConsultationService.reservarConsulta("C", "Ginecologia", "2024-11-16 10:00");
        assertEquals("A especialidade fornecida nao esta disponivel na clinica fornecida",resultEspCliniInv);



        
        // ------------------------- Teste Medicos não disponivies naquele horario --------------------------------------------------
        ConsultationService.reservarConsulta("C", "Medicina Tropical", "2024-11-16 10:00");
        
        
        String resultMedicosInds = ConsultationService.reservarConsulta("C", "Medicina Tropical", "2024-11-16 10:00");
        assertEquals("Nao ha medicos disponiveis para a especialidade selecionada na data e hora especificadas",resultMedicosInds);



        
        ConsultationService.reservarConsulta("C", "Medicina Tropical", "2024-11-16 10:00");
        
*/
        
        
        String resultfev = ConsultationService.reservarConsulta("A", "Clinica Geral", "2025-14-30 13:00");
        assertEquals("A data fornecida não é válida. Verifique o número de dias do mês.",resultfev );



    }



    @Test
    public void listarConsultas(){
        

        List<String> lista = ConsultationService.listarConsultas();
        assertEquals("aaaa",lista);
        
    }

    @Test
    public void cancelarConsulta(){
        
        // ------------------------- Teste ID invalido --------------------------------------------------
        String resultIdNaoEncontrado = ConsultationService.cancelarConsulta(20);
        assertEquals("A consulta fornecida nao existe",resultIdNaoEncontrado);


        // ------------------------- Teste ID invalido --------------------------------------------------
        String resultIdValido = ConsultationService.cancelarConsulta(10);
        assertEquals("A consulta foi desmarcada com sucesso",resultIdValido);

        
    }


    @Test 
    public void UpdateConsulta(){

        // ------------------------- Teste Hora Invalida --------------------------------------------------
        String resultHoraInv = ConsultationService.updateConsulta(8,"2024-11-16 11:00");
        assertEquals("Horario fornecido invalido",resultHoraInv);



        // ------------------------- Teste Minutos Invalidos --------------------------------------------------
        String resultMinutosInv = ConsultationService.updateConsulta(2,"2024-11-16 10:32");
        assertEquals("Horario fornecido invalido",resultMinutosInv);


        // ------------------------- Teste Medicos não disponivies naquele horario --------------------------------------------------
        //se quisermos falta adicionar este teste!!!!!!!!!!!!!!!!!!!!!!

    }



    

}
