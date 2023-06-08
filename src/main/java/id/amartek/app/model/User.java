package id.amartek.app.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_m_user")
public class User {
    @Id
    @Column(name = "id")
    private Integer Id;
    private String Email;
    private String Password;
    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role Role;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Employee employee;

    public User() {
    }

    public User(Integer Id, String Email, String Password, Role role) {
        this.Id = Id;
        this.Email = Email;
        this.Password = Password;
        this.Role = role;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Role getRole() {
        return Role;
    }

    public void setRole(Role role) {
        Role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
