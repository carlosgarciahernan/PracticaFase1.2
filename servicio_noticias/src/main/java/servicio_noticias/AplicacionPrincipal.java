package servicio_noticias;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class AplicacionPrincipal {

	private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
	public static top_headlines top_headlines = new top_headlines();
	
	public static void main(String[] args) {
		final Runnable tarea = new Runnable() {
			  public void run() {
				  try {
					top_headlines = JSON_MAPPER.readValue(new URL("https://newsapi.org/v2/top-headlines?sources=marca&apiKey=b25c14b6aac64f2ba5e1a9849c995460"),top_headlines.getClass());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
			};
			ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
			timer.scheduleAtFixedRate(tarea, 1, 1, TimeUnit.MINUTES);
		SpringApplication.run(AplicacionPrincipal.class, args);
	}
	
	
}
