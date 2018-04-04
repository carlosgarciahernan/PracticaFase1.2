package com.example.demo;

import java.util.List;



import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@CacheConfig(cacheNames = "Club")
public interface ClubRepositorio extends JpaRepository<Club,Long>{

	@CacheEvict(allEntries=true)
	Club save(Club club);
	
	@Cacheable
	List<Club> findByNombreOrderByNombreAsc(String nombre);
	
	@Cacheable
	List<Club> findByNombreOrderByNombreDesc(String nombre);
	
	
	List<Club> findByAbreviaturaOrderByAbreviaturaAsc(String abreviatura);
	
	
	List<Club> findByAbreviaturaOrderByAbreviaturaDesc(String abreviatura);
	
	
	List<Club> findByCreadorOrderByCreadorAsc(String creador);
}
