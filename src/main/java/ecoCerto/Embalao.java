package main.java.ecoCerto;

public class Embalao extends EcoPonto{

	private TipoEcoPonto tipo = TipoEcoPonto.Embalao;
	
	public Embalao(String cep) {
		super.include(cep, this.tipo);
	}

}
