package br.com.wagner.enquete.config.validation;

public class FormErrorDTO {

	private String campo;
	private String erro;
	
	
	public FormErrorDTO(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}


	public String getCampo() {
		return campo;
	}


	public String getErro() {
		return erro;
	}
	
	
	
}
