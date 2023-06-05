package br.com.wagner.enquete.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.wagner.enquete.modelo.Enquete;

public class EnqueteDTO {

	private Long id;
	private String titulo;
	private LocalDateTime dataCriacao = LocalDateTime.now();
		
	public EnqueteDTO(Enquete enquete) {
		this.id = enquete.getId();
		this.titulo = enquete.getTitulo();
		this.dataCriacao = enquete.getDataCriacao();
		
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
	
	
	public static List<EnqueteDTO> converterToDto(List<Enquete> enquetes) {
		// TODO Auto-generated method stub
		return enquetes.stream().map(EnqueteDTO::new).collect(Collectors.toList());
	}
	
	
	
}
