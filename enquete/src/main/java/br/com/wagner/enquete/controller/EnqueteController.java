package br.com.wagner.enquete.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.wagner.enquete.controller.form.AtualizaForm;
import br.com.wagner.enquete.controller.form.EnqueteForm;
import br.com.wagner.enquete.dto.DetalhesEnqueteDto;
import br.com.wagner.enquete.dto.EnqueteDTO;
import br.com.wagner.enquete.modelo.Enquete;
import br.com.wagner.enquete.repository.EnqueteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/enquetes")
public class EnqueteController {
	
	@Autowired
	private EnqueteRepository enqueteRepository;

	@GetMapping
	public List<EnqueteDTO> listar(String titulo) {
		
		List<Enquete> enquetes;		
		enquetes = titulo != null ? enqueteRepository.findByTituloContainingIgnoreCase(titulo) : enqueteRepository.findAll();		
		return EnqueteDTO.converterToDto(enquetes);
		
	}
	
	@PostMapping
	public ResponseEntity<EnqueteDTO> cadastrar(@RequestBody @Valid EnqueteForm form, UriComponentsBuilder builder) {
		Enquete enquete = form.converter();
		enqueteRepository.save(enquete);
		URI uri = builder.path("enquetes/{id}").buildAndExpand(enquete.getId()).toUri();
		System.out.println("cadastro com sucesso");
		return ResponseEntity.created(uri).body(new EnqueteDTO(enquete));
	}
	
	
	@GetMapping("/{id}")
	public DetalhesEnqueteDto detalhar(@PathVariable Long id) {
		Enquete enquete = enqueteRepository.getReferenceById(id);
				
		return new DetalhesEnqueteDto(enquete);
	}
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EnqueteDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizaForm form) {
		Enquete enquete = form.atualizar(id, enqueteRepository);
		return ResponseEntity.ok(new EnqueteDTO(enquete));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		enqueteRepository.deleteById(id);
		return ResponseEntity.ok().build();
		
	}
	

}
