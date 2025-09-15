package com.mtz.utileria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtz.utileria.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
