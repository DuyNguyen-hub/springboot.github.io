package com.spring.student_jpa.service.impl;

import com.spring.student_jpa.model.role.Role;
import com.spring.student_jpa.model.role.RoleRequest;
import com.spring.student_jpa.repository.RoleRepo;
import com.spring.student_jpa.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Role add(RoleRequest request) {
        Role roleCreated = null;
        try {
            Role role = new Role();
            role.setName(request.getName());
            role.setParent(request.getParent());
            //
            roleCreated = roleRepo.save(role);
        }catch (Exception ex){
            log.info(ex.getMessage());
        }
        return roleCreated;
    }

    @Override
    public boolean delete(long id) {
        try {
          roleRepo.deleteById(id);
          return true;
        }catch (Exception ex){
            log.info(ex.getMessage());
            return false;
        }
    }
}
