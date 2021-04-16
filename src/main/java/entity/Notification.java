package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Notification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String username;
   
    private String password;
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    


    @Override
    public String toString() {
        return "Notification [ username=" + username + ", password=" + password +  ", role=" + role +  "]";
    }
}
