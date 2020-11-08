package com.shinobi.apirest.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Shinobi implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	private long id;

	private String nome;

	@ManyToOne
	private Clan Clan;

	private String jutsuMaisBrabo;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataNascimento;

	private boolean morreu; // Se está morto

	private String entitulacao;

	private String rivalMortal;

	private Integer nivelTaijutsu;

	private Integer nivelNinjutsu;

	private Integer nivelGenjutsu;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Clan getClan() {
		return Clan;
	}

	public void setClan(Clan clan) {
		Clan = clan;
	}

	public String getJutsuMaisBrabo() {
		return jutsuMaisBrabo;
	}

	public void setJutsuMaisBrabo(String jutsuMaisBrabo) {
		this.jutsuMaisBrabo = jutsuMaisBrabo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public boolean isMorreu() {
		return morreu;
	}

	public void setMorreu(boolean morreu) {
		this.morreu = morreu;
	}

	public String getEntitulacao() {
		return entitulacao;
	}

	public void setEntitulacao(String entitulacao) {
		this.entitulacao = entitulacao;
	}

	public String getRivalMortal() {
		return rivalMortal;
	}

	public void setRivalMortal(String rivalMortal) {
		this.rivalMortal = rivalMortal;
	}

	public Integer getNivelTaijutsu() {
		return nivelTaijutsu;
	}

	public void setNivelTaijutsu(Integer nivelTaijutsu) {
		this.nivelTaijutsu = nivelTaijutsu;
	}

	public Integer getNivelNinjutsu() {
		return nivelNinjutsu;
	}

	public void setNivelNinjutsu(Integer nivelNinjutsu) {
		this.nivelNinjutsu = nivelNinjutsu;
	}

	public Integer getNivelGenjutsu() {
		return nivelGenjutsu;
	}

	public void setNivelGenjutsu(Integer nivelGenjutsu) {
		this.nivelGenjutsu = nivelGenjutsu;
	}


}
