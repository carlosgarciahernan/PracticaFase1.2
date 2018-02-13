

# LigaURJC

#Equipo

Carlos Garcia Hernan
David Beltran Sanchez
# Descripción temática de la web:
Esta aplicación consiste en la gestión general de un equipo de fútbol en una liga. Donde podremos crear un equipo, sus jugadores, una liga, torneos externos a la liga(Champions League, Copa del Rey, etc.).

 **Parte Publica:** 
  -	Mostrar características de ligas y torneos (nº de equipos, descensos y ascensos, sorteos de emparejamientos, reglas).
  -	Consultar Encuentros y clasificación de una liga o torneo.
  -	Se podrá consultar los equipos de una liga, así como la información en un equipo en concreto.
  -	Detalles de un club (Nombre del club, fecha de creación, nº de jugadores).
  -	Datos de los jugadores de un equipo (Nombre, Edad, Altura, Peso, Dorsal, Goles, Partidos jugados, Sanciones)

**Parte Privada:**
  -	Un usuario podrá crear un equipo, una liga o torneo, el usuario también podrá unirse a una liga o torneo ya creada, así como darse de baja de uno mismo 
  -	Cada jugador podrá darse de alta/baja en un club.
  -	Se creará una lista de sanciones donde aparecen sanciones a un club y sanciones de jugadores.
  -	Existirá un usuario administrador que se encargara de gestionar las ligas o torneos (crear ligas o torneos, modificar detalles de un club o jugador, cambiar horario de encuentro).
  
  **Servicio Interno:**
 
    
    - Actualizar la clasificación
    - Notificar convocatoria a usuarios.
    - Servicio de correo interno.

# Entidades Principales:

  -USUARIO: existen 3 tipos de usuarios:
   -	Jugador: darse de alta / baja en un club
   -	Administrador: Crear/ Eliminar ligas o torneos y administrarlas. 
   -	Presidente: Crear/ Eliminar un club.
   
  -LIGA / TORNEO: Donde se dan los encuentros entre los distintos clubs que participan en ellos (Podrán escribirse un nº máximo de clubs).
  
  -CLASIFICACION: Listado ordenado de los clubs según puntuación.
  
  -EQUIPO: Formado por un nombre único, palmares y jugadores inscritos.
  
  -JUGADOR: contendrá todos sus datos (Nombre, Edad, Altura, Peso, etc.)
  
  -PARTIDO: lugar de encuentro, horario del encuentro, clubs enfrentados, resultado, su liga o torneo
  
  
  
# Diagrama entidad/relacion

<img src="imagenesREADME/1-INICIO.jpg?raw=true"></img>

