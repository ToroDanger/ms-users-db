package cl.duoc.ms_users_db.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String name;
    private String surnames;
    private String email;
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role")  // nombre exacto de la columna FK en la tabla user
    private Role role;
}
