package main.java.ecoCerto;

import java.util.ArrayList;
import java.util.List;
import main.java.org.json.JSONObject;

public class EcoPonto {
	
	private TipoEcoPonto tipo;
	private	double latitude;
	private double longitude;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String UF;
	public static List<EcoPonto> list = new ArrayList<EcoPonto>();;
	
	public EcoPonto() {}
	
	public void include(String cep, TipoEcoPonto tipo) {
		
		JSONObject json = ApiCep.Api(cep);
		EcoPonto obj = new EcoPonto();
		
		obj.setLatitude(json.getDouble("latitude"));
		obj.setLongitude(json.getDouble("longitude"));
		obj.setLogradouro(json.getString("logradouro"));
		obj.setBairro(json.getString("bairro"));
		obj.setCidade(json.getString("cidade"));
		obj.setUF(json.getString("uf"));
		obj.setTipo(tipo);
		
		list.add(obj);
		
	}
	
	public void update(int index, double latitude, double longitude, String logradouro, String bairro, String cidade, String uf) {
		
		list.get(index).setLatitude(latitude);
		list.get(index).setLongitude(longitude);
		list.get(index).setLogradouro(logradouro);
		list.get(index).setBairro(bairro);
		list.get(index).setCidade(cidade);
		list.get(index).setUF(uf);
		
	}
	
	public void delete(int index) {
		
		list.remove(index);
		
	}
	
	public String get(int index) {
		
		return list.get(index).toString();
		
	}
	
	public String listAll() {
		
		String quebraLinha = System.getProperty("line.separator");
		String res = "";
		
		for (int i = 0; i < list.size(); i++) {
			res += quebraLinha + " index= " + i + list.get(i) + quebraLinha;
		}
				
		return res;
		
	}

	@Override
	public String toString() {
		
		return	"\n tipo= " + tipo +
				"\n latitude= " + latitude + 
				"\n longitude= " + longitude + 
				"\n logradouro= " + logradouro + 
				"\n bairro= " + bairro + 
				"\n cidade= " + cidade + 
				"\n UF= " + UF;
		
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
