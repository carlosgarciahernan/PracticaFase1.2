package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorLiga {

	@Autowired
	private LigaRepositorio repositorio_de_ligas;
	
	@Autowired
	private ClubRepositorio repositorio_de_clubs;
	
	@RequestMapping("/ligas")
	public String acceso_ligas(Model modelo) {
		return "ligas";
	}
	
	@RequestMapping("/listado_ligas")
	public String acceso_listado_ligas(Model modelo) {
		return "listado_ligas";
	}
	
	@RequestMapping("/edicion_ligas")
	public String acceso_edicion_ligas(Model modelo) {
		return "edicion_ligas";
	}
	
	@RequestMapping("/liga_especifica")
	public String acceso_pagina_especifica_liga(Model modelo, @RequestParam long id) {
		Liga liga = repositorio_de_ligas.getOne(id);
		modelo.addAttribute("liga",liga);
		modelo.addAttribute("clubs",liga.getListado_de_clubs());
		return "liga_especifica";
	}
	
	@RequestMapping("url_accionar_creacion_ligas")
	public String crear_liga(Model modelo, String nombre_liga,String organizacion) {
		List<Liga> lista = repositorio_de_ligas.findAll();
		boolean repetido=false;
		for(Liga j: lista) {
			if(j.getNombre().equals(nombre_liga)) {
				repetido=true;
				break;
			}
		}
		if(!repetido) {
			Liga l = new Liga(nombre_liga,organizacion);
			repositorio_de_ligas.save(l);
		}
		return "edicion_ligas";
	}
	
	@RequestMapping("url_accionar_listado_ligas")
	public String listar_ligas(Model modelo,String nombre_liga) {
		List<Liga> lista = new ArrayList<Liga>();
			lista = repositorio_de_ligas.findByNombreOrderByNombreAsc(nombre_liga);
		if(nombre_liga.equals(""))
			lista = repositorio_de_ligas.findAll();
		modelo.addAttribute("lista",lista);
		return "listado_ligas";
	}
	
	@RequestMapping("url_accionar_ingreso_clubs_a_liga")
	public String ingresar_clubs_a_liga(Model modelo,@RequestParam long id,@RequestParam long id_club) {
		Liga liga = repositorio_de_ligas.getOne(id);
		Club club = repositorio_de_clubs.getOne(id_club);
		liga.getListado_de_clubs().add(club);
		modelo.addAttribute("liga",liga);
		modelo.addAttribute("clubs",liga.getListado_de_clubs());
		repositorio_de_ligas.flush();
		repositorio_de_clubs.flush();
		return "liga_especifica";
	}
	
	
}
