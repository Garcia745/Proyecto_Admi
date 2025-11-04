package com.unieventos.proyecto.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Document(collection = "soportes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Soporte {

    @Id
    @EqualsAndHashCode.Include
    private String idSoporte;
    private String idOperacion; // referencia a operación
    private String idTecnico; // técnico asignado para por la mañana
    private LocalDate fechaRegistro;
    private String descripcionProblema;
    private SoportePrioridad prioridad;
    private String estado; // ASIGNADO, EN_PROGRESO, RESUELTO (puedes convertir a enum si prefieres)
    private List<String> historial; // logs de texto (opcional)
}
