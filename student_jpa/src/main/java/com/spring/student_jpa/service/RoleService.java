package com.spring.student_jpa.service;

import com.spring.student_jpa.model.role.Role;
import com.spring.student_jpa.model.role.RoleRequest;

public interface RoleService {

    Role add(RoleRequest request);

    boolean delete(long id);
}
