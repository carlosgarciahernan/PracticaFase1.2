package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ClubRepositorio extends JpaRepository<Club,Long>{

	List<Club> findByNombreOrderByNombreAsc(String nombre);
	List<Club> findByNombreOrderByNombreDesc(String nombre);
	
	List<Club> findByAbreviaturaOrderByAbreviaturaAsc(String abreviatura);
	List<Club> findByAbreviaturaOrderByAbreviaturaDesc(String abreviatura);
}
