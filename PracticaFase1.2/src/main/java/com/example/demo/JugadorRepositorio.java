package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface JugadorRepositorio extends JpaRepository<Jugador,Long>{

	List<Jugador> findByNombreOrderByNombreAsc(String nombre);
	List<Jugador> findByNombreOrderByNombreDesc(String nombre);
	
	List<Jugador> findByPrimerApellidoOrderByPrimerApellidoAsc(String primerApellido);
	List<Jugador> findByPrimerApellidoOrderByPrimerApellidoDesc(String primerApellido);
	
	List<Jugador> findBySegundoApellidoOrderBySegundoApellidoAsc(String segundoApellido);
	List<Jugador> findBySegundoApellidoOrderBySegundoApellidoDesc(String segundoApellido);
	
	List<Jugador> findByGeneroOrderByGeneroAsc(String genero);
	List<Jugador> findByGeneroOrderByGeneroDesc(String genero);
	
	List<Jugador> findByEdadOrderByEdadAsc(int edad);
	List<Jugador> findByEdadOrderByEdadDesc(int edad);
	
	List<Jugador> findByProvinciaOrderByProvinciaAsc(String provincia);
	List<Jugador> findByProvinciaOrderByProvinciaDesc(String provincia);
	
	List<Jugador> findByCreadorOrderByCreadorAsc(String creador);
	
	/*List<Jugador> findByClubActualOrderByClubActualAsc(String clubActual);
	List<Jugador> findByClubActualOrderByClubActualDesc(String clubActual);*/
}
