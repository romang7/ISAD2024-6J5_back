package com.example.demo.Auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    public static final String SECRET_KEY = "586E3272357538782F413F4428472B4B6250655368566B597033733676397924";
    //private final String jwtSecret = "secretoMuySeguro"; // Cambiar por una clave secreta segura

    // Método para validar el token
    public boolean validateToken(String token) {
        try {
            Claims claims = Jwts
                    .parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            // Verificar que el token no haya expirado
            return claims.getExpiration().after(new Date());
        } catch (SignatureException e) {
            System.out.println("Error de firma en el token: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al validar el token: " + e.getMessage());
            return false;
        }
    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}