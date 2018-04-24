package com.aironman.demo.domain.service;

import com.aironman.demo.domain.model.Group;
import com.aironman.demo.domain.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Transactional
    public Group create(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public List<Group> listAll() {
        return groupRepository.findAll();
    }

    @Transactional
    public void initialize() {

        Group aGroup = new Group();
        aGroup.setGroupName("groupName");
        groupRepository.save(aGroup);

        Group anotherGroup = new Group();
        anotherGroup.setGroupName("anotherGroupName");
        groupRepository.save(anotherGroup );

    }
}
