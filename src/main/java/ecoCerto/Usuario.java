package main.java.ecoCerto;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import main.java.org.json.JSONObject;

public class Usuario {

	private String nome;
	private double latitude;
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

	public void update(String cep) {

		JSONObject json = ApiCep.Api(cep);

		setLatitude(json.getDouble("latitude"));
		setLongitude(json.getDouble("longitude"));
		setLogradouro(json.getString("logradouro"));
		setBairro(json.getString("bairro"));
		setCidade(json.getString("cidade"));
		setUF(json.getString("uf"));

	}

	public String listUpComing(double radar) {

		String quebraLinha = System.getProperty("line.separator");
		List<EcoPonto> list = EcoPonto.list;
		String res = "";
		int total = 0;

		for (EcoPonto e : list) {
			
			double dis = distance(getLatitude(), getLongitude(), e.getLatitude(), e.getLongitude());
			
			if(dis < radar) {
				res += "\n Tipo: " + e.getTipo() +
					   "\n Distancia: " + dis + " Km" +
					   "\n Logradouro: " + e.getLogradouro() +
					   "\n Bairro: " + e.getBairro() +
					   "\n Cidade: " + e.getCidade() + 
					   quebraLinha;
				
				total++;
			}
		}

		return "Foram encontrados " + total + " EcoPontos: \n" + res;
	}

	public double distance(double lat1, double lon1, double lat2, double lon2) {

		double deg2 = Math.PI / 180;

		lat1 *= deg2;
		lon1 *= deg2;
		lat2 *= deg2;
		lon2 *= deg2;

		double radius = 6378.137;
		double dlon = lon2 - lon1;

		double distance = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(dlon)) * radius;

		String padrao = "#.#";
		DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("pt", "Brazil"));
		dfs.setDecimalSeparator('.');
		dfs.setGroupingSeparator(',');

		DecimalFormat df = new DecimalFormat(padrao, dfs);
		
		double res = Double.parseDouble(df.format(distance));

		return res;
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
