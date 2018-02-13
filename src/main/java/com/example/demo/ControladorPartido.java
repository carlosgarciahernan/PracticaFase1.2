package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorPartido {

	@Autowired
	private PartidoRepositorio repositorio_de_partidos;
	
	@Autowired
	private ClubRepositorio repositorio_de_clubs;
	
	@RequestMapping("/partido_especifico")
	public String acceso_pagina_especifica_partido(Model modelo, @RequestParam long id) {
		Partido partido = repositorio_de_partidos.getOne(id);
		modelo.addAttribute("partido",partido);
		List<Sancion> lista = partido.getFaltas();
		modelo.addAttribute("sanciones",lista);
		return "partido_especifico";
	}
	
	@RequestMapping("/edicion_partidos")
	public String accesio_editar_partidos(Model modelo) {
		return "edicion_partidos";
	}
	
	@RequestMapping("url_accionar_creacion_partido")
	public String ingresar_partidos(Model modelo,@RequestParam String resultado,@RequestParam long equipo1,@RequestParam long equipo2,@RequestParam String fecha) {
		List<Club> lista = new ArrayList<Club>(); 
		lista.add(repositorio_de_clubs.getOne(equipo1));
		lista.add(repositorio_de_clubs.getOne(equipo2));
		Partido partido = new Partido(lista.get(0),lista.get(1),fecha,resultado);
		modelo.addAttribute("partido",partido);
		repositorio_de_partidos.saveAndFlush(partido);
		return "edicion_partidos";
	}
}
