package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		//Paginas publicas
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/club_especifico.html").permitAll();
		http.authorizeRequests().antMatchers("/clubs.html").permitAll();
		http.authorizeRequests().antMatchers("/contacto.html").permitAll();
		http.authorizeRequests().antMatchers("/index.html").permitAll();
		http.authorizeRequests().antMatchers("/jugador_especifico.html").permitAll();
		http.authorizeRequests().antMatchers("/jugadores.html").permitAll();
		http.authorizeRequests().antMatchers("/liga_especifica.html").permitAll();
		http.authorizeRequests().antMatchers("/ligas.html").permitAll();
		http.authorizeRequests().antMatchers("/listado_clubs.html").permitAll();
		http.authorizeRequests().antMatchers("/listado_jugadores.html").permitAll();
		http.authorizeRequests().antMatchers("/listado_ligas.html").permitAll();
		http.authorizeRequests().antMatchers("/listado_noticias.html").permitAll();
		http.authorizeRequests().antMatchers("/listado_torneos.html").permitAll();
		http.authorizeRequests().antMatchers("/noticia_especifica.html").permitAll();
		http.authorizeRequests().antMatchers("/noticias.html").permitAll();
		http.authorizeRequests().antMatchers("/partido_especifico.html").permitAll();
		http.authorizeRequests().antMatchers("/sancion_especifica.html").permitAll();
		http.authorizeRequests().antMatchers("/torneo_especifico.html").permitAll();
		http.authorizeRequests().antMatchers("/login.html").permitAll();
		http.authorizeRequests().antMatchers("/loginerror.html").permitAll();
		http.authorizeRequests().antMatchers("/logout.html").permitAll();
		http.authorizeRequests().antMatchers("/url_accionar_listado_clubs").permitAll();
		http.authorizeRequests().antMatchers("/url_accionar_listado_jugadores").permitAll();
		http.authorizeRequests().antMatchers("/url_accionar_listado_ligas").permitAll();
		http.authorizeRequests().antMatchers("/url_accionar_listado_noticias").permitAll();
		http.authorizeRequests().antMatchers("/url_accionar_listado_torneos").permitAll();
		
		//Paginas privadas
		http.authorizeRequests().anyRequest().authenticated();
		
		//Login form
		http.formLogin().loginPage("/login.html");
		http.formLogin().usernameParameter("username");
		http.formLogin().passwordParameter("password");
		http.formLogin().defaultSuccessUrl("/home");
		http.formLogin().failureUrl("/loginerror.html");
		
		//Logout
		http.logout().logoutUrl("/logout.html");
		http.logout().logoutSuccessUrl("/index.html");
		
		
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		//User
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}
}
