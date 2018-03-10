

package servicio_noticias;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class APINoticias {

	
	@RequestMapping(value="/ServicioNoticias/solicitarNoticias", method = RequestMethod.GET)
	public top_headlines getClubs(){
		return AplicacionPrincipal.top_headlines;
	}
	
}
