package com.aironman.demo.domain.service;

import com.aironman.demo.domain.model.Group;

import java.util.List;

public interface GroupService {

    Group create(Group group);

    List<Group> listAll();

    void initialize();
}
