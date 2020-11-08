package com.shinobi.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.shinobi.apirest.models.Clan;
import com.shinobi.apirest.repository.ClanRepository;


@org.springframework.stereotype.Controller
public class ClanController extends Validacao{
	
	@Autowired
	ClanRepository clanRepository;
	Clan clan;
	

	public Clan save (Clan clan) {
		if(this.validaCampos(clan)) {
			return clanRepository.save(clan);
		} else {
			return null;
		}
		
	}
	
	public void delete (long id) {
		clanRepository.deleteById(id);
	}
	
	public List<Clan> listar () {
		return clanRepository.findAll();
	}

	@Override
	public boolean validaCampos(Object clan) {

		
		if(!((Clan) clan).getNome().matches("[a-z A-Z à-ú À-Ú]*")) {
			throw new RuntimeException("Permitido apenas caracteres alfabéticos"); 
			
			
		} else {
			return true;
		}
		
	}
}
