package cl.duoc.ms_users_db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.ms_users_db.model.entities.User;
import cl.duoc.ms_users_db.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> selectAllUser(){
        return userService.selectAllUser();
    }
    //aca van las apis 
}
