package com.security.demo.aplicationJWT;


import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.SecretKey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@SpringBootApplication

public class jwtAplication {
    public static void main(String[] args) {
        SpringApplication.run(jwtAplication.class, args);
        System.out.println("Aplicación de autenticación JWT" + getBase64Key());
    }

private static final SecretKey secret_key = keys.secretKeyFor(SignatureAlgorithm.HS256);
public static String getBase64Key() {
    var key = Base64.getEncoder().encodeToString(secret_key.getEncoded());
    return key;
}
}
