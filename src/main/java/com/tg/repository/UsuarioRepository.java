package com.tg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tg.entities.Usuarios;


@Repository
public interface UsuarioRepository  extends JpaRepository<Usuarios, Long> {

	Usuarios findByUsername(String username);

}
