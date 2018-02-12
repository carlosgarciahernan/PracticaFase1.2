package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorBaseDeDatos{

	@Autowired
	private ClubRepositorio repositorio_de_clubs;
	
	@Autowired
	private JugadorRepositorio repositorio_de_jugadores;
	
	@Autowired
	private LigaRepositorio repositorio_de_ligas;
	
	@Autowired
	private TorneoRepositorio repositorio_de_torneos;
	
	@Autowired
	private NoticiaRepositorio repositorio_de_noticias;
	
	@Autowired
	private PartidoRepositorio repositorio_de_partidos;
	
	@Autowired
	private SancionRepositorio repositorio_de_sanciones;

	//Lista los clubs que se llaman como la palabre introducida en el formulatio. Si el formulario está vacio se listan todos los clubs
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
	public String crear_club(Model modelo, String nombre_club,String abreviatura,String fecha_creacion) {
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
			Club c = new Club(nombre_club,abreviatura,fecha_creacion);
			repositorio_de_clubs.save(c);
		}
		return "edicion_clubs";
	}
	
	@RequestMapping("url_accionar_creacion_futbolista")
	public String crear_futbolista(Model modelo, String nombre,String primerApellido,String segundoApellido,String genero,int edad,String provincia,String ciudad,long clubActual,int altura,int peso,int dorsal,int goles,int partidos_jugados) {
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
			Jugador j= new Jugador(nombre,primerApellido,segundoApellido,genero,edad,provincia,ciudad,c,altura,peso,dorsal,goles, partidos_jugados);
			repositorio_de_jugadores.saveAndFlush(j);
			c.getJugadores().add(j);
			repositorio_de_clubs.flush();
		}
		return "edicion_jugador";
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
	
	@RequestMapping("url_accionar_creacion_noticias")
	public String crear_torneo(Model modelo, String titulo,String autor,String resumen,String cuerpoNoticia) {
		Noticia n = new Noticia(titulo,autor,resumen,cuerpoNoticia);
		repositorio_de_noticias.saveAndFlush(n);
		return "edicion_noticias";
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
	
	@RequestMapping("url_accionar_listado_noticias")
	public String listar_noticias(Model modelo,String titulo) {
		List<Noticia> lista = new ArrayList<Noticia>();
			lista = repositorio_de_noticias.findByTituloOrderByTituloAsc(titulo);
		if(titulo.equals(""))
			lista = repositorio_de_noticias.findAll();
		modelo.addAttribute("lista",lista);
		return "listado_noticias";
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
	
	@RequestMapping("url_accionar_ingreso_clubs_a_torneo")
	public String ingresar_clubs_a_torneo(Model modelo,@RequestParam long id,@RequestParam long id_club) {
		Torneo torneo = repositorio_de_torneos.getOne(id);
		Club club = repositorio_de_clubs.getOne(id_club);
		modelo.addAttribute("liga",torneo);
		torneo.getListado_de_clubs().add(club);
		modelo.addAttribute("clubs",torneo.getListado_de_clubs());
		repositorio_de_ligas.flush();
		repositorio_de_clubs.flush();
		return "torneo_especifico";
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
