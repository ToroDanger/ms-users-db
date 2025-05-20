package cl.duoc.ms_users_db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.ms_users_db.model.entities.User;
import cl.duoc.ms_users_db.service.UserService;


@RestController
@RequestMapping("/internal")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.selectAllUser();
    }

    @GetMapping("/users/by-username/{username}")
    public User getByUsername(@PathVariable String username) {
        return userService.findByUsername(username); //pasa a la siguiente ruta
    }
}




   