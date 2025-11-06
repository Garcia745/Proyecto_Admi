package com.unieventos.proyecto.service.Implementation;

import com.unieventos.proyecto.DTOS.EmailDTO;
import com.unieventos.proyecto.service.Interface.EmailService;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${smtp.host}")
    private String host;
    @Value("${smtp.port}")
    private int port;
    @Value("${smtp.username}")
    private String username;
    @Value("${smtp.password}")
    private String password;

    @Override
    @Async
    public void enviarCorreo(EmailDTO emailDTO) throws Exception {

        // Construir el email usando nombre y dirección del destinatario
        Email email = EmailBuilder.startingBlank()
                .from("Unieventos", username) // nombre visible + dirección remitente
                .to(emailDTO.getNombreDestinatario(), emailDTO.getEmailDestinatario())
                .withSubject(emailDTO.getAsunto())
                .withPlainText(emailDTO.getCuerpo())
                .buildEmail();

        // Crear el mailer usando las propiedades inyectadas
        try (Mailer mailer = MailerBuilder
                .withSMTPServer(host, port, username, password)
                .withTransportStrategy(TransportStrategy.SMTP_TLS) // para puerto 587 (STARTTLS)
                .withDebugLogging(true)
                .buildMailer()) {

            mailer.sendMail(email);
        }
    }
}
