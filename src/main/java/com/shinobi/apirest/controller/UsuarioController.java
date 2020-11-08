package com.shinobi.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.shinobi.apirest.models.Usuario;
import com.shinobi.apirest.repository.UsuarioRepository;



@org.springframework.stereotype.Controller
public class UsuarioController extends Validacao{
	
	@Autowired
	UsuarioRepository usuarioRepository;
	Usuario usuario;
	
	public String logar (String username, String senha) {
		if (username == "" && senha == "") {
			return  "logado";
		}
		return "não logado";
	}
	
	public Usuario save (Usuario usuario) {
		if(this.validaCampos(usuario)) {
			return usuarioRepository.save(usuario);
		} else {
			return null;
		}
	}
	
	public List<Usuario> listar(){
		return null;
	}
	
	public void delete (long id) {
		
	}

	@Override
	public boolean validaCampos(Object usuario) {
		
		if(!((Usuario) usuario).getUsername().matches("[a-z A-Z à-ú À-Ú 0-9]*")) {
			throw new RuntimeException("Permitido apenas caracteres alfabéticos"); 
			
			
		} else {
			return true;
		}
	}
	
}
