package com.unieventos.proyecto.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Document(collection = "solicitud")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Solicitud {

    @Id
    @EqualsAndHashCode.Include
    private String idSolicitud;
    @Indexed
    private String idUsuario; // quien crea la solicitud
    @Indexed
    private String operacionId; // referencia a la operación asociada
    private LocalDate fechaSolicitud;
    private SolicitudEstado estado; // PENDIENTE, APROBADA, RECHAZADA, CANCELADA
    private String observaciones;
    private String revisorId; // admin que revisa
    private LocalDate fechaDecision;
    // Detalles (especialmente para tipo COMPRA)
    private List<DetalleSolicitud> detalles;
}
