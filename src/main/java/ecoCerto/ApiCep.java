package main.java.ecoCerto;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import main.java.org.json.JSONObject;

public abstract class ApiCep {
	
	// METODO QUE TRAS O RETORNO EM JSON QUE PRECISAMOS
	public static JSONObject Api(String cep) {
		
		JSONObject json = new JSONObject();
		
		JSONObject viaCep = ApiViaCep(cep);
		JSONObject hereIs = ApiHereIs(cep);
		
		
		json.put("logradouro", viaCep.getString("logradouro"));
		json.put("bairro", viaCep.getString("bairro"));
		json.put("cidade", viaCep.getString("localidade"));
		json.put("uf", viaCep.getString("uf"));
		json.put("latitude", hereIs.getJSONArray("items")
				 				   .getJSONObject(0)
				 				   .getJSONObject("position")
				 				   .getDouble("lat"));
		json.put("longitude", hereIs.getJSONArray("items")
				 				   	.getJSONObject(0)
				 				   	.getJSONObject("position")
				 				   	.getDouble("lng"));

		return json;
		
	}

	//API PARA PEGAR DADOS DO ENDERECO
	public static JSONObject ApiViaCep(String cep) {
		
		try {
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));

            JSONObject json = new JSONObject(jsonSb.toString());
            
            return json;

        } catch (Exception e) {
        	throw new RuntimeException(e);
        }
		
	}
	
	//API PARA PEGAR LATITUDE E LONGITUDE
	public static JSONObject ApiHereIs(String cep) {
		
		try {
            URL url = new URL("https://geocode.search.hereapi.com/v1/geocode?qq=postalCode=" + cep + "&apikey=QTNtYwSF3cJtw6cK6C-PNQXwjqjtvOPf28G8_MTrwvg");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));

            JSONObject json = new JSONObject(jsonSb.toString());
            
            return json;

        } catch (Exception e) {
        	throw new RuntimeException(e);
        }
		
	}
	
}
