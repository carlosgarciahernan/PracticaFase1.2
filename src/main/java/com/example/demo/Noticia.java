package com.example.demo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Noticia {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getCuerpoNoticia() {
		return cuerpoNoticia;
	}

	public void setCuerpoNoticia(String cuerpoNoticia) {
		this.cuerpoNoticia = cuerpoNoticia;
	}
	private String titulo;
	private String resumen;
	private String cuerpoNoticia;
	private String autor;
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}


	
	public Noticia(String titulo,String autor,String resumen,String cuerpoNoticia) {
		this.titulo=titulo;
		this.autor=autor;
		this.resumen=resumen;
		this.cuerpoNoticia=cuerpoNoticia;
	}

	public Noticia() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
}
