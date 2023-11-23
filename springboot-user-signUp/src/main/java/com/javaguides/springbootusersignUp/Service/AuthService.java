package com.javaguides.springbootusersignUp.Service;

import com.javaguides.springbootusersignUp.Config.JwtTokenUtil;
import com.javaguides.springbootusersignUp.Models.User;
import com.javaguides.springbootusersignUp.Repository.UserRepository;
import com.javaguides.springbootusersignUp.dto.LoginDTO;
import com.javaguides.springbootusersignUp.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public String signIn(LoginDTO loginDTO) {
        // Implement user authentication logic (check credentials, etc.)
        // For example:
        User user = userRepository.findByEmail(loginDTO.getEmail());
        if (user != null && passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            return jwtTokenUtil.generateToken(user);
        } else {
            throw new UnauthorizedException("Invalid credentials");
        }
    }
}

