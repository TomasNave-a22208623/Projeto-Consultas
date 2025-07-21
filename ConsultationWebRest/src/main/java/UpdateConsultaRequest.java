

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UpdateConsultaRequest")
public class UpdateConsultaRequest {
	private int consultaId;
    private String novaData;
    private int userId;
    
    public UpdateConsultaRequest() {
    }
    
    public UpdateConsultaRequest(int consultaId, String novaData,int userId) {
        this.consultaId = consultaId;
        this.novaData = novaData;
        this.userId = userId;
    }
    
    public int getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(int consultaId) {
        this.consultaId = consultaId;
    }

    public String getNovaData() {
        return novaData;
    }

    public void setNovaData(String novaData) {
        this.novaData = novaData;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
    
}
