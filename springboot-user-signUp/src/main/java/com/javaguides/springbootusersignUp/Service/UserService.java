package com.javaguides.springbootusersignUp.Service;

import com.javaguides.springbootusersignUp.Models.User;
import com.javaguides.springbootusersignUp.Repository.UserRepository;
import com.javaguides.springbootusersignUp.dto.UserDTO;
import com.javaguides.springbootusersignUp.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;

    public void signUp(UserDTO userDTO) {
        // Implement validation, password hashing, etc., before saving to MongoDB
        // For example:
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        userRepository.save(user);
    }

    public void forgotPassword(String email) {
        // Implement logic to generate a reset token, save it in the user document, and send reset instructions via email
        // For example:
        User user = userRepository.findByEmail(email);
        if (user != null) {
            String resetToken = generateResetToken();
            user.setResetToken(resetToken);
            userRepository.save(user);

            emailService.sendResetPasswordEmail(user.getEmail(), resetToken);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    private String generateResetToken() {
        // Implement token generation logic
        return UUID.randomUUID().toString();
    }
}
