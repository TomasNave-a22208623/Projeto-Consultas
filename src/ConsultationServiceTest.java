import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;




public class ConsultationServiceTest {

    public ConsultationService ConsultationService = new ConsultationService();

    @Test 
    public void revervarConsulta(){

        // ------------------------- Teste Hora Invalida --------------------------------------------------
        String resultHoraInv = ConsultationService.reservarConsulta("A", "Cardiologia", "2024-11-16 07:00", 1);
        assertEquals("O horario fornecido invalido",resultHoraInv);



        // ------------------------- Teste Minutos Invalidos --------------------------------------------------
        String resultMinutosInv = ConsultationService.reservarConsulta("A", "Cardiologia", "2024-11-16 10:32", 1);
        assertEquals("O horario fornecido invalido",resultMinutosInv);



        // ------------------------- Teste Clinica Invalida --------------------------------------------------
        String resultClinicaInv = ConsultationService.reservarConsulta("H", "Cardiologia", "2024-11-16 10:00", 1);
        assertEquals("A clinica fornecida nao existe",resultClinicaInv);


        // ------------------------- Teste especialidade Invalida --------------------------------------------------
        String resultEspInv = ConsultationService.reservarConsulta("A", "dibil", "2024-11-16 10:00", 1);
        assertEquals("A especialidade fornecido nao existe", resultEspInv);


        // ------------------------- Teste especialidade que nao existe na clinica --------------------------------------------------
        String resultEspCliniInv = ConsultationService.reservarConsulta("C", "Ginecologia", "2024-11-16 10:00", 1);
        assertEquals("A especialidade fornecida nao esta disponivel na clinica fornecida",resultEspCliniInv);



        
        // ------------------------- Teste Medicos não disponivies naquele horario --------------------------------------------------
        ConsultationService.reservarConsulta("C", "Medicina Tropical", "2024-11-16 10:00", 1);
        
        
        String resultMedicosInds = ConsultationService.reservarConsulta("C", "Medicina Tropical", "2024-11-16 10:00", 1);
        assertEquals("Nao ha medicos disponiveis para a especialidade selecionada na data e hora especificadas",resultMedicosInds);



    }



    @Test 
    public void UpdateConsulta(){

        // ------------------------- Teste Hora Invalida --------------------------------------------------
        String resultHoraInv = ConsultationService.reservarConsulta("A", "Cardiologia", "2024-11-16 07:00", 1);
        assertEquals("A clinica fornecido nao existe",resultHoraInv);



        // ------------------------- Teste Minutos Invalidos --------------------------------------------------
        String resultMinutosInv = ConsultationService.reservarConsulta("A", "Cardiologia", "2024-11-16 10:32", 1);
        assertEquals("A clinica fornecido nao existe",resultMinutosInv);



        // ------------------------- Teste Clinica Invalida --------------------------------------------------
        String resultClinicaInv = ConsultationService.reservarConsulta("H", "Cardiologia", "2024-11-16 10:00", 1);
        assertEquals("A clinica fornecido nao existe",resultClinicaInv);


        // ------------------------- Teste especialidade Invalida --------------------------------------------------
        String resultEspInv = ConsultationService.reservarConsulta("A", "dibil", "2024-11-16 10:00", 1);
        assertEquals("A clinica fornecido nao existe", resultEspInv);


        // ------------------------- Teste especialidade que nao existe na clinica --------------------------------------------------
        String resultEspCliniInv = ConsultationService.reservarConsulta("C", "Ginecologia", "2024-11-16 10:00", 1);
        assertEquals("A clinica fornecido nao existe",resultEspCliniInv);



        
        // ------------------------- Teste Medicos não disponivies naquele horario --------------------------------------------------
        ConsultationService.reservarConsulta("C", "Ginecologia", "2024-11-16 10:00", 1);
        
        
        String resultMedicosInds = ConsultationService.reservarConsulta("C", "Ginecologia", "2024-11-16 10:00", 1);
        assertEquals("A clinica fornecido nao existe",resultMedicosInds);



    }




    

}
