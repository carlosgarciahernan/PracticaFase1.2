package com.example.demo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Partido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	private Club equipo1;
	
	@OneToOne
	private Club equipo2;
	
	private String equipo_escrito;
	
	private String resultado;
	
	@OneToMany
	private List<Sancion> faltas;
	
	private String fecha;
	
	private String creador;
	
	public Partido() {
		
	}
	
	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}





	public Partido(Club equipo1,Club equipo2,String fecha,String resultado,String creador) {
		this.equipo1=equipo1;
		this.equipo2=equipo2;
		this.fecha=fecha;
		this.resultado=resultado;
		this.creador=creador;
	}
	
	public String getEquipo_escrito() {
		String cadena = equipo1.getNombre()+"-"+equipo2.getNombre();
		return cadena;
	}

	public void setEquipo_escrito(String equipo_escrito) {
		this.equipo_escrito = equipo_escrito;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

	public Club getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Club equipo1) {
		this.equipo1 = equipo1;
	}

	public Club getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Club equipo2) {
		this.equipo2 = equipo2;
	}

	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public List<Sancion> getFaltas() {
		return faltas;
	}

	public void setFaltas(List<Sancion> faltas) {
		this.faltas = faltas;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	
}
