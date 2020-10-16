package main.java.ecoCerto;

public class Teste {

	public static void main(String[] args) {

    	EcoPonto teste = new EcoPonto();
    	
    	teste.include("03924090", TipoEcoPonto.Embalao);
    	teste.include("08693190", TipoEcoPonto.Vidrao);
    	teste.include("09351390", TipoEcoPonto.Pilhao);
    	teste.include("09351390", TipoEcoPonto.Entulho);
    	
    	Usuario user = new Usuario("08680000", "Renan");
    	
    	System.out.println(user.listUpComing(25));

	}

	

}
