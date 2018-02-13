package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorNoticia {

	@Autowired
	private NoticiaRepositorio repositorio_de_noticias;
	
	@RequestMapping("/noticias")
	public String acceso_calendario(Model modelo) {
		return "noticias";
	}
	
	@RequestMapping("/listado_noticias")
	public String acceso_listado_noticias(Model modelo) {
		List<Noticia> lista = repositorio_de_noticias.findAll();
		modelo.addAttribute("lista",lista);
		return "listado_noticias";
	}
	
	@RequestMapping("/edicion_noticias")
	public String acceso_edicion_noticias(Model modelo) {
		return "edicion_noticias";
	}
	
	@RequestMapping("/noticia_especifica")
	public String acceso_pagina_especifica_noticia(Model modelo, @RequestParam long id) {
		Noticia noticia = repositorio_de_noticias.getOne(id);
		modelo.addAttribute("noticia",noticia);
		return "noticia_especifica";
	}
	
	@RequestMapping("url_accionar_creacion_noticias")
	public String crear_torneo(Model modelo, String titulo,String autor,String resumen,String cuerpoNoticia) {
		Noticia n = new Noticia(titulo,autor,resumen,cuerpoNoticia);
		repositorio_de_noticias.saveAndFlush(n);
		return "edicion_noticias";
	}
	
	@RequestMapping("url_accionar_listado_noticias")
	public String listar_noticias(Model modelo,String titulo) {
		List<Noticia> lista = new ArrayList<Noticia>();
			lista = repositorio_de_noticias.findByTituloOrderByTituloAsc(titulo);
		if(titulo.equals(""))
			lista = repositorio_de_noticias.findAll();
		modelo.addAttribute("lista",lista);
		return "listado_noticias";
	}
}
