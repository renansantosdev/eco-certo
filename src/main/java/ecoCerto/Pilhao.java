package main.java.ecoCerto;

public class Pilhao extends EcoPonto {

	private TipoEcoPonto tipo = TipoEcoPonto.Pilhao;

	public Pilhao(String cep) {
		super.include(cep, this.tipo);
	}

}
