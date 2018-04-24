package com.aironman.demo.domain.repository;

import com.aironman.demo.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
