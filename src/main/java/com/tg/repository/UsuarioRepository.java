package com.tg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tg.dtos.UsuarioDto;


@Repository
public interface UsuarioRepository  extends JpaRepository<UsuarioDto, Long> {

	UsuarioDto findByUsername(String username);
}
