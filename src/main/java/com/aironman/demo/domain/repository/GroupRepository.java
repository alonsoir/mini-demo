package com.aironman.demo.domain.repository;

import com.aironman.demo.domain.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
