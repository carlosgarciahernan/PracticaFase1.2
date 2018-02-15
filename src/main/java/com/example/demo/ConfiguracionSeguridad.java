package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		//Paginas publicas
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/club_especifico").permitAll();
		http.authorizeRequests().antMatchers("/clubs").permitAll();
		http.authorizeRequests().antMatchers("/contacto").permitAll();
		http.authorizeRequests().antMatchers("/index").permitAll();
		http.authorizeRequests().antMatchers("/jugador_especifico").permitAll();
		http.authorizeRequests().antMatchers("/jugadores").permitAll();
		http.authorizeRequests().antMatchers("/liga_especifica").permitAll();
		http.authorizeRequests().antMatchers("/ligas").permitAll();
		http.authorizeRequests().antMatchers("/listado_clubs").permitAll();
		http.authorizeRequests().antMatchers("/listado_jugadores").permitAll();
		http.authorizeRequests().antMatchers("/listado_ligas").permitAll();
		http.authorizeRequests().antMatchers("/listado_noticias").permitAll();
		http.authorizeRequests().antMatchers("/listado_torneos").permitAll();
		http.authorizeRequests().antMatchers("/noticia_especifica").permitAll();
		http.authorizeRequests().antMatchers("/noticias").permitAll();
		http.authorizeRequests().antMatchers("/partido_especifico").permitAll();
		http.authorizeRequests().antMatchers("/sancion_especifica").permitAll();
		http.authorizeRequests().antMatchers("/torneo_especifico").permitAll();
		
		//Paginas privadas
		
		
		//Login form
		
		//Logout
		
		
		//Disable CSRF at the moment
	}
}
