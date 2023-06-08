package id.amartek.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.amartek.app.handler.Response;
import id.amartek.app.model.Employee;
import id.amartek.app.service.EmployeeService;

@RestController
@RequestMapping("api")
public class EmployeeRestController {
    @Autowired
    private EmployeeService<Employee> employeeService;

    @GetMapping("employee")
    public ResponseEntity<Object> Get() {
        return Response.generate("data ditemukan", HttpStatus.OK, employeeService.Get());
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<Object> Get(@PathVariable(required = true) Integer id) {
        Optional<Employee> employee = employeeService.Get(id);
        if (employee.isPresent()) {
            return Response.generate("data ditemukan", HttpStatus.OK, employee);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK, null);
    }

}
