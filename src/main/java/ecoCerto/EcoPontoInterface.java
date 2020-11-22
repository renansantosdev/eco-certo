package main.java.ecoCerto;

public interface EcoPontoInterface {

	public String include(String cep, TipoEcoPonto tipo);
	
	public void update(int index, String cep);
	
	public void delete(int index);
	
	public String get(int index);
	
	public String listAll();
	
	public String listAll(TipoEcoPonto tipo);
	
}
