package com.unieventos.proyecto.service.Interface;

import com.unieventos.proyecto.DTOS.EmailDTO;

public interface EmailService {
    void enviarCorreo(EmailDTO emailDTO) throws Exception;
}
