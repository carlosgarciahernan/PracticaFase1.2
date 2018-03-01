package com.example.demo;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class APIEmail {

	@Autowired
	private ClubRepositorio repositorio_de_clubs;
	
	@Autowired
	private JugadorRepositorio repositorio_de_jugadores;
	
	@RequestMapping("url_accionar_contacto_club")
	public String contactar_con_club(Model modelo, long id_club,String asunto,String mensaje, Authentication auth) throws JSONException, MailjetException, MailjetSocketTimeoutException {
		 MailjetClient client;
	      MailjetRequest request;
	      MailjetResponse response;
	      client = new MailjetClient("cc6a41628b7f05daa9ca653bde779ea1", "cd294e4d31df1d422df5e0c8cf23120c", new ClientOptions("v3.1"));
	      request = new MailjetRequest(Emailv31.resource)
	            .property(Emailv31.MESSAGES, new JSONArray()
	                .put(new JSONObject()
	                    .put(Emailv31.Message.FROM, new JSONObject()
	                        .put("Email", "carlosgarciaher_@hotmail.com")
	                        .put("Name", "Carlos"))
	                    .put(Emailv31.Message.TO, new JSONArray()
	                        .put(new JSONObject()
	                            .put("Email", repositorio_de_clubs.getOne(id_club).getCorreo_contacto())
	                            .put("Name", "passenger 1")))
	                    .put(Emailv31.Message.SUBJECT, asunto)
	                    .put(Emailv31.Message.TEXTPART, mensaje)
	                    .put(Emailv31.Message.HTMLPART, "<h3>"+mensaje+"</h3>")));
	      response = client.post(request);
	      System.out.println(response.getStatus());
	      System.out.println(response.getData());
		
		return "contacto_club";
	}
	
	@RequestMapping("url_accionar_contacto_jugador")
	public String contactar_con_jugador(Model modelo, long id_club,String asunto,String mensaje, Authentication auth) throws JSONException, MailjetException, MailjetSocketTimeoutException {
		 MailjetClient client;
	      MailjetRequest request;
	      MailjetResponse response;
	      client = new MailjetClient("cc6a41628b7f05daa9ca653bde779ea1", "cd294e4d31df1d422df5e0c8cf23120c", new ClientOptions("v3.1"));
	      request = new MailjetRequest(Emailv31.resource)
	            .property(Emailv31.MESSAGES, new JSONArray()
	                .put(new JSONObject()
	                    .put(Emailv31.Message.FROM, new JSONObject()
	                        .put("Email", "carlosgarciaher_@hotmail.com")
	                        .put("Name", "Carlos"))
	                    .put(Emailv31.Message.TO, new JSONArray()
	                        .put(new JSONObject()
	                            .put("Email", repositorio_de_jugadores.getOne(id_club).getCorreo_contacto())
	                            .put("Name", "passenger 1")))
	                    .put(Emailv31.Message.SUBJECT, asunto)
	                    .put(Emailv31.Message.TEXTPART, mensaje)
	                    .put(Emailv31.Message.HTMLPART, "<h3>"+mensaje+"</h3>")));
	      response = client.post(request);
	      System.out.println(response.getStatus());
	      System.out.println(response.getData());
		
		return "contacto_club";
	}
}
