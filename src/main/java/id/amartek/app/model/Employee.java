package id.amartek.app.model;

import javax.persistence.*;

@Entity
@Table(name = "tb_m_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    private String Fullname;
    private String Joindate;
    private String Numberphone;
    @ManyToOne(optional = false)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    public Employee() {
    }

    public Employee(Integer Id, String Fullname, String Joindate, String Numberphone, Department department) {
        this.Id = Id;
        this.Fullname = Fullname;
        this.Joindate = Joindate;
        this.Numberphone = Numberphone;
        this.department = department;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getJoindate() {
        return Joindate;
    }

    public void setJoindate(String joindate) {
        Joindate = joindate;
    }

    public String getNumberphone() {
        return Numberphone;
    }

    public void setNumberphone(String numberphone) {
        Numberphone = numberphone;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
