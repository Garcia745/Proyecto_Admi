package com.unieventos.proyecto.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {
    private String nombreDestinatario;
    private String emailDestinatario;
    private String asunto;
    private String cuerpo;
}
