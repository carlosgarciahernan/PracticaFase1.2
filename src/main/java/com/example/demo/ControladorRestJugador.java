package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springtramework.web.bind.annotation.PathVariable:						//rep
// paso de json a objeto java
// Jugadores

@RestController
public class ControladorRestJugador {

	@Autowired
	private JugadorRepositorio repositorio_de_jugadores;
	 
	
	@RequestMapping(value="/API/jugadores", method = RequestMethod.GET)
	public List<Jugador> getJugadores(){
		return repositorio_de_jugadores.findAll();
	}
	
	
	@RequestMapping(value="/API/jugadores/{JugadorName}", method = RequestMethod.GET)
	public List<Jugador> getJugador(@PathVariable("JugadorName") String JugadorName) {
		return repositorio_de_jugadores.findByNombreOrderByNombreAsc(JugadorName);
		
	}
}
