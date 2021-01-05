package users;

import javax.persistence.*;

@Entity
@Table(name = "Trippy_Admin")
public class Admin {

    @Id
    @GeneratedValue
    @Column(name = "Admin_ID")
    private int adminID;
    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    public Admin() {

    }

    public Admin(int adminID, String username, String password) {
        this.adminID = adminID;
        this.username = username;
        this.password = password;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

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
}
