package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
impor org.springframework.web.bind.annotation.RestController; //rep
// pasar el .json a objetos java 
// de los clubs 
@RestController
public class ControladorRestClub {
	
	@Autowired
	private ClubRepositorio repositorio_de_clubs;
	
	@RequestMapping(value="/API/clubs", method = RequestMethod.GET)
	public List<Club> getClubs(){
		return repositorio_de_clubs.findAll();
	}
	
	
	@RequestMapping(value="/API/clubs/{clubName}", method = RequestMethod.GET)
	public List<Club> getClubs(@PathVariable("clubName") String clubName) {
		return repositorio_de_clubs.findByNombreOrderByNombreAsc(clubName);
	}
	
}
