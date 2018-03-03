package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorRestLiga {

	@Autowired
	private LigaRepositorio repositorio_de_ligas;
	
	@RequestMapping(value="/API/ligas", method = RequestMethod.GET)
	public List<Liga> getLigas(){
		return repositorio_de_ligas.findAll();
	}
	
	@RequestMapping(value="/API/ligas/{ligaName}", method = RequestMethod.GET)
	public List<Liga> getClubs(@PathVariable("ligaName") String ligaName) {
		return repositorio_de_ligas.findByNombreOrderByNombreAsc(ligaName);
	}
}
