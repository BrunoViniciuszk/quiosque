package br.senai.sp.cotia.quiosque.model;

public enum ProdutoInteresse {
	PORCAO_PEIXE("Por��o de Peixe"), PORCAO_BATATA("Por��o de Batata"), PORCAO_MANDIOCA("Por��o de Mandioca"), 
	PORCAO_FRANGO("Por��o de Frango"), PORCAO_CARNE("Por��o de Carne");

	String desc;

	private ProdutoInteresse(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return this.desc;
	}
}
