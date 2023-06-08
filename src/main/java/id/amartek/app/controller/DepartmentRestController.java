package id.amartek.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.amartek.app.handler.Response;
import id.amartek.app.model.Department;
import id.amartek.app.service.DepartmentService;

@RestController
@RequestMapping("api")
public class DepartmentRestController {
    @Autowired
    private DepartmentService<Department> departmentService;

    @GetMapping("department")
    public ResponseEntity<Object> Get() {
        // return departmentService.Get();
        return Response.generate("data ditemukan", HttpStatus.OK, departmentService.Get());

    }

    @GetMapping("department/{id}")
    public ResponseEntity<Object> Get(@PathVariable(required = true) Integer id) {
        Optional<Department> department = departmentService.Get(id);
        if (department.isPresent()) {
            return Response.generate("data ditemukan", HttpStatus.OK, department);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK, null);

    }

    @PostMapping("department")
    public ResponseEntity<Object> save(@RequestBody Department department) {
        Boolean result = departmentService.Save(department);
        if (result) {
            return Response.generate("Data berhasil dimasukkan!", HttpStatus.OK);
            // return true;
        }
        return Response.generate("Data gagal dimasukkan", HttpStatus.OK);
    }

    @DeleteMapping("department/{id}")
    public ResponseEntity<Object> Delete(@PathVariable(required = true) Integer id) {
        Boolean result = departmentService.Delete(id);
        if (result) {
            return Response.generate("Data berhasil dihapus!", HttpStatus.OK);
        }
        return Response.generate("Data gagal dihapus", HttpStatus.OK);
    }

}
