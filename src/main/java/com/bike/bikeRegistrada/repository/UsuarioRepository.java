package com.bike.bikeRegistrada.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bike.bikeRegistrada.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
