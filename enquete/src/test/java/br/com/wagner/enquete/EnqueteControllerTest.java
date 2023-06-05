package br.com.wagner.enquete;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import br.com.wagner.enquete.controller.EnqueteController;
import br.com.wagner.enquete.modelo.Enquete;
import br.com.wagner.enquete.repository.EnqueteRepository;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@WebMvcTest
public class EnqueteControllerTest {

	@Autowired
	private EnqueteController enqueteController;
	
	@MockBean
	private EnqueteRepository repository;
	
	@MockBean
	public List<Enquete> enquete;
	
	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(this.enqueteController);
		
		
	}
	
	@Test
	public void should_return_all_with_get() {
		
		doReturn(enquete).when(repository).findAll();
		RestAssuredMockMvc.given().accept(ContentType.JSON)
		.when().get("/enquetes")
		.then().statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void should_delete_a_resource_by_id() {
		doNothing().when(repository).deleteById(1L);
		
		verify(repository).deleteById(1L);
	}
}
