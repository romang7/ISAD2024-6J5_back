package com.example.demo.Service;

import com.example.demo.Auth.AuthResponse;
import com.example.demo.Auth.LoginRequest;
import com.example.demo.Auth.RegResponse;
import com.example.demo.Auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private JavaMailSender mailSender;

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        UserDetails user=userRepository.findByEmail(request.getEmail()).orElseThrow();
        String token=jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public RegResponse register(RegisterRequest request) {
        // Generar el código de verificación
        String tk = String.format("%04d", new Random().nextInt(9999));

        // Crear el usuario
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .regcode(tk) // Guardar el código en el campo correspondiente
                .registrado(false)
                .role(1)
                .build();

        // Guardar el usuario en la base de datos
        userRepository.save(user);

        // Enviar el correo con el código de verificación
        String subject = "Código de Verificación de Cuenta";
        String body = String.format("Gracias por registrarte. Tu código de verificación es: "+tk+"\n\nSaludos.",
                request.getUsername(), tk);
        sendEmail(request.getEmail(), subject, body);

        // Retornar la respuesta con el código
        return RegResponse.builder().tk(tk).build();
    }

    // Método auxiliar para enviar correos
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}