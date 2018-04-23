package com.aironman.demo.domain.service;

import com.aironman.demo.domain.model.User;

import java.util.List;

public interface UserService {

    User create(User user);

    public List<User> listAll();

    public void initialize();
}
