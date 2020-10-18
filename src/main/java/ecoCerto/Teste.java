package main.java.ecoCerto;

public class Teste {

	public static void main(String[] args) {

    	EcoPonto ecoPonto = new EcoPonto();
    	
    	ecoPonto.include("03924090", TipoEcoPonto.Embalao);
    	ecoPonto.include("08693190", TipoEcoPonto.Vidrao);
    	ecoPonto.include("09080000", TipoEcoPonto.Pilhao);
    	ecoPonto.include("04094050", TipoEcoPonto.Entulho);
    	
    	Usuario user = new Usuario("08680000", "Renan");
    	
    	System.out.println(user.listUpComing(50));

	}

	

}
