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
	private ClubRepositorio repositorio_de_clubs;
	
	@Autowired
	private LigaRepositorio repositorio_de_ligas;
	
	@Autowired
	private TorneoRepositorio repositorio_de_torneos;
	
	@Autowired
	private NoticiaRepositorio repositorio_de_noticias;
	
	@Autowired
	private JugadorRepositorio repositorio_de_jugadores;
	
	@Autowired
	private PartidoRepositorio repositorio_de_partidos;
	
	@Autowired
	private SancionRepositorio repositorio_de_sanciones;
	
	
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
	
	@RequestMapping("/ligas")
	public String acceso_ligas(Model modelo) {
		return "ligas";
	}
	
	@RequestMapping("/clubs")
	public String acceso_clubs(Model modelo) {
		return "clubs";
	}
	
	@RequestMapping("/noticias")
	public String acceso_calendario(Model modelo) {
		return "noticias";
	}
	
	@RequestMapping("/jugadores")
	public String acceso_noticias(Model modelo) {
		return "jugadores";
	}
	
	@RequestMapping("/contacto")
	public String acceso_contacto(Model modelo) {
		return "contacto";
	}
	
	@RequestMapping("/listado_clubs")
	public String acceso_listado_clubs(Model modelo) {
		return "listado_clubs";
	}
	
	@RequestMapping("/edicion_clubs")
	public String acceso_edicion_clubs(Model modelo) {
		return "edicion_clubs";
	}
	
	@RequestMapping("/edicion_jugador")
	public String acceso_edicion_jugador(Model modelo) {
		return "edicion_jugador";
	}
	
	@RequestMapping("/club_especifico")
	public String acceso_pagina_especifica_club(Model modelo, @RequestParam long id) {
		Club club = repositorio_de_clubs.getOne(id);
		List<Jugador> lista = club.getJugadores();
		modelo.addAttribute("club",club);
		modelo.addAttribute("lista",lista);
		return "club_especifico";
	}
	
	@RequestMapping("/jugador_especifico")
	public String acceso_pagina_especifica_jugador(Model modelo, @RequestParam long id) {
		Jugador club = repositorio_de_jugadores.getOne(id);
		modelo.addAttribute("club",club);
		modelo.addAttribute("c_actual",club.getClubActual());
		modelo.addAttribute("sanciones",club.getSanciones());
		return "jugador_especifico";
	}
	
	@RequestMapping("/partido_especifico")
	public String acceso_pagina_especifica_partido(Model modelo, @RequestParam long id) {
		Partido partido = repositorio_de_partidos.getOne(id);
		modelo.addAttribute("partido",partido);
		List<Sancion> lista = partido.getFaltas();
		modelo.addAttribute("sanciones",lista);
		return "partido_especifico";
	}
	
	@RequestMapping("/sancion_especifica")
	public String acceso_pagina_especifica_sancion(Model modelo, @RequestParam long id) {
		Sancion sancion = repositorio_de_sanciones.getOne(id);
		modelo.addAttribute("sancion",sancion);
		modelo.addAttribute("partido",sancion.getPartido());
		modelo.addAttribute("jugador",sancion.getJugador());
		return "sancion_especifica";
	}
	
	@RequestMapping("/listado_ligas")
	public String acceso_listado_ligas(Model modelo) {
		return "listado_ligas";
	}
	
	@RequestMapping("/listado_torneos")
	public String acceso_listado_torneos(Model modelo) {
		return "listado_torneos";
	}
	
	@RequestMapping("/listado_noticias")
	public String acceso_listado_noticias(Model modelo) {
		List<Noticia> lista = repositorio_de_noticias.findAll();
		modelo.addAttribute("lista",lista);
		return "listado_noticias";
	}
	
	@RequestMapping("/edicion_ligas")
	public String acceso_edicion_ligas(Model modelo) {
		return "edicion_ligas";
	}
	
	@RequestMapping("/edicion_noticias")
	public String acceso_edicion_noticias(Model modelo) {
		return "edicion_noticias";
	}
	
	@RequestMapping("/liga_especifica")
	public String acceso_pagina_especifica_liga(Model modelo, @RequestParam long id) {
		Liga liga = repositorio_de_ligas.getOne(id);
		modelo.addAttribute("liga",liga);
		modelo.addAttribute("clubs",liga.getListado_de_clubs());
		return "liga_especifica";
	}
	
	@RequestMapping("/noticia_especifica")
	public String acceso_pagina_especifica_noticia(Model modelo, @RequestParam long id) {
		Noticia noticia = repositorio_de_noticias.getOne(id);
		modelo.addAttribute("noticia",noticia);
		return "noticia_especifica";
	}
	
	@RequestMapping("/torneo_especifico")
	public String acceso_pagina_especifico_torneo(Model modelo, @RequestParam long id) {
		Torneo liga = repositorio_de_torneos.getOne(id);
		modelo.addAttribute("liga",liga);
		modelo.addAttribute("clubs",liga.getListado_de_clubs());
		return "torneo_especifico";
	}
	
	@RequestMapping("/listado_jugadores")
	public String acceso_listado_jugadores(Model modelo) {
		List<Jugador> lista = repositorio_de_jugadores.findAll();
		modelo.addAttribute("lista",lista);
		return "listado_jugadores";
	}
	
	@RequestMapping("/edicion_partidos")
	public String accesio_editar_partidos(Model modelo) {
		return "edicion_partidos";
	}
	
}
