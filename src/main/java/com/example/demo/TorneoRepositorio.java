package com.example.demo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TorneoRepositorio extends JpaRepository<Torneo,Long>{

	List<Torneo> findByNombreOrderByNombreAsc(String nombre);
	List<Torneo> findByNombreOrderByNombreDesc(String nombre);
}
