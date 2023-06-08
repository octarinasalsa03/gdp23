package id.amartek.app.dto;

public class Register {

    public String email;
    public String password;
    public String fullname;
    public String joindate;
    public String numberphone;
    public Integer department_id;

    public Register() {
    }

    public Register(String email, String password, String fullname, String joindate,
            String numberphone, Integer department_id) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.joindate = joindate;
        this.numberphone = numberphone;
        this.department_id = department_id;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

}
