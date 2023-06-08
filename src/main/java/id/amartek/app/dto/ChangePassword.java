package id.amartek.app.dto;

public class ChangePassword {
    private String Email;
    private String OldPassword;
    private String NewPassword;

    public ChangePassword() {
    }

    public ChangePassword(String Email, String OldPassword, String NewPassword) {
        this.Email = Email;
        this.OldPassword = OldPassword;
        this.NewPassword = NewPassword;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getOldPassword() {
        return OldPassword;
    }

    public void setOldPassword(String oldPassword) {
        OldPassword = oldPassword;
    }

    public String getNewPassword() {
        return NewPassword;
    }

    public void setNewPassword(String newPassword) {
        NewPassword = newPassword;
    }

}
