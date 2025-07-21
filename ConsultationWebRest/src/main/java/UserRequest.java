

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UserRequest")
public class UserRequest {
    private String email;
    private String password;
    
    public UserRequest() {
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

}