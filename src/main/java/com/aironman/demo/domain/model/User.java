package com.aironman.demo.domain.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idUser", updatable = false, nullable = false)
    private Long idUser;

    @NotEmpty
    @Size(min = 5, max = 15)
    @Column(name = "username", updatable = true, nullable = false)
    private String username;

    @NotEmpty
    @Size(min = 5)
    @Column(name = "password", updatable = true, nullable = false)
    private String password;

    @NotEmpty
    @Column(name = "name", updatable = true, nullable = false)
    private String name;

    @Email
    @NotEmpty
    @Column(name = "email", updatable = true, nullable = true)
    private String email;

    @ManyToMany
    private List<Group> groupList;

    public User() {

    }

    public User(String username, String password, String name, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setidUser(Long idUser) {
        this.idUser= idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", groupList=" + groupList +
                '}';
    }
}
