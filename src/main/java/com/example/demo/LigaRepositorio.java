package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LigaRepositorio extends JpaRepository<Liga,Long>{

	List<Liga> findByNombreOrderByNombreAsc(String nombre);
	List<Liga> findByNombreOrderByNombreDesc(String nombre);
	
	List<Liga> findByCreadorOrderByCreadorAsc(String creador);
}
