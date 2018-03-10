package servicio_email;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;



@RestController
public class APIEmail {

	@RequestMapping(value="/ServicioMensajeria/enviarMensajeaClub",method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void getClubs(@RequestBody Mensaje cuerpoPost) throws JSONException{
		System.out.println(cuerpoPost.toString());
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
		                            .put("Email", cuerpoPost.getCorreo())
		                            .put("Name", "passenger 1")))
		                    .put(Emailv31.Message.SUBJECT, cuerpoPost.getAsunto())
		                    .put(Emailv31.Message.TEXTPART, cuerpoPost.getMensaje())
		                    .put(Emailv31.Message.HTMLPART, "<h3>"+cuerpoPost.getMensaje()+"</h3>")));
	      try {
			response = client.post(request);
			 System.out.println(response.getStatus());
		      System.out.println(response.getData());
		} catch (MailjetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MailjetSocketTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	}
}
