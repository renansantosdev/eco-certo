package main.java.ecoCerto;

public class TesteApi {

    public static void main(String[] args) {
       
    	EcoPonto teste = new EcoPonto();
    	
    	teste.include("03924090", TipoEcoPonto.Embalao);
    	teste.include("08693190", TipoEcoPonto.Vidrao);
    	teste.include("09351390", TipoEcoPonto.Pilhao);
    	
    	System.out.println(teste.listAll());
    	
    	
    	
	}

}
