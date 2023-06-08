package id.amartek.app.service;

import id.amartek.app.dto.Account;
import id.amartek.app.dto.Register;
import id.amartek.app.model.Employee;
import id.amartek.app.model.User;

public interface userManagementService {

    public Account Login(String Email, String Password);

    public Boolean Register(Register register);

    public Boolean ChangePassword(String Email, String OldPassword, String NewPassword);

    public Boolean ForgotPassword(String Email);

}
