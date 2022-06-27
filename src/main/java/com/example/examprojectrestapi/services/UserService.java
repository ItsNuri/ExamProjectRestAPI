package com.example.examprojectrestapi.services;

import com.example.examprojectrestapi.models.Role;
import com.example.examprojectrestapi.models.User;
import com.example.examprojectrestapi.repositories.RoleRepository;
import com.example.examprojectrestapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    public User saveUser(User user) {
        Role userRole = new Role();
        userRole.setRoleName("USER");
        user.setRole(userRole);
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public User findByEmail(String email) {
        return userRepository.finByEmail(email);
    }

    public User findByEmailAndPassword(String email, String password) {
        User user = findByEmail(email);
        if (user != null) {
            if (encoder.matches(password, user.getPassword())) {
                return user;
            } else {
                throw new BadCredentialsException("invalid");
            }
        }
        throw new BadCredentialsException("invalid");
    }
}
