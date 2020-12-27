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

}
