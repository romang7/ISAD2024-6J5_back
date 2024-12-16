package com.example.demo.Controller;

import com.example.demo.Auth.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TokenVerificationController {

    private final JwtTokenProvider jwtTokenProvider;

    public TokenVerificationController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @GetMapping("TokenV")
    public ResponseEntity<String> verifyToken(@RequestHeader("Authorization") String authorizationHeader) {
        try {
            // Extraer el token del encabezado "Authorization"
            if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token no proporcionado o mal formado");
            }

            String token = authorizationHeader.substring(7); // Quitar "Bearer " del encabezado

            // Validar el token usando el proveedor JWT
            if (jwtTokenProvider.validateToken(token)) {
                return ResponseEntity.ok("Token válido"); // Respuesta positiva
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar el token");
        }
    }
}
