package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Torneo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nombre;
	
	@JsonIgnore
	@OneToMany
	private List<Partido> partidos_planificados;
	
	@JsonIgnore
	@OneToMany
	private List<Club> listado_de_clubs;
	
	private String creador;
	
	private String clubs_escrito;

	private String nombre_organizacion;
	
	public String getNombre_organizacion() {
		return nombre_organizacion;
	}

	public void setNombre_organizacion(String nombre_organizacion) {
		this.nombre_organizacion = nombre_organizacion;
	}

	public String getClubs_escrito() {
		String resultado="";
		for(Club j: listado_de_clubs) {
			resultado+=j.getNombre()+", ";
		}
		return resultado;
	}

	public void setClubs_escrito(String clubs_escrito) {
		this.clubs_escrito = clubs_escrito;
	}

	
	
	

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public Torneo() {
		
	}
	
	public Torneo(String nombre,String nombre_organizacion,String creador) {
		this.nombre=nombre;
		this.nombre_organizacion=nombre_organizacion;
		this.creador=creador;
	}
	
	public List<Club> getListado_de_clubs() {
		return listado_de_clubs;
	}

	public List<Partido> getPartidos_planificados() {
		return partidos_planificados;
	}

	public void setPartidos_planificados(List<Partido> partidos_planificados) {
		this.partidos_planificados = partidos_planificados;
	}

	public void setListado_de_clubs(List<Club> listado_de_clubs) {
		this.listado_de_clubs = listado_de_clubs;
	}

	public void setListado_de_clubs(ArrayList<Club> listado_de_clubs) {
		this.listado_de_clubs = listado_de_clubs;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
