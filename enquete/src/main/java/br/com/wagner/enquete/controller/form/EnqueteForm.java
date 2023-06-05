package br.com.wagner.enquete.controller.form;

import org.hibernate.validator.constraints.Length;

import br.com.wagner.enquete.modelo.Enquete;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class EnqueteForm {
	
	@NotNull @NotEmpty @Length(min = 25)
	private String titulo;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Enquete converter() {
		return new Enquete(titulo);
	}
	
	
	
}
