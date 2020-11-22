package main.java.ecoCerto;

public class Teste {

	public static void main(String[] args) {
    	
    	Usuario user = new Usuario("08680000", "Renan");
    	
    	new Embalao("08693190");
    	new Vidrao("08693190");
    	new Papelao("08693190");
    	new Pilhao("08693190");
    	new Entulho("03924090");
    	new Embalao("03924090");
    	
    	System.out.println(user.listUpComing(50));

	}

	

}
