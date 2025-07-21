

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ConsultaRequest")
public class ConsultaRequest {
	private String clinicName;
    private String specialty;
    private String dateTime;
    private int userId;
    
    public ConsultaRequest() {
    }
    
    public ConsultaRequest(String clinica, String especialidade, String dataHora, int userId) {
        this.clinicName = clinica;
        this.specialty = especialidade;
        this.dateTime = dataHora;
        this.userId = userId;
    }
    
    public String getClinica() {
        return clinicName;
    }

    public void setClinica(String clinica) {
        this.clinicName = clinica;
    }

    public String getEspecialidade() {
        return specialty;
    }

    public void setEspecialidade(String especialidade) {
        this.specialty = especialidade;
    }

    public String getDataHora() {
        return dateTime;
    }

    public void setDataHora(String dataHora) {
        this.dateTime = dataHora;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
