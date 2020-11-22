package main.java.ecoCerto;

public class Entulho extends EcoPonto {

	private TipoEcoPonto tipo = TipoEcoPonto.Entulho;

	public Entulho(String cep) {
		super.include(cep, this.tipo);
	}

}
