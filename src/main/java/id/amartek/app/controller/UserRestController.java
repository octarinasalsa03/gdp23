package id.amartek.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.amartek.app.handler.Response;
import id.amartek.app.model.User;
import id.amartek.app.service.UserService;

@RestController
@RequestMapping("api")
public class UserRestController {
    @Autowired
    private UserService<User> userService;

    @GetMapping("user")
    public ResponseEntity<Object> Get() {
        return Response.generate("data berhasil ditemukan", HttpStatus.OK, userService.Get());
    }

    @GetMapping("user/{id}")
    public ResponseEntity<Object> Get(Integer id) {
        Optional<User> user = userService.Get(id);
        if (user.isPresent()) {
            return Response.generate("data berhasil ditemukan", HttpStatus.OK, user);
        }
        return Response.generate("data tidak ditemukan", HttpStatus.OK, null);
    }

    @PostMapping("user")
    public ResponseEntity<Object> Save(User user) {
        Boolean result = userService.Save(user);
        if (result) {
            return Response.generate("data berhasil dimasukkan", HttpStatus.OK);
        }
        return Response.generate("data gagal dimasukkan", HttpStatus.OK);
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<Object> Delete(Integer id) {
        Boolean result = userService.Delete(id);
        if (result) {
            return Response.generate("data berhasil dihapus", HttpStatus.OK);
        }
        return Response.generate("data gagal dihapus", HttpStatus.OK);
    }
}
