package com.unieventos.proyecto.DTOS;

public record MensajeDTO<T>(
    boolean error,
    T respuesta)
{}
