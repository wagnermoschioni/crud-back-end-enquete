package br.com.wagner.enquete.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Resposta {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mensagem;
	@ManyToOne
	private Enquete enquete;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	public Resposta(String mensagem) {
		this.mensagem = mensagem;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resposta other = (Resposta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public String getMensagem() {
		return mensagem;
	}

	
	public Enquete getEnquete() {
		return enquete;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	
}
