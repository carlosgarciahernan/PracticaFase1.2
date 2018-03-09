

package servicio_noticias;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class APINoticias {

	private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
	public static top_headlines top_headlines = new top_headlines();
	
	@RequestMapping(value="/ServicioNoticias/solicitarNoticias", method = RequestMethod.GET)
	public top_headlines getClubs(){
		try {
			top_headlines = JSON_MAPPER.readValue(new URL("https://newsapi.org/v2/top-headlines?sources=marca&apiKey=b25c14b6aac64f2ba5e1a9849c995460"),top_headlines.getClass());
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
