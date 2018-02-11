package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Club {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nombre;
	
	@OneToMany
	private List<Jugador> jugadores;
	
	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	private String jugadores_escrito;
	private String fecha_creacion;
	
	
	public String getJugadores_escrito() {
		String resultado="";
		for(Jugador j: jugadores) {
			resultado+=j.getNombre()+" "+j.getPrimerApellido()+" "+j.getSegundoApellido()+", ";
		}
		return resultado;
	}

	public void setJugadores_escrito(String jugadores_escrito) {
		this.jugadores_escrito = jugadores_escrito;
	}

	//private Presidente presidente;
	private String abreviatura;
	//private List<Liga> participa_liga;
	//private List<Torneo> participa_torneo;
	
	
	public Club() {
		
	}
	
	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
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

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public Club(String nombre,String abreviatura,String fecha_creacion) {
		this.nombre=nombre;
		jugadores = new ArrayList<Jugador>();
		this.abreviatura=abreviatura;
		this.fecha_creacion=fecha_creacion;
	}
}
