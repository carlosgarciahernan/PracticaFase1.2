package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorClub {

	@Autowired
	private ClubRepositorio repositorio_de_clubs;
	
	@RequestMapping("/clubs")
	public String acceso_clubs(Model modelo) {
		return "clubs";
	}
	
	@RequestMapping("/listado_clubs")
	public String acceso_listado_clubs(Model modelo) {
		return "listado_clubs";
	}
	
	@RequestMapping("/edicion_clubs")
	public String acceso_edicion_clubs(Model modelo) {
		return "edicion_clubs";
	}
	
	@RequestMapping("/club_especifico")
	public String acceso_pagina_especifica_club(Model modelo, @RequestParam long id) {
		Club club = repositorio_de_clubs.getOne(id);
		List<Jugador> lista = club.getJugadores();
		modelo.addAttribute("club",club);
		modelo.addAttribute("lista",lista);
		return "club_especifico";
	}
	
	@RequestMapping("url_accionar_listado_clubs")
	public String listar_clubs(Model modelo,String nombre_club) {
		List<Club> lista = new ArrayList<Club>();
			lista = repositorio_de_clubs.findByNombreOrderByNombreAsc(nombre_club);
		if(nombre_club.equals(""))
			lista = repositorio_de_clubs.findAll();
		modelo.addAttribute("lista",lista);
		return "listado_clubs";
	}
	
	@RequestMapping("url_accionar_creacion_club")
	public String crear_club(Model modelo, String nombre_club,String abreviatura,String fecha_creacion, Authentication auth) {
		List<Club> lista = repositorio_de_clubs.findAll();
		boolean repetido=false;
		for(Club c:lista) {
			if(c.getNombre().equals(nombre_club)) {
				repetido=true;
				break;
			}
		}
		if(repetido) {
					
		}else {
			Club c = new Club(nombre_club,abreviatura,fecha_creacion,auth.getName());
			repositorio_de_clubs.save(c);
		}
		return "edicion_clubs";
	}
	
	@RequestMapping("contacto_club")
	public String acceso_contacto_club(Model modelo) {
		return "contacto_club";
	}
	
}
