package com.aironman.demo.domain.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idGroup", updatable = false, nullable = false)
    private Long idGroup;

    @NotEmpty
    @Size(min = 5, max = 25)
    @Column(name = "groupName", updatable = true, nullable = false)
    private String groupName;

    @ManyToMany(mappedBy = "groupList")
    private List<User> users;

    @Override
    public String toString() {
        return "Group{" +
                "idGroup=" + idGroup +
                ", groupName='" + groupName + '\'' +
                ", users=" + users +
                '}';
    }

    public Group() {
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Long idGroup) {
        this.idGroup = idGroup;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


}
