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

import com.shinobi.apirest.controller.ClanController;
import com.shinobi.apirest.models.Clan;

@RestController
@RequestMapping(value = "/api")
public class ClanResource implements WebMvcConfigurer {

	@Autowired
	ClanController clanController;


	@GetMapping("/clans")
	public List<Clan> getShinobis() {
		return clanController.listar();
	}

	@PostMapping("/clan")
	public Clan insert(@RequestBody Clan clan) {
		return clanController.save(clan);
	}

	@DeleteMapping("/clan/{id}")
	public void delete(@PathVariable(value = "id") long id) {
		clanController.delete(id);
	}

	@PutMapping("/clan")
	public Clan update(@RequestBody Clan clan) {
		return clanController.save(clan);
	}
}
