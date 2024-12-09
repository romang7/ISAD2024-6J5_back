package com.example.demo.Controller;

import com.example.demo.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("send")
    public String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestBody String body) {
        try {
            emailService.sendEmail(to, subject, body);
            return "Correo enviado con éxito.";
        } catch (Exception e) {
            return "Error al enviar el correo: " + e.getMessage();
        }
    }

    @PostMapping("nada")
    public void nada(){}

}
