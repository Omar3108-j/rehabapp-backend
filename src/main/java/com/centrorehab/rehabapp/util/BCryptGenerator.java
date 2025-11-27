package com.centrorehab.rehabapp.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCryptGenerator {

    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        // 🔹 Cambia aquí la contraseña que quieras generar
        String rawPassword = "usuario123";

        String encoded = encoder.encode(rawPassword);

        System.out.println("Password en texto plano: " + rawPassword);
        System.out.println("Password encriptado (BCrypt): " + encoded);
    }
}

