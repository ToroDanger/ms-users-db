package cl.duoc.ms_users_db.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class PrivateUser {

    @GetMapping("/home")
    public String home() {
        System.out.println("entro a home");
        return "private home";
    }
    
    @GetMapping("/admin")
    @PreAuthorize("hasRole('admin')")
    public String admin(){
        System.out.println("entro a admin");
        return "admin";
    }

}
