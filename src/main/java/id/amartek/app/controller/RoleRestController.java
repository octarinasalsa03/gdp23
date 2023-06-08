package id.amartek.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.amartek.app.handler.Response;
import id.amartek.app.model.Role;
import id.amartek.app.service.RoleService;

@RestController
@RequestMapping("api")
public class RoleRestController {
    @Autowired
    private RoleService<Role> roleService;

    @GetMapping("role")
    public ResponseEntity<Object> Get() {
        return Response.generate("data tidak ditemukan", HttpStatus.OK, roleService.Get());
    }

    @GetMapping("role/{id}")
    public ResponseEntity<Object> Get(Integer id) {
        Optional<Role> role = roleService.Get(id);
        if (role.isPresent()) {
            return Response.generate("data ditemukan", HttpStatus.OK, role);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK, null);
    }

    @PostMapping("role")
    public ResponseEntity<Object> Save(Role role) {
        Boolean result = roleService.Save(role);
        if (result) {
            return Response.generate("data berhasil dimasukkan", HttpStatus.OK);
        }
        return Response.generate("data gagal dimasukkan", HttpStatus.OK);
    }

    @PostMapping("role/{id}")
    public ResponseEntity<Object> Delete(Integer id) {
        Boolean result = roleService.Delete(id);
        if (result) {
            return Response.generate("data berhasil dihapus", HttpStatus.OK);
        }
        return Response.generate("data gagal dihapus", HttpStatus.OK);
    }

}
