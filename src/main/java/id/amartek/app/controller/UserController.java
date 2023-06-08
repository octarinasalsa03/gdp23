package id.amartek.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.amartek.app.model.Employee;
import id.amartek.app.model.Role;
import id.amartek.app.model.User;
import id.amartek.app.service.EmployeeService;
import id.amartek.app.service.RoleService;
import id.amartek.app.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService<User> userService;
    @Autowired
    private EmployeeService<Employee> employeeService;
    @Autowired
    private RoleService<Role> roleService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userService.Get());
        return "user/index";
    }

    @GetMapping(value = { "form", "form/{id}" })
    public String formUser(@PathVariable(required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("user", userService.Get(id));
            model.addAttribute("employees", employeeService.Get());
            model.addAttribute("roles", roleService.Get());
        } else {
            model.addAttribute("employees", employeeService.Get());
            model.addAttribute("user", new User());
            model.addAttribute("roles", roleService.Get());
        }
        return "user/form";
    }

    @PostMapping("save")
    public String saveUser(User user) {
        Boolean result = userService.Save(user);
        if (result) {
            return "redirect:/user";
        }
        return "user/form";
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id) {
        if (id != null) {
            userService.Delete(id);
        } else {
            return "redirect:/user";
        }
        return "user/index";
    }

}
