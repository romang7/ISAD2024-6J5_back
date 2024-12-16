package com.example.demo.Controller;

import com.example.demo.Service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cotizar")
@RequiredArgsConstructor
public class EmailController {

    @Autowired
    private EmailService emailService;

    public static class EmailRequest {
        private String to;
        private String subject;
        private String body;

        // Getters y setters
        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }

    @PostMapping("mail")
    public void sendEmail(@RequestBody EmailRequest emailRequest) {
        emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getBody());
    }
}