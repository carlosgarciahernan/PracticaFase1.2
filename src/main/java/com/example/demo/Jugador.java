package com.example.demo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.ui.Model;

@Entity
public class Jugador {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String genero;
	private int edad;
	private String provincia;
	private String ciudad;
	@OneToOne
    private Club clubActual;
	
	private double altura;
	private double peso;
	private int dorsal;
	private int goles;
	private int partidos_jugados;

	private String creador;
	
	public Jugador() {
		
	}
	
	public Jugador(String nombre,String primerApellido,String segundoApellido,String genero,int edad,String provincia,String ciudad,Club clubActual,int altura,int peso,int dorsal,int goles,int partidos_jugados,String creador) {

		this.nombre=nombre;
		this.primerApellido=primerApellido;
		this.segundoApellido=segundoApellido;
		this.genero=genero;
		this.edad=edad;
		this.provincia=provincia;
		this.ciudad=ciudad;
		this.clubActual=clubActual;
		this.altura=altura;
		this.peso=peso;
		this.dorsal=dorsal;
		this.goles=goles;
		this.partidos_jugados=partidos_jugados;
		this.creador=creador;
	}
	
	

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public List<Sancion> getSanciones() {
		return sanciones;
	}

	public void setSanciones(List<Sancion> sanciones) {
		this.sanciones = sanciones;
	}


	@OneToMany
	private List<Sancion> sanciones;
	
	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	public int getPartidos_jugados() {
		return partidos_jugados;
	}

	public void setPartidos_jugados(int partidos_jugados) {
		this.partidos_jugados = partidos_jugados;
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

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public Club getClubActual() {
		return clubActual;
	}

	public void setClubActual(Club clubActual) {
		this.clubActual = clubActual;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	
	
	
}
