package com.RegistrationForm.registrationform.service;

import com.RegistrationForm.registrationform.entity.User;
import com.RegistrationForm.registrationform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public User save(User user){
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User getDetails(String username){

        return userRepository.findByUsername(username);
    }
}
