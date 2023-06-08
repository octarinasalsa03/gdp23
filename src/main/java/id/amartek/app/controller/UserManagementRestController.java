package id.amartek.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import id.amartek.app.dto.Login;
import id.amartek.app.dto.Register;
import id.amartek.app.config.JWTGenerator;
import id.amartek.app.dto.ChangePassword;
import id.amartek.app.handler.Response;
import id.amartek.app.model.User;
import id.amartek.app.service.UserService;
import id.amartek.app.service.userManagementService;

@RestController
@RequestMapping("api/user-management")
public class UserManagementRestController {
    @Autowired
    private userManagementService userManagementService;

    @Autowired
    private UserService<User> userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTGenerator jwtGenerator;

    @PostMapping("authentication")
    public ResponseEntity<Object> Login(@RequestBody Login login) {
        // Account account = userManagementService.Login(login.getEmail(),
        // login.getPassword());
        // return Response.generate("berhasil login", HttpStatus.OK, account);
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return Response.generate("success login", HttpStatus.OK, token);
    }

    @PostMapping("register")
    public ResponseEntity<Object> Register(@RequestBody Register register) {
        String hashPassword = passwordEncoder.encode(register.getPassword());
        register.setPassword(hashPassword);
        Boolean result = userManagementService.Register(register);
        if (result) {
            return Response.generate("Register berhasil", HttpStatus.OK);
        }
        return Response.generate("Register gagal", HttpStatus.OK);

    }

    @PostMapping("change-password")
    public ResponseEntity<Object> ChangePassword(@RequestBody ChangePassword changePassword) {
        Boolean result = userManagementService.ChangePassword(changePassword.getEmail(),
                changePassword.getOldPassword(), changePassword.getNewPassword());
        if (result) {
            return Response.generate("Ubah password berhasil", HttpStatus.OK);
        }
        return Response.generate("Ubah password gagal", HttpStatus.OK);
    }

    @PostMapping("forgot-password")
    public ResponseEntity<Object> ForgotPassword(@RequestBody ObjectNode objectNode) {
        String email = objectNode.get("email").asText();
        Boolean result = userManagementService.ForgotPassword(email);
        if (result) {
            return Response.generate("Ubah password berhasil", HttpStatus.OK);
        }
        return Response.generate("Ubah password gagal", HttpStatus.OK);
    }

    @GetMapping("users")
    public ResponseEntity<Object> getUsers() {
        List<User> user = userService.Get();
        return Response.generate("data ditemukan", HttpStatus.OK, user);

    }

}
