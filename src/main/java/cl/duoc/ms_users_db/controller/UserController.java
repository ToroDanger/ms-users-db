package cl.duoc.ms_users_db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.ms_users_db.model.entities.User;
import cl.duoc.ms_users_db.service.UserService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> selectAllUser(){
        return userService.selectAllUser();
    }
  
}


   