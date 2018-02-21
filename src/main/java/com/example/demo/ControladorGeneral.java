package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorGeneral {
	
	@Autowired
	private NoticiaRepositorio repositorio_de_noticias;
	
	@Autowired
	private PartidoRepositorio repositorio_de_partidos;
	

	@RequestMapping("/index")
	public String peticiones_entrantes(Model modelo) {
		int numeroPartidos = (int)repositorio_de_partidos.count();
		List<Partido> lista_partidos = new ArrayList<Partido>();
		for(int i=numeroPartidos;i>numeroPartidos-5;i--) {
			if(i>0){
				lista_partidos.add(repositorio_de_partidos.getOne((long)i));
			}
		}
		modelo.addAttribute("partidos",lista_partidos);
		int numeroNoticias = (int)repositorio_de_noticias.count();
		if(numeroNoticias>0) {
			modelo.addAttribute("noticiaUna",repositorio_de_noticias.getOne((long)numeroNoticias));
		}
		if(numeroNoticias-1>0) {
			modelo.addAttribute("noticia2",repositorio_de_noticias.getOne((long)numeroNoticias-1));
		}
		if(numeroNoticias-2>0) {
			modelo.addAttribute("noticia3",repositorio_de_noticias.getOne((long)numeroNoticias-2));
		}
		if(numeroNoticias-3>0) {
			modelo.addAttribute("noticia4",repositorio_de_noticias.getOne((long)numeroNoticias-3));
		}
		if(numeroNoticias-4>0) {
			modelo.addAttribute("noticia5",repositorio_de_noticias.getOne((long)numeroNoticias-4));
		}
		return "index";
	}
	
	@RequestMapping("/contacto")
	public String acceso_contacto(Model modelo) {
		return "contacto";
	}
	
	@RequestMapping("/login")
	public String acceso_login(Model modelo) {
		return "login";
	}
	
	@RequestMapping("/home")
	public String acceso_home(Model modelo) {
		return "home";
	}
	
	@RequestMapping("/loginerror")
	public String acceso_loginerror(Model modelo) {
		return "loginerror";
	}
	
	
}
