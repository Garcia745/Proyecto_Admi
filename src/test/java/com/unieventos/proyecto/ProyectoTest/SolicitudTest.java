package com.unieventos.proyecto.ProyectoTest;

import com.unieventos.proyecto.model.*;
import com.unieventos.proyecto.repository.repository.OperacionRepo;
import com.unieventos.proyecto.repository.repository.SolicitudRepo;
import com.unieventos.proyecto.repository.repository.SoporteRepo;
import com.unieventos.proyecto.repository.repository.UsuarioRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SolicitudTest {

    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private SolicitudRepo solicitudRepo;
    @Autowired
    private OperacionRepo operacionRepo;
    @Autowired
    private SoporteRepo soporteRepo;

    @Test
    public void crearSolicitudDeSoporte() {
        // 1️⃣ Crear usuario (Director TI)
        Usuario directorTI = Usuario.builder()
                .nombre("Carlos")
                .apellido("Pérez")
                .email("carlos@unieventos.com")
                .telefono(List.of("3001234567"))
                .passwordHash("abc123")
                .rol(Rol.GerenteTI)
                .activo(true)
                .fechaCreacion(LocalDate.now())
                .build();
        usuarioRepo.save(directorTI);

        // 2️⃣ Crear solicitud de soporte
        Solicitud solicitud = Solicitud.builder()
                .idUsuario(directorTI.getId())
                .fechaSolicitud(LocalDate.now())
                .estado(SolicitudEstado.PENDIENTE)
                .observaciones("El teclado del computador 03 no funciona")
                .build();
        solicitudRepo.save(solicitud);

        // 3️⃣ Crear operación de soporte
        Operacion operacion = Operacion.builder()
                .idSolicitud(solicitud.getIdSolicitud())
                .tipo(OperacionTipo.SOPORTE)
                .fechaOperacion(LocalDate.now())
                .notas("Creada automáticamente desde la solicitud de soporte")
                .build();
        operacionRepo.save(operacion);

        // 4️⃣ Crear registro de soporte
        Soporte soporte = Soporte.builder()
                .idOperacion(operacion.getIdOperacion())
                .fechaRegistro(LocalDate.now())
                .descripcionProblema("Equipo de sonido principal no enciende")
                .prioridad(SoportePrioridad.ALTA)
                .estado("PENDIENTE")
                .build();
        soporteRepo.save(soporte);

        // 5️⃣ Verificaciones
        assertThat(usuarioRepo.findAll()).isNotEmpty();
        assertThat(solicitudRepo.findAll()).isNotEmpty();
        assertThat(operacionRepo.findAll()).isNotEmpty();
        assertThat(soporteRepo.findAll()).isNotEmpty();

        Soporte soporteGuardado = soporteRepo.findById(soporte.getIdSoporte()).orElseThrow();
        assertThat(soporteGuardado.getDescripcionProblema()).contains("no enciende");
        assertThat(soporteGuardado.getPrioridad()).isEqualTo(SoportePrioridad.ALTA);
    }
}
