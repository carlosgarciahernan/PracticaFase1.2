package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorSancion {

	@Autowired
	private SancionRepositorio repositorio_de_sanciones;
	
	@Autowired
	private PartidoRepositorio repositorio_de_partidos;
	
	@Autowired
	private JugadorRepositorio repositorio_de_jugadores;
	
	@RequestMapping("/sancion_especifica")
	public String acceso_pagina_especifica_sancion(Model modelo, @RequestParam long id) {
		Sancion sancion = repositorio_de_sanciones.getOne(id);
		modelo.addAttribute("sancion",sancion);
		modelo.addAttribute("partido",sancion.getPartido());
		modelo.addAttribute("jugador",sancion.getJugador());
		return "sancion_especifica";
	}
	
	@RequestMapping("url_accionar_edicion_sanciones")
	public String ingresar_sanciones(Model modelo,@RequestParam long partido,@RequestParam long jugador,@RequestParam String detalles) {
		Sancion sancion = new Sancion(repositorio_de_partidos.getOne(partido),repositorio_de_jugadores.getOne(jugador),detalles);
		repositorio_de_sanciones.saveAndFlush(sancion);
		repositorio_de_partidos.getOne(partido).getFaltas().add(sancion);
		repositorio_de_partidos.flush();
		repositorio_de_jugadores.getOne(jugador).getSanciones().add(sancion);
		repositorio_de_sanciones.flush();
		modelo.addAttribute("partido",repositorio_de_partidos.getOne(partido));
		modelo.addAttribute("sanciones",repositorio_de_partidos.getOne(partido).getFaltas());
		return "partido_especifico";
	}
}
