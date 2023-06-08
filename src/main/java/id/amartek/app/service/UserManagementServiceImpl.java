package id.amartek.app.service;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.amartek.app.model.Department;
import id.amartek.app.model.Employee;
import id.amartek.app.model.Role;
import id.amartek.app.dto.Account;
import id.amartek.app.dto.Register;
import id.amartek.app.model.User;
import id.amartek.app.repository.UserManagementRepository;

@Service
public class UserManagementServiceImpl implements userManagementService {
    @Autowired
    private UserManagementRepository userManagementRepository;
    @Autowired
    private UserService<User> userService;
    @Autowired
    private EmployeeService<Employee> employeeService;

    @Override
    public Account Login(String Email, String Password) {
        User user = userManagementRepository.Login(Email);
        Account account = new Account();
        Employee employee = user.getEmployee();

        account.setFullname(employee.getFullname());
        account.setEmail(user.getEmail());
        account.setRole(user.getRole());
        return account;

    }

    @Override
    public Boolean Register(Register register) {
        Department department = new Department();
        department.setId(register.getDepartment_id());
        Employee employee = new Employee(null, register.getFullname(), register.getJoindate(),
                register.getNumberphone(), department);
        Boolean result = employeeService.Save(employee);
        if (result) {
            Integer employeeId = userManagementRepository.GetEmployeeId(register.getNumberphone());
            Role role = new Role();
            role.setId(userManagementRepository.GetRoleId());
            User user = new User(employeeId, register.getEmail(), register.getPassword(), role);
            userService.Save(user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean ChangePassword(String Email, String OldPassword, String NewPassword) {
        User user = userManagementRepository.Login(Email);
        if (user != null) {
            user.setPassword(NewPassword);
            userService.Save(user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean ForgotPassword(String email) {
        String newPassword = new SecureRandom().ints(10, '!', '{').collect(StringBuilder::new,
                StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        Integer result = userManagementRepository.UpdateByEmail(newPassword, email);
        if (result == 1) {
            return true;
        }
        return false;
    }

}
