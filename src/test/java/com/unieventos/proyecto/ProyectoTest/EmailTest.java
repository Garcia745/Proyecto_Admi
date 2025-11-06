package com.unieventos.proyecto.ProyectoTest;

import com.unieventos.proyecto.DTOS.EmailDTO;
import com.unieventos.proyecto.service.Interface.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailTest {

    @Autowired
    private EmailService emailServices;

    @Test
    public void enviarCorreoTest() throws Exception {
        EmailDTO email = new EmailDTO();
        email.setNombreDestinatario("Juan");
        email.setEmailDestinatario("garciaflorezz24@gmail.com"); // cámbialo por uno tuyo
        email.setAsunto("Prueba de correo");
        email.setCuerpo("Hola, este es un correo de prueba desde el servicio de correo.");

        emailServices.enviarCorreo(email);
        System.out.println("✅ Correo enviado correctamente (revisa la bandeja de entrada)");
    }
}
