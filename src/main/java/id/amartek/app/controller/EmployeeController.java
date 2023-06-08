package id.amartek.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.amartek.app.model.Department;
import id.amartek.app.model.Employee;
import id.amartek.app.service.DepartmentService;
import id.amartek.app.service.EmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService<Employee> employeeService;
    @Autowired
    private DepartmentService<Department> departmentService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("employees", employeeService.Get());
        return "employee/index";
    }

    @GetMapping(value = { "form", "form/{id}" })
    public String form(@PathVariable(required = false) Integer id, Model model) {
        if (id != null) {
            model.addAttribute("employee", employeeService.Get(id));
            model.addAttribute("departments", departmentService.Get());
        } else {
            model.addAttribute("employee", new Employee());
            model.addAttribute("departments", departmentService.Get());
        }
        return "employee/form";
    }

    @PostMapping("save")
    public String save(Employee employee) {
        Boolean result = employeeService.Save(employee);
        if (result) {
            return "redirect:/employee";
        }
        return "employee/form";
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable(required = true) Integer id) {
        if (id != null) {
            employeeService.Delete(id);
        } else {
            return "redirect:/employee";
        }
        return "employee/index";
    }

}
