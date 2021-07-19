package com.spring.student_jpa.service;

import com.spring.student_jpa.model.user.User;
import com.spring.student_jpa.model.user.UserRequest;

public interface UserService {
    User add(UserRequest request);
}
