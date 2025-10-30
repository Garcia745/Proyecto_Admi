package model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "licencias")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Licencia {

    @Id
    @EqualsAndHashCode.Include
    private String idLicencia;
    private String idProducto;
    private String idOperacion;
    private String tipo;
    private String codigo;
    private Instant fechaEmision;
    private Instant fechaVencimiento;
    private String estado; // VIGENTE, VENCIDA, RENOVADA etc.
}
