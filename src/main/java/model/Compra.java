package model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "compras")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Compra {
    @Id
    @EqualsAndHashCode.Include
    private String idCompra; //pruebas 2
    private String idOperacion; // referencia a Operacion.idOperacion
    private String productoId;
    private Integer cantidadSolicitada;
    private Double precioUnitario;
    private Double subtotal;
}
