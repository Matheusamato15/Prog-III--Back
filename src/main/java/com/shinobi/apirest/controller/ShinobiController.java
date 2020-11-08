package com.shinobi.apirest.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.shinobi.apirest.models.Shinobi;
import com.shinobi.apirest.repository.ShinobiRepository;
import com.shinobi.apirest.utils.DateUtils;

/*
 * Classe que faz as validações do Objeto Shinobi que vem da requisição
 * @author Rodrigo, Amato
 */

@org.springframework.stereotype.Controller
public class ShinobiController extends Validacao {

	@Autowired
	ShinobiRepository shinobiRepository;
	DateUtils dateUtils;

	private String[] mensagensDeErro = {
			"O campo Nome não pode conter números, estar em branco e/ou conter caracteres esperciais.",
			"O campo Jutsu mais Brabo não pode conter números, estar em branco e/ou conter caracteres esperciais.",
			"O campo Rival Mortal não pode conter números, estar em branco e/ou conter caracteres esperciais.",
			"Data inválida",
			"Campos em branco encontrados",
			"Algo diferente de true ou false foi encontrado",
			"Níveis inválidos"};

	/*
	 * Método que valida as seguintes características do Objeto Shinobi que vem da
	 * requisição Campo em branco, campo que começa e/ou termina com espaço, campo
	 * com números ou caracteres especial
	 *
	 * @author Rodrigo, Amato
	 */
	public Shinobi save(Shinobi shinobi) {

		if (this.validaCampos(shinobi)) {
			return shinobiRepository.save(shinobi);
		}else {
			return null;
		}
	}

	public void delete(long id) {
		shinobiRepository.deleteById(id);
	}

	public List<Shinobi> listar() {
		return shinobiRepository.findAll();
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean validaCampos(Object shinobi) {
		// TODO Auto-generated method stub
		if(!((Shinobi) shinobi).getNome().matches("[a-z A-Z à-ú À-Ú ]*")) {
			throw new RuntimeException(mensagensDeErro[0]); 
		}else if (!((Shinobi) shinobi).getJutsuMaisBrabo().matches("[a-z A-Z à-ú À-Ú ]*")) {
			throw new RuntimeException(mensagensDeErro[1]); 
		}
		
		else if (!((Shinobi) shinobi).getRivalMortal().matches("[a-z A-Z à-ú À-Ú ]*")){
			throw new RuntimeException(mensagensDeErro[2]); 
		} 
		
		else if(dateUtils.getYear(((Shinobi) shinobi).getDataNascimento()) > Calendar.getInstance().get(Calendar.YEAR)) {
			throw new RuntimeException(mensagensDeErro[3]);
		} 
		
		else if(((Shinobi) shinobi).getNome().equalsIgnoreCase("") || ((Shinobi) shinobi).getJutsuMaisBrabo().equalsIgnoreCase("") || 
				((Shinobi) shinobi).getRivalMortal().equalsIgnoreCase("") || ((Shinobi) shinobi).getEntitulacao().equalsIgnoreCase("")) {
			throw new RuntimeException(mensagensDeErro[4]);
		} 
		
		/*else if(shinobi.isMorreu() != true || shinobi.isMorreu()!= false) {
			throw new RuntimeException(mensagensDeErro[5]);
		} */
		
		else if(((Shinobi) shinobi).getNivelGenjutsu() > 10 || ((Shinobi) shinobi).getNivelGenjutsu() < 0) {
			throw new RuntimeException(mensagensDeErro[6]);
		} 
		
		else if(((Shinobi) shinobi).getNivelNinjutsu() > 10 || ((Shinobi) shinobi).getNivelNinjutsu() < 0) {
			throw new RuntimeException(mensagensDeErro[6]);
		}  
		
		else if(((Shinobi) shinobi).getNivelTaijutsu() > 10 || ((Shinobi) shinobi).getNivelTaijutsu() < 0) {
			throw new RuntimeException(mensagensDeErro[6]);
		} 
		else {
			//remove os espaçoes no início e no fim do campo
			((Shinobi) shinobi).setNome(((Shinobi) shinobi).getNome().trim());
			((Shinobi) shinobi).setJutsuMaisBrabo(((Shinobi) shinobi).getJutsuMaisBrabo().trim());
			((Shinobi) shinobi).setEntitulacao(((Shinobi) shinobi).getEntitulacao().trim());
			((Shinobi) shinobi).setRivalMortal(((Shinobi) shinobi).getRivalMortal().trim());
			
			return true;
		}
		
		//return false;
	}
}
