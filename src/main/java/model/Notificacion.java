package model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "notificaciones")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Notificacion {

    @Id
    @EqualsAndHashCode.Include
    private String idNotificacion;
    private String idProducto; // si la notificación se relaciona con un producto
    private String idUsuario; // destinatario
    private String mensaje;
    private String tipo; // STOCK_BAJO, LICENCIA_VENCIMIENTO, SOPORTE_NUEVO, etc.
    private boolean leido;
    private Instant fecha;
}
