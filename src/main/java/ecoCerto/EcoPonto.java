package main.java.ecoCerto;

import java.util.ArrayList;
import java.util.List;
import main.java.org.json.JSONObject;

public class EcoPonto implements EcoPontoInterface {
	
	private TipoEcoPonto tipo;
	private	double latitude;
	private double longitude;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String cep;
	private String UF;
	public static List<EcoPonto> list = new ArrayList<EcoPonto>();
	
	public EcoPonto() {}
	
	//METODO PARA INCLUIR UM NOVO ECOPONTO
	@Override
	public String include(String cep, TipoEcoPonto tipo) {
		
		try {
			
			for(EcoPonto e : list) {
				if(e.getCep().equals(cep) && e.getTipo().equals(tipo)) {
					System.out.println("Ja existe um EcoPonto desse tipo: " + e.getTipo() + ", nesse endereço: " + e.getCep());
					return null;
				}
			}
			
			JSONObject json = ApiCep.Api(cep);
			EcoPonto obj = new EcoPonto();
			
			obj.setLatitude(json.getDouble("latitude"));
			obj.setLongitude(json.getDouble("longitude"));
			obj.setLogradouro(json.getString("logradouro"));
			obj.setBairro(json.getString("bairro"));
			obj.setCidade(json.getString("cidade"));
			obj.setCep(cep);
			obj.setUF(json.getString("uf"));
			obj.setTipo(tipo);
			
			list.add(obj);
			
			return obj.toString();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	//METODO PARA ALTERACAO DE UM ECOPONTO
	@Override
	public void update(int index, String cep) {
		
		try {

			JSONObject json = ApiCep.Api(cep);
			
			list.get(index).setLatitude(json.getDouble("latitude"));
			list.get(index).setLongitude(json.getDouble("longitude"));
			list.get(index).setLogradouro(json.getString("logradouro"));
			list.get(index).setBairro(json.getString("bairro"));
			list.get(index).setCidade(json.getString("cidade"));
			list.get(index).setUF(json.getString("uf"));
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	//METODO PARA DELETAR UM ECOPONTO
	@Override
	public void delete(int index) {
		
		list.remove(index);
		
	}
	
	//METODO PARA CONSULTAR APENAS UM ECOPONTO
	@Override
	public String get(int index) {
		
		return list.get(index).toString();
		
	}
	
	//METODO PARA PEGAR A LISTA TODOS ECOPONTOS
	public static List<EcoPonto> getAll(){
		return list;
	}
	
	//METODO PARA LISTAS TODOS OS ECOPONTOS
	@Override
	public String listAll() {
		
		String quebraLinha = System.getProperty("line.separator");
		String res = "";
		
		for (int i = 0; i < list.size(); i++) {
			res += quebraLinha + " index = " + i + list.get(i) + quebraLinha;
		}
				
		return res;
		
	}
	
	@Override
	public String listAll(TipoEcoPonto tipo) {
		
		String quebraLinha = System.getProperty("line.separator");
		String res = "";
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getTipo() == tipo) {				
				res += quebraLinha + " index = " + i + list.get(i) + quebraLinha;
			}
		}
				
		return res;
		
	}

	@Override
	public String toString() {
		
		return	"\n tipo: " + tipo +
				"\n latitude: " + latitude + 
				"\n longitude: " + longitude + 
				"\n logradouro: " + logradouro + 
				"\n bairro: " + bairro + 
				"\n cidade: " + cidade + 
				"\n UF: " + UF;
		
	}

	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public TipoEcoPonto getTipo() {
		return tipo;
	}

	public void setTipo(TipoEcoPonto tipo) {
		this.tipo = tipo;
	}

}
