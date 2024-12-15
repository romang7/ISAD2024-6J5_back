package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USUARIOS")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Us_ID")
    Integer id;
    @Column(name = "Us_Nombre", nullable = false, length = 50)
    String username;
    @Column(name = "Us_Correo", unique = true, nullable = false, length = 50)
    String email;
    @Column(name = "Us_Contraseña", nullable = false, length = 70)
    String password;
    @Column(name = "Us_Codigo", nullable = false, length = 50)
    String regcode;
    @Column(name = "Us_Verificado", nullable = false)
    Boolean registrado;
    @Column(name = "Us_Rol", nullable = false, length = 50)
    Integer role;

    @Override
    public String getUsername(){
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("1"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}