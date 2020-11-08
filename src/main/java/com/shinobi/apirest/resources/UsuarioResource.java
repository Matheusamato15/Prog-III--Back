package com.shinobi.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.shinobi.apirest.controller.UsuarioController;
import com.shinobi.apirest.models.Usuario;

@RestController
@RequestMapping(value = "/api")
public class UsuarioResource implements WebMvcConfigurer {
	
	@Autowired
	UsuarioController usuarioController;

	@GetMapping("/usuarios")
	public List<Usuario> getUsuarios() {
		return usuarioController.listar();
	}

	@PostMapping("/usuario")
	public Usuario insert(@RequestBody Usuario usuario) {
		return usuarioController.save(usuario);
	}

	@DeleteMapping("/usuario/{id}")
	public void delete(@PathVariable(value = "id") long id) {
		usuarioController.delete(id);
	}

	@PutMapping("/usuario")
	public Usuario update(@RequestBody Usuario usuario) {
		return usuarioController.save(usuario);
	}
}
