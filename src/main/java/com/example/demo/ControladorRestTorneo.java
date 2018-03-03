package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorRestTorneo {

	@Autowired
	private TorneoRepositorio repositorio_de_torneos;
	
	@RequestMapping(value="/API/torneos", method = RequestMethod.GET)
	public List<Torneo> getTorneos(){
		return repositorio_de_torneos.findAll();
	}
	
	@RequestMapping(value="/API/torneos/{torneoName}", method = RequestMethod.GET)
	public List<Torneo> getTorneo(@PathVariable("torneoName") String torneoName) {
		return repositorio_de_torneos.findByNombreOrderByNombreAsc(torneoName);
	}
}
