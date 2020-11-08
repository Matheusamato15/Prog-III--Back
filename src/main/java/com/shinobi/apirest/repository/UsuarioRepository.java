package com.shinobi.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shinobi.apirest.models.Shinobi;
import com.shinobi.apirest.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Shinobi findById (long id);
	void deleteById(long id);
}
