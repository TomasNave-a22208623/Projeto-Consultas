


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CancelarConsultaRequest")
public class CancelarConsultaRequest {
    private int consultationId;
    private int userId;
    
    public CancelarConsultaRequest() {
    }

    public int getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(int consultationId) {
        this.consultationId = consultationId;
    }
    
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}