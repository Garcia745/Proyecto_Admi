package com.unieventos.proyecto.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDate;

@Document(collection = "operaciones")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Operacion {

    @Id
    @EqualsAndHashCode.Include
    private String idOperacion;
    private String idSolicitud; // FK -> Solicitud.idSolicitud
    private OperacionTipo tipo; // COMPRA | SOPORTE | RENOVACION
    private LocalDate fechaOperacion;
    private Double total;
    private Instant fechaRecepcion;
    private String notas;
}
