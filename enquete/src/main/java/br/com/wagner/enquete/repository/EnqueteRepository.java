package br.com.wagner.enquete.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wagner.enquete.modelo.Enquete;

public interface EnqueteRepository extends JpaRepository<Enquete, Long>{
	
	List<Enquete> findByTituloContainingIgnoreCase(String titulo);

}









