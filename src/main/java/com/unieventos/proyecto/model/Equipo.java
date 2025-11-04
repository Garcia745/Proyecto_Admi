package com.unieventos.proyecto.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "equipos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Equipo {

    @Id
    @EqualsAndHashCode.Include
    private String idEquipo;
    private String idSoporte; // referencia al soporte asignado (si aplica)
    private String marca;
    private String modelo;
    private String tipo;
}
