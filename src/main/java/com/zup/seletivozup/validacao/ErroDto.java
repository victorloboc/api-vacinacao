package com.zup.seletivozup.validacao;

public class ErroDto {

	private String campo;
	private String erro;

	public ErroDto(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}

	public ErroDto() {
		super();
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}

}
