package com.shinobi.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shinobi.apirest.models.Clan;

public interface ClanRepository extends JpaRepository<Clan, Long>{
	Clan findById (long id);
	void deleteById(long id);
}
