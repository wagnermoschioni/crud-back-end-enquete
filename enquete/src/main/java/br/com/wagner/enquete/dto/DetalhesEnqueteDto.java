package br.com.wagner.enquete.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.wagner.enquete.modelo.Enquete;

public class DetalhesEnqueteDto {

	private Long id;
	private String titulo;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	private List<RespostaDTO> respostas;
	
	public DetalhesEnqueteDto(Enquete enquete) {
		this.id = enquete.getId();
		this.titulo = enquete.getTitulo();
		this.dataCriacao = enquete.getDataCriacao();
		this.respostas = new ArrayList<>();
		this.respostas.addAll(enquete.getRespostas().stream().map(RespostaDTO::new).collect(Collectors.toList()));
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public List<RespostaDTO> getRespostas() {
		return respostas;
	}
	
	
}
