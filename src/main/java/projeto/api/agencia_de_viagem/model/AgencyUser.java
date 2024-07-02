package projeto.api.agencia_de_viagem.model;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class AgencyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;
    private String role;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getUser() {return username;}

    public void setUser(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}


    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public AgencyUser convertToEntity (Long id, String name, String username, String password, String role) {
        AgencyUser agencyUser = new AgencyUser();

        agencyUser.setId(id);
        agencyUser.setName(name);
        agencyUser.setUser(username);
        agencyUser.setPassword(new BCryptPasswordEncoder().encode(password));
        agencyUser.setRole(role);

        return agencyUser;
    }

}
