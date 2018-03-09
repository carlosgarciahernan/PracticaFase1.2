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
		if(APINoticias.top_headlines.getArticles()!=null) {
		modelo.addAttribute("noticiaUna", APINoticias.top_headlines.getArticles().get(0));
		modelo.addAttribute("noticia2", APINoticias.top_headlines.getArticles().get(1));
		modelo.addAttribute("noticia3", APINoticias.top_headlines.getArticles().get(2));
		modelo.addAttribute("noticia4", APINoticias.top_headlines.getArticles().get(3));
		modelo.addAttribute("noticia5", APINoticias.top_headlines.getArticles().get(4));
		}
		return "index";
	}
	
	@RequestMapping("/contacto")
	public String acceso_contacto(Model modelo) {
		return "contacto";
	}
	
	@RequestMapping("/api")
	public String acceso_api(Model modelo) {
		return "api";
	}
}
