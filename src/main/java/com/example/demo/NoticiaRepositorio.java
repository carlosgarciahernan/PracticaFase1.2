package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepositorio extends JpaRepository<Noticia,Long>{

	List<Noticia> findByTituloOrderByTituloAsc(String titulo);
}
