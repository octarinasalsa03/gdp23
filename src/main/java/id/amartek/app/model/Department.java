package id.amartek.app.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_m_department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    private String Name;
    @ManyToOne(optional = false)
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    private Region region;

    @ManyToOne(optional = false)
    @JoinColumn(name = "division_id", referencedColumnName = "id")
    private Division division;

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    public Set<Employee> employees;

    public Department() {
    }

    public Department(Integer Id, String Name, Region region, Division division) {
        this.Id = Id;
        this.Name = Name;
        this.region = region;
        this.division = division;
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
