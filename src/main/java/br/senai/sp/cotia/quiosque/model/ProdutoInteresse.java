package br.senai.sp.cotia.quiosque.model;

public enum ProdutoInteresse {
	PORCAO_PEIXE("Porção de Peixe"), PORCAO_BATATA("Porção de Batata"), PORCAO_MANDIOCA("Porção de Mandioca"), 
	PORCAO_FRANGO("Porção de Frango"), PORCAO_CARNE("Porção de Carne");

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
