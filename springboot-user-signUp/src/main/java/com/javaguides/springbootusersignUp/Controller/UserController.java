package com.javaguides.springbootusersignUp.Controller;


import com.javaguides.springbootusersignUp.Service.UserService;
import com.javaguides.springbootusersignUp.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserDTO userDTO) {
        userService.signUp(userDTO);
        return ResponseEntity.ok("User registered successfully");
    }


    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestParam String email) {
        userService.forgotPassword(email);
        return ResponseEntity.ok("Password reset instructions sent to your email");
    }
}