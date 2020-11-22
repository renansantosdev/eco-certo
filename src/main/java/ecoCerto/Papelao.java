package main.java.ecoCerto;

public class Papelao extends EcoPonto {

	private TipoEcoPonto tipo = TipoEcoPonto.Papelao;

	public Papelao(String cep) {
		super.include(cep, this.tipo);
	}

}
