package br.com.wagner.enquete.controller.form;


import br.com.wagner.enquete.modelo.Enquete;
import br.com.wagner.enquete.repository.EnqueteRepository;

public class AtualizaForm {

	
	private String titulo;
		

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public Enquete atualizar(Long id, EnqueteRepository enqueteRepository) {
		Enquete enquete = enqueteRepository.getReferenceById(id);
		enquete.setTitulo(this.titulo);		
		return enquete;
	}
	
	
}
