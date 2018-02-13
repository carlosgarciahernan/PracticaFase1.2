package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorTorneo {

	@Autowired
	private TorneoRepositorio repositorio_de_torneos;
	
	@Autowired
	private ClubRepositorio repositorio_de_clubs;
	
	@RequestMapping("/listado_torneos")
	public String acceso_listado_torneos(Model modelo) {
		return "listado_torneos";
	}
	
	@RequestMapping("/torneo_especifico")
	public String acceso_pagina_especifico_torneo(Model modelo, @RequestParam long id) {
		Torneo liga = repositorio_de_torneos.getOne(id);
		modelo.addAttribute("liga",liga);
		modelo.addAttribute("clubs",liga.getListado_de_clubs());
		return "torneo_especifico";
	}
	
	@RequestMapping("url_accionar_creacion_torneos")
	public String crear_torneo(Model modelo, String nombre_liga,String organizacion) {
		List<Torneo> lista = repositorio_de_torneos.findAll();
		boolean repetido=false;
		for(Torneo j: lista) {
			if(j.getNombre().equals(nombre_liga)) {
				repetido=true;
				break;
			}
		}
		if(!repetido) {
			Torneo l = new Torneo(nombre_liga,organizacion);
			repositorio_de_torneos.save(l);
		}
		return "edicion_ligas";
	}
	
	@RequestMapping("url_accionar_listado_torneos")
	public String listar_torneo(Model modelo,String nombre_liga) {
		List<Torneo> lista = new ArrayList<Torneo>();
			lista = repositorio_de_torneos.findByNombreOrderByNombreAsc(nombre_liga);
		if(nombre_liga.equals(""))
			lista = repositorio_de_torneos.findAll();
		modelo.addAttribute("lista",lista);
		return "listado_torneos";
	}
	
	@RequestMapping("url_accionar_ingreso_clubs_a_torneo")
	public String ingresar_clubs_a_torneo(Model modelo,@RequestParam long id,@RequestParam long id_club) {
		Torneo torneo = repositorio_de_torneos.getOne(id);
		Club club = repositorio_de_clubs.getOne(id_club);
		modelo.addAttribute("liga",torneo);
		torneo.getListado_de_clubs().add(club);
		modelo.addAttribute("clubs",torneo.getListado_de_clubs());
		repositorio_de_torneos.flush();
		repositorio_de_clubs.flush();
		return "torneo_especifico";
	}
}
