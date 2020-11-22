package main.java.ecoCerto;

public class Vidrao extends EcoPonto {

	private TipoEcoPonto tipo = TipoEcoPonto.Vidrao;

	public Vidrao(String cep) {
		super.include(cep, this.tipo);
	}

}
