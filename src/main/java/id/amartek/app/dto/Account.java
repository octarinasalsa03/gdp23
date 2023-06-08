package id.amartek.app.dto;

import id.amartek.app.model.Role;

public class Account {
    private String Fullname;
    private String Email;
    private Role Role;

    public Account() {
    }

    public Account(String Fullname, String Email, Role Role) {
        this.Fullname = Fullname;
        this.Email = Email;
        this.Role = Role;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Role getRole() {
        return Role;
    }

    public void setRole(Role role) {
        Role = role;
    }

}
