package com.example.demo.Controller;

import com.example.demo.Auth.*;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserRepository userRepository;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<RegResponse> register (@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @GetMapping("registrado")
    public ResponseEntity<Map<String, Boolean>> verificarRegistro(@RequestParam String email) {
        return userRepository.findByEmail(email)
                .map(user -> ResponseEntity.ok(Map.of("registrado", user.getRegistrado())))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("registrado", false)));
    }

    @GetMapping("user")
    public ResponseEntity<UserResponse> getUserByEmail(@RequestParam String email) {
        return userRepository.findByEmail(email)
                .map(user -> ResponseEntity.ok(new UserResponse(user.getEmail(), user.getUsername())))
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping("code")
    public ResponseEntity<RegResponse> getUserByRegCode(@RequestParam String regcode) {
        return userRepository.findByRegcode(regcode)
                .map(user -> ResponseEntity.ok(new RegResponse(user.getRegcode())))
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping("activate")
    public ResponseEntity<?> activateUser(@RequestBody Map<String, String> request) {
        String regcode = request.get("regcode");

        return userRepository.findByRegcode(regcode)
                .map(user -> {
                    if (!user.getRegistrado()) { // Si no está registrado, actualizar el estado
                        user.setRegistrado(true);
                        userRepository.save(user); // Guardar cambios en la base de datos
                        return ResponseEntity.ok("Usuario activado exitosamente.");
                    } else {
                        return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario ya está activado.");
                    }
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Código de registro no encontrado."));
    }

    @GetMapping("existe")
    public ResponseEntity<Map<String, Boolean>> verificarUsuario(@RequestParam String email) {
        boolean existe = userRepository.findByEmail(email).isPresent();
        return ResponseEntity.ok(Map.of("existe", existe));
    }
}
