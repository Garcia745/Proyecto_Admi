package com.unieventos.proyecto.model;

import lombok.*;

@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalleSolicitud {

    // id del detalle por si necesitas referenciarlo individualmente
    private String idDetalleSolicitud;
    private String idSolicitud;
    private String productoId;
    private Integer cantidadSolicitada;
    private Double precioUnitario;
    private Double subtotal;
}
