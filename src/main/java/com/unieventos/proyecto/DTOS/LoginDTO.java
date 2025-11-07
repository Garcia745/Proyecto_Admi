package com.unieventos.proyecto.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDTO {
    private String username;
    private String password;
    private String Email;
}
