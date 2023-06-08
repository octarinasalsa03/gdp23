package id.amartek.app.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_m_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    private String Name;
    private Integer Level;

    @JsonIgnore
    @OneToMany(mappedBy = "Role")
    public Set<User> users;

    public Role() {
    }

    public Role(Integer Id, String Name, Integer Level) {
        this.Id = Id;
        this.Name = Name;
        this.Level = Level;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getLevel() {
        return Level;
    }

    public void setLevel(Integer level) {
        Level = level;
    }

}
