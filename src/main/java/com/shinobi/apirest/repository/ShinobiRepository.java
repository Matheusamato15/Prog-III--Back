package com.shinobi.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shinobi.apirest.models.Shinobi;

public interface ShinobiRepository extends JpaRepository<Shinobi, Long>{
	Shinobi findById (long id);
	void deleteById(long id);
}
