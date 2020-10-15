package main.java.ecoCerto;

import main.java.org.json.JSONObject;

public class Usuario {
	
	private String nome;
	private	double latitude;
	private double longitude;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String UF;
	
	public Usuario(String cep, String nome) {
		
		JSONObject json = ApiCep.Api(cep);
		
		setNome(nome);
		setLatitude(json.getDouble("latitude"));
		setLongitude(json.getDouble("longitude"));
		setLogradouro(json.getString("logradouro"));
		setBairro(json.getString("bairro"));
		setCidade(json.getString("cidade"));
		setUF(json.getString("uf"));
		
	}
	
	
	@Override
	public String toString() {
		
		return  "\n nome= " + nome +
				"\n latitude= " + latitude + 
				"\n longitude= " + longitude + 
				"\n logradouro= " + logradouro + 
				"\n bairro= " + bairro + 
				"\n cidade= " + cidade + 
				"\n UF= " + UF;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	
	

}
