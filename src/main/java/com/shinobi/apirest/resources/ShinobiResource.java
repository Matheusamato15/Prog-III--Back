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

import com.shinobi.apirest.controller.ShinobiController;
import com.shinobi.apirest.models.Shinobi;

@RestController
@RequestMapping(value = "/api")
public class ShinobiResource implements WebMvcConfigurer {
	
	@Autowired
	ShinobiController shinobiController;

	@GetMapping("/shinobis")
	public List<Shinobi> getShinobis() {
		return shinobiController.listar();
	}

	@PostMapping("/shinobi")
	public Shinobi insert(@RequestBody Shinobi shinobi) {
		return shinobiController.save(shinobi);
	}

	@DeleteMapping("/shinobi/{id}")
	public void delete(@PathVariable(value = "id") long id) {
		shinobiController.delete(id);
	}

	@PutMapping("/shinobi")
	public Shinobi update(@RequestBody Shinobi shinobi) {
		return shinobiController.save(shinobi);
	}
}
