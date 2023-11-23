package com.javaguides.springbootusersignUp.Controller;
import com.javaguides.springbootusersignUp.Service.AuthService;
import com.javaguides.springbootusersignUp.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody LoginDTO loginDTO) {
        String token = authService.signIn(loginDTO);
        return ResponseEntity.ok(token);
    }
}