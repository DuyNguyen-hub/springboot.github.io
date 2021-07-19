package com.spring.student_jpa.service.impl;

import com.spring.student_jpa.model.role.Role;
import com.spring.student_jpa.model.user.User;
import com.spring.student_jpa.model.user.UserRequest;
import com.spring.student_jpa.repository.RoleRepo;
import com.spring.student_jpa.repository.UserRepo;
import com.spring.student_jpa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo uSerRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public User add(UserRequest request) {
        User usercreated = null;
        try {
            List<Role> role = roleRepo.findByIdIsIn(request.getRoles());
            User user = new User();
            user.setUsername(request.getUsername());
            user.setPassword(request.getPassword());
            user.setEmail(request.getEmail());
            user.setRoles(role);
            //
            usercreated = uSerRepo.save(user);
        }catch (Exception ex){
            log.info(ex.getMessage());
        }
        return usercreated;
    }
}
