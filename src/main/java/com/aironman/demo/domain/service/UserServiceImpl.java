package com.aironman.demo.domain.service;

import com.aironman.demo.domain.model.User;
import com.aironman.demo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void initialize(){

        //User(String username, String password, String name, String email)
        User aUser = new User("username",
                                bCryptPasswordEncoder.encode("password"),
                "name",
                "email@email.me");
        userRepository.save(aUser);

        User anotherUser = new User("username1",bCryptPasswordEncoder.encode("password1"),"name1","email1@email.me");
        userRepository.save(anotherUser);
    }

    @Transactional
    public User create(User user) {

        String encryptedPass = bCryptPasswordEncoder.encode(user.getPassword());
        System.out.println("Encrypted pass from " + user.getPassword() + " is " + encryptedPass);
        user.setPassword(encryptedPass);

        return userRepository.save(user);
    }

    public List<User> listAll(){
        return userRepository.findAll();
    }
}
