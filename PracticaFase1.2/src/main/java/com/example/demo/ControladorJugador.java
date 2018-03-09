package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorJugador {

	@Autowired
	private JugadorRepositorio repositorio_de_jugadores;
	
	@Autowired
	private ClubRepositorio repositorio_de_clubs;
	
	@RequestMapping("/jugadores")
	public String acceso_noticias(Model modelo) {
		return "jugadores";
	}
	
	@RequestMapping("/edicion_jugador")
	public String acceso_edicion_jugador(Model modelo) {
		return "edicion_jugador";
	}
	
	@RequestMapping("/jugador_especifico")
	public String acceso_pagina_especifica_jugador(Model modelo, @RequestParam long id) {
		Jugador club = repositorio_de_jugadores.getOne(id);
		modelo.addAttribute("club",club);
		modelo.addAttribute("c_actual",club.getClubActual());
		modelo.addAttribute("sanciones",club.getSanciones());
		return "jugador_especifico";
	}
	
	@RequestMapping("/listado_jugadores")
	public String acceso_listado_jugadores(Model modelo) {
		List<Jugador> lista = repositorio_de_jugadores.findAll();
		modelo.addAttribute("lista",lista);
		return "listado_jugadores";
	}
	
	@RequestMapping("url_accionar_listado_jugadores")
	public String listar_jugadores(Model modelo,String nombre_liga) {
		List<Jugador> lista = new ArrayList<Jugador>();
			lista = repositorio_de_jugadores.findByNombreOrderByNombreAsc(nombre_liga);
		if(nombre_liga.equals(""))
			lista = repositorio_de_jugadores.findAll();
		modelo.addAttribute("lista",lista);
		return "listado_jugadores";
	}
	
	@RequestMapping("url_accionar_creacion_futbolista")
	public String crear_futbolista(Model modelo, String nombre,String primerApellido,String segundoApellido,String genero,int edad,String provincia,String ciudad,long clubActual,int altura,int peso,int dorsal,int goles,int partidos_jugados, String correo_contacto ,Authentication auth) {
		List<Jugador> lista = repositorio_de_jugadores.findAll();
		boolean repetido=false;
		for(Jugador j: lista) {
			if(j.getNombre().equals(nombre) && j.getPrimerApellido().equals(primerApellido) && j.getSegundoApellido().equals(segundoApellido)) {
				repetido=true;
				break;
			}
		}
		if(!repetido) {
			Club c = repositorio_de_clubs.getOne(clubActual);
			Jugador j= new Jugador(nombre,primerApellido,segundoApellido,genero,edad,provincia,ciudad,c,altura,peso,dorsal,goles, partidos_jugados,auth.getName(),correo_contacto);
			repositorio_de_jugadores.saveAndFlush(j);
			c.getJugadores().add(j);
			repositorio_de_clubs.flush();
		}
		return "edicion_jugador";
	}
	
	@RequestMapping("contacto_jugador")
	public String contactar_con_jugador(Model modelo) {
		return "contacto_jugador";
	}
}
