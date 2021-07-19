package com.spring.student_jpa.controller;

import com.spring.student_jpa.model.Response;
import com.spring.student_jpa.model.role.Role;
import com.spring.student_jpa.model.role.RoleRequest;
import com.spring.student_jpa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("role")
public class RolerController {
    @Autowired
    private RoleService roleService;

    @PostMapping("add")
    public Response add(@RequestBody RoleRequest request){
        Response response = new Response();
        Role role = roleService.add(request);
        if(role != null){
            response.setCode(0);
            response.setMesage("add sucess");
            response.setData(role);
        }else {
            response.setCode(1);
            response.setMesage("add fail");
        }
        return response;
    }

    @DeleteMapping("delete/{id}")
    public Response delete(@PathVariable("id") long id){
        Response response = new Response();
        boolean check = roleService.delete(id);
        if(check){
            response.setCode(0);
            response.setMesage("delete sucess");
        }else {
            response.setCode(1);
            response.setMesage("delete fail");
        }
        return response;
    }
}
