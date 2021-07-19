package com.spring.student_jpa.repository;

import com.spring.student_jpa.model.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    List<Role> findByIdIsIn(List<Long> ids);
}
