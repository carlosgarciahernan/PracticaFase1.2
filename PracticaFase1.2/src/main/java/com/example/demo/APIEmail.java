package com.example.demo;


import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import org.json.JSONException;
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
		 
		Mensaje mensajes = new Mensaje(repositorio_de_clubs.getOne(id_club).getCorreo_contacto(),asunto,mensaje);
		 
		 try {
			 OkHttpClient client = new OkHttpClient();

			 MediaType mediaType = MediaType.parse("application/json");
			 RequestBody body = RequestBody.create(mediaType, "{\n\t\"correo\": \""+mensajes.getCorreo()+"\",\n\t\"asunto\": \""+mensajes.getAsunto()+"\",\n\t\"mensaje\": \""+mensajes.getMensaje()+"\"\n}");
			 Request request = new Request.Builder()
			   .url("http://127.0.0.1:4444/ServicioMensajeria/enviarMensajeaClub")
			   .post(body)
			   .addHeader("Content-Type", "application/json")
			   .addHeader("Cache-Control", "no-cache")
			   .addHeader("Postman-Token", "1fae90e0-8c7e-48dd-9abe-1e1fdfdfd2a8")
			   .build();

			 Response response = client.newCall(request).execute();
			
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		 

		 
		
		return "contacto_club";
	}
	
	@RequestMapping("url_accionar_contacto_jugador")
	public String contactar_con_jugador(Model modelo, long id_club,String asunto,String mensaje, Authentication auth) throws JSONException, MailjetException, MailjetSocketTimeoutException {
		Mensaje mensajes = new Mensaje(repositorio_de_clubs.getOne(id_club).getCorreo_contacto(),asunto,mensaje);
		 
		 try {
			 OkHttpClient client = new OkHttpClient();

			 MediaType mediaType = MediaType.parse("application/json");
			 RequestBody body = RequestBody.create(mediaType, "{\n\t\"correo\": \""+mensajes.getCorreo()+"\",\n\t\"asunto\": \""+mensajes.getAsunto()+"\",\n\t\"mensaje\": \""+mensajes.getMensaje()+"\"\n}");
			 Request request = new Request.Builder()
			   .url("http://127.0.0.1:4444/ServicioMensajeria/enviarMensajeaClub")
			   .post(body)
			   .addHeader("Content-Type", "application/json")
			   .addHeader("Cache-Control", "no-cache")
			   .addHeader("Postman-Token", "1fae90e0-8c7e-48dd-9abe-1e1fdfdfd2a8")
			   .build();

			 Response response = client.newCall(request).execute();
			
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return "contacto_jugador";
	}
	
	@RequestMapping("url_accionar_notificacion_partido")
	public String notificarProximoPartido(long equipo1,long equipo2,String fecha) throws JSONException, MailjetException, MailjetSocketTimeoutException {
		Mensaje mensaje1 = new Mensaje(repositorio_de_clubs.getOne(equipo1).getCorreo_contacto(),"NUEVO PARTIDO PLANIFICADO","El partido entre "+repositorio_de_clubs.getOne(equipo1).getNombre()+" y "+repositorio_de_clubs.getOne(equipo2).getNombre()+" tendrá lugar el "+fecha);
		Mensaje mensaje2 = new Mensaje(repositorio_de_clubs.getOne(equipo2).getCorreo_contacto(),"NUEVO PARTIDO PLANIFICADO","El partido entre "+repositorio_de_clubs.getOne(equipo1).getNombre()+" y "+repositorio_de_clubs.getOne(equipo2).getNombre()+" tendrá lugar el "+fecha);
		 
		 try {
			 OkHttpClient client = new OkHttpClient();

			 MediaType mediaType = MediaType.parse("application/json");
			 RequestBody body = RequestBody.create(mediaType, "{\n\t\"correo\": \""+mensaje1.getCorreo()+"\",\n\t\"asunto\": \""+mensaje1.getAsunto()+"\",\n\t\"mensaje\": \""+mensaje1.getMensaje()+"\"\n}");
			 Request request = new Request.Builder()
			   .url("http://127.0.0.1:4444/ServicioMensajeria/enviarMensajeaClub")
			   .post(body)
			   .addHeader("Content-Type", "application/json")
			   .addHeader("Cache-Control", "no-cache")
			   .addHeader("Postman-Token", "1fae90e0-8c7e-48dd-9abe-1e1fdfdfd2a8")
			   .build();

			 Response response = client.newCall(request).execute();
			
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		 try {
			 OkHttpClient client = new OkHttpClient();

			 MediaType mediaType = MediaType.parse("application/json");
			 RequestBody body = RequestBody.create(mediaType, "{\n\t\"correo\": \""+mensaje2.getCorreo()+"\",\n\t\"asunto\": \""+mensaje2.getAsunto()+"\",\n\t\"mensaje\": \""+mensaje2.getMensaje()+"\"\n}");
			 Request request = new Request.Builder()
			   .url("http://127.0.0.1:4444/ServicioMensajeria/enviarMensajeaClub")
			   .post(body)
			   .addHeader("Content-Type", "application/json")
			   .addHeader("Cache-Control", "no-cache")
			   .addHeader("Postman-Token", "1fae90e0-8c7e-48dd-9abe-1e1fdfdfd2a8")
			   .build();

			 Response response = client.newCall(request).execute();
			
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
	      for(Jugador j: repositorio_de_clubs.getOne(equipo1).getJugadores()) {
	    	  Mensaje mensajeJugador = new Mensaje(j.getCorreo_contacto(),"NUEVO PARTIDO PLANIFICADO","El partido entre "+repositorio_de_clubs.getOne(equipo1).getNombre()+" y "+repositorio_de_clubs.getOne(equipo2).getNombre()+" tendrá lugar el "+fecha);
	    	  try {
	 			 OkHttpClient client = new OkHttpClient();

	 			 MediaType mediaType = MediaType.parse("application/json");
	 			 RequestBody body = RequestBody.create(mediaType, "{\n\t\"correo\": \""+mensajeJugador.getCorreo()+"\",\n\t\"asunto\": \""+mensajeJugador.getAsunto()+"\",\n\t\"mensaje\": \""+mensajeJugador.getMensaje()+"\"\n}");
	 			 Request request = new Request.Builder()
	 			   .url("http://127.0.0.1:4444/ServicioMensajeria/enviarMensajeaClub")
	 			   .post(body)
	 			   .addHeader("Content-Type", "application/json")
	 			   .addHeader("Cache-Control", "no-cache")
	 			   .addHeader("Postman-Token", "1fae90e0-8c7e-48dd-9abe-1e1fdfdfd2a8")
	 			   .build();

	 			 Response response = client.newCall(request).execute();
	 			
	 	        
	 		} catch (IOException e) {
	 			// TODO Auto-generated catch block
	 		}
	      }
	      
	      for(Jugador j: repositorio_de_clubs.getOne(equipo2).getJugadores()) {
	    	  Mensaje mensajeJugador = new Mensaje(j.getCorreo_contacto(),"NUEVO PARTIDO PLANIFICADO","El partido entre "+repositorio_de_clubs.getOne(equipo1).getNombre()+" y "+repositorio_de_clubs.getOne(equipo2).getNombre()+" tendrá lugar el "+fecha);
	    	  try {
	 			 OkHttpClient client = new OkHttpClient();

	 			 MediaType mediaType = MediaType.parse("application/json");
	 			 RequestBody body = RequestBody.create(mediaType, "{\n\t\"correo\": \""+mensajeJugador.getCorreo()+"\",\n\t\"asunto\": \""+mensajeJugador.getAsunto()+"\",\n\t\"mensaje\": \""+mensajeJugador.getMensaje()+"\"\n}");
	 			 Request request = new Request.Builder()
	 			   .url("http://127.0.0.1:4444/ServicioMensajeria/enviarMensajeaClub")
	 			   .post(body)
	 			   .addHeader("Content-Type", "application/json")
	 			   .addHeader("Cache-Control", "no-cache")
	 			   .addHeader("Postman-Token", "1fae90e0-8c7e-48dd-9abe-1e1fdfdfd2a8")
	 			   .build();

	 			 Response response = client.newCall(request).execute();
	 			
	 	        
	 		} catch (IOException e) {
	 			// TODO Auto-generated catch block
	 		}
	      }
	      return "edicion_partidos";
	}
}
