package cl.duoc.ms_users_db.model.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "role")
@Getter
@Setter
@ToString
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_role;

    private String description; // "ADMIN", "COMPRADOR", etc.
}
