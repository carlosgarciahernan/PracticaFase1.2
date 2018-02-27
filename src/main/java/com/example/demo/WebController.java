package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WebController {
	
	@Autowired
	private JugadorRepositorio repositorio_de_jugadores;
	
	@Autowired
	private ClubRepositorio repositorio_de_clubs;
	
	@Autowired 
	private LigaRepositorio repositorio_de_ligas;
	
	@Autowired
	private TorneoRepositorio repositorio_de_torneos;
	
	@Autowired
	private SancionRepositorio repositorio_de_sanciones;
	
	@Autowired
	private NoticiaRepositorio repositorio_de_noticias;
	
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
    	return "login";
    }

    @GetMapping("/loginerror")
    public String loginerror() {
    	return "loginerror";
    }

    @GetMapping("/home")
    public String home(Model model, HttpServletRequest request, Authentication auth) {
    	model.addAttribute("admin", request.isUserInRole("ADMIN"));
    	model.addAttribute("lista_jugadores_propios",repositorio_de_jugadores.findByCreadorOrderByCreadorAsc(auth.getName()));
    	model.addAttribute("lista_clubs_propios",repositorio_de_clubs.findByCreadorOrderByCreadorAsc(auth.getName()));
    	model.addAttribute("lista_ligas_propias",repositorio_de_ligas.findByCreadorOrderByCreadorAsc(auth.getName()));
    	model.addAttribute("lista_torneos_propios",repositorio_de_torneos.findByCreadorOrderByCreadorAsc(auth.getName()));
    	return "home";
    }

    
    @GetMapping("/admin")
    public String admin(Model model, Authentication auth) {
    	model.addAttribute("lista_noticias_propias",repositorio_de_noticias.findByCreadorOrderByCreadorAsc(auth.getName()));
    	model.addAttribute("lista_sanciones_propias",repositorio_de_sanciones.findByCreadorOrderByCreadorAsc(auth.getName()));
    	return "admin";
    }

}