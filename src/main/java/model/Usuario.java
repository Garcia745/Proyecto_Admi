package model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection = "usuarios")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {

    @Id
    @EqualsAndHashCode.Include
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private List<String> telefono;
    private String passwordHash; // almacenar hash
    private Rol rol;
    private boolean activo;
    private Instant fechaCreacion;
}
