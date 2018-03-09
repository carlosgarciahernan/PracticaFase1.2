package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class APINoticias {
	private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
	public static top_headlines top_headlines = new top_headlines();
	
	public static top_headlines recuperar_noticias() {
		try {
			top_headlines = JSON_MAPPER.readValue(new URL("http://127.0.0.1:5555/ServicioNoticias/solicitarNoticias"),top_headlines.getClass());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return top_headlines;
	}
}
