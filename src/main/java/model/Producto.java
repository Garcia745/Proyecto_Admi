package model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "productos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Producto {

    @Id
    @EqualsAndHashCode.Include
    private String idProducto;
    private String nombre;
    private String descripcion;
    private Integer stock;
    private Integer umbralReorden;
    private Double precio;
}
