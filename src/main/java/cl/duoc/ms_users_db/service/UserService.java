package cl.duoc.ms_users_db.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.duoc.ms_users_db.model.entities.User;
import cl.duoc.ms_users_db.model.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> selectAllUser(){
        List<User> listUsers = userRepository.findAll();
        return listUsers;
    
    }
    
    public User findByUsername(String username) {
    return userRepository.findByUsername(username)
           .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
}

}

