package servicio_email;

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

	
	public static void main(String[] args) {
		SpringApplication.run(AplicacionPrincipal.class, args);
	}
	
	
}
