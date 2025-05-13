package cl.duoc.ms_users_db.controller;

import cl.duoc.ms_users_db.model.LoginRequest;
import cl.duoc.ms_users_db.model.entities.User;
import cl.duoc.ms_users_db.model.repository.UserRepository;
import cl.duoc.ms_users_db.security.JwtUtil;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
    String username = loginRequest.getUsername();
    String password = loginRequest.getPassword();
    
        Optional<User> userOpt = userRepository.findAll().stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst();
        
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            
            //Pruebas
            System.out.println("USERNAME: " + user.getUsername());
            System.out.println("ROL: " + user.getRole());
            //pruebas

            System.out.println("ROL: " + user.getRole().getDescription()
);

            String token = jwtUtil.generateToken(user.getUsername(), user.getRole().getDescription()
);

            //pruebas
            System.out.println("asta aca funciona???");
            System.out.println(user.getRole());
            //pruebas

            return ResponseEntity.ok().body(token);
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }
}

