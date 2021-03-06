



# LigaURJC

#Equipo

Carlos Garcia Hernan
David Beltran Sanchez

# La documentación de la interfaz del servicio interno.
El Servicio interno esta compuesto por un baladeador con el que tiene contacto el usuario, este redirige el trafico al servicio web1 y servicio web2 
(este ultimo es una replica del primero) que dispone de una tolerancia a fallos para que en caso de caida del servicio web1 pueda redirigir al servicio web2.

Cada uno de los servicios webs tiene instalado un balanceador y cumple con 3 funciones:

1º Se encarga de balancear la carga del servicio interno noticias tanto al servicio noticias1 como al servicio noticias2, por lo que ofrece tolerancia a fallos.

2º Se encarga de balancear la carga del servicio interno noticias tanto tanto para el servicio email1 como para el servicio email2, tambien ofrece tolerancia a fallos. 

3º Como ultima funcion, el balanceador del servicio web es capaz de redirigir el trafico a la base de datos (tenemos 2 base datos, una maestro y otra esclavo) maestro comunica

a a la BBDD todo los cambios de tablas. De esta manera siempre existe una coherancia en todo momento en las tablas.
En caso de que se caiga la BBDD maestro se redirige el trafico a la BDD esclavo. Todo esta emulado en maquinas virtuales independientes

# UML
<img src="PracticaFase1.2/imagenesREADME/diagramaclases.jpg?raw=true"></img>

# Video

[![IMAGE ALT TEXT HERE](https://img.youtube.com/vi/qUx7hZ05KDs/0.jpg)](https://www.youtube.com/watch?v=qUx7hZ05KDs) 

# Descripción temática de la web:
Esta aplicación consiste en la gestión general de un equipo de fútbol en una liga. Donde podremos crear un equipo, sus jugadores, una liga, torneos externos a la liga(Champions League, Copa del Rey, etc.).

 **Parte Publica:** 
  -	Mostrar características de ligas y torneos (nº de equipos, organizacion,clubs participantes).
  -	Consultar Encuentros de una liga o torneo.
  -	Se podrá consultar los equipos de una liga, así como la información en un equipo en concreto.
  -	Detalles de un club (Nombre del club, fecha de creación, nº de jugadores).
  -	Datos de los jugadores de un equipo (Nombre, Edad, Altura, Peso, Dorsal, Goles, Partidos jugados, Sanciones)

**Parte Privada:**
  -	Un usuario podrá crear un equipo, una liga o torneo, un club también podrá unirse a una liga o torneo ya creada, así como darse de baja de uno mismo 
  -	Cada jugador podrá darse de alta en un club.
  -	Se creará una lista de sanciones donde aparecen sanciones a un club y sanciones de jugadores.
  -	Existirá un usuario administrador que se encargara de gestionar las ligas o torneos (crear ligas o torneos, modificar detalles de un club o jugador, cambiar horario de encuentro).
  
  **Servicio Interno:**
 
    
    - Actualizar las noticias.
    - Notificar convocatoria a usuarios.
    - Servicio de correo interno.


# Pasos a seguir para instalar la aplicación en la máquina virtual

PRE: Poner en pom.xml empaquetado con jar y añadir dos dependencias de com.sun.xml.bind. También instalar vagrant y virtual box.

1- Compilar en STS en  Run As -> Maven build... (Escribiendo en goals "packages")

2- Crear la Maquina virtual con vagrant init y el SO a elegir. Nosotros hemos usado ubuntu 32 y 64 indistintamente.

3- Añadir la línea "config.vm.network "forwarded_port", guest: 8443, host: 8443, host_ip: "127.0.0.1" " al archivo VagrantFile generado.

4- Arrancar la máquina virtual con vagrant up

5- Entrar en la máquina virtual con vagrant ssh

6- Actualizar ubuntu con sudo apt-get update

7- Instalar java 8. Puesto que nosotros no teniamos disponible esa opción y sólo dejaba instalar la 7 hemos usado la distribucion de oracle mediante estos comandos: 

      sudo add-apt-repository ppa:webupd8team/java    
      
      sudo apt-get install oracle-java8-installer
      
8- Instalar sql-server en la máquina virtual mediante el comando: sudo apt-get install mysql-server (Importante usar la misma contraseña que la usada en el workbench)

9- Crear una conexión en workbench de tipo Standar TCP/IP over SSH. Como SSH user poner vagrant. El SSH Key File se puede consultar mediante el comando vagrant ssh-config. 

10- Debemos poner los jar en la carpeta compartida.

11- Ejecutar mediante java -jar los archivos y ya tendremos corriendo nuestra aplicación en un servidor virtual.


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
  
  
  
# DIAGRAMAS DE CAPTURAS

<img src="PracticaFase1.2/imagenes/1-INICIO.jpg?raw=true"></img>
<img src="PracticaFase1.2/imagenes/2-LIGAS.jpg?raw=true"></img>
<img src="PracticaFase1.2/imagenes/3-LISTAR LIGAS.jpg?raw=true"></img>
<img src="PracticaFase1.2/imagenes/4-LISTAR TORNEOS.jpg?raw=true"></img>
<img src="PracticaFase1.2/imagenes/5-CREAR LIGAS Y TORNEOS.jpg?raw=true"></img>
<img src="PracticaFase1.2/imagenes/6-CLUBS.jpg?raw=true"></img>
<img src="PracticaFase1.2/imagenes/7-LISTAR CLUBS.jpg?raw=true"></img>
<img src="PracticaFase1.2/imagenes/8-CONTACTAR CON CLUB.jpg?raw=true"></img>
<img src="PracticaFase1.2/imagenes/9-CREAR CLUBS.jpg?raw=true"></img>
<img src="PracticaFase1.2/imagenes/10-JUGADORES.jpg?raw=true"></img>
<img src="PracticaFase1.2/imagenes/11-LISTAR JUGADOR.jpg?raw=true"></img>
<img src="PracticaFase1.2/imagenes/12-CONTACTAR JUGADOR.jpg?raw=true"></img>
<img src="PracticaFase1.2/imagenes/13-CREAR JUGADOR.jpg?raw=true"></img>
<img src="PracticaFase1.2/imagenes/14-NOTICIAS.jpg?raw=true"></img>
<img src="PracticaFase1.2/imagenes/15-CREAR NOTICIA REGISTRADO ADMIN.jpg?raw=true"></img>
<img src="PracticaFase1.2/imagenes/15-CREAR NOTICIA SIN REGSISTRAR.jpg?raw=true"></img>
<img src="PracticaFase1.2/imagenes/15-VER NOTICIA.jpg?raw=true"></img>

# DIAGRAMA ENTIDAD-RELACION

<img src="PracticaFase1.2/imagenesREADME/Diagrama Entidad -Relacion.jpg?raw=true"></img>

# DIAGRAMA DE CONEXION

<img src="PracticaFase1.2/imagenesREADME/diagramaCOnexiones.png?raw=true"></img>

# UML

<img src="PracticaFase1.2/PracticaFase1.2//diagramaclases.jpg?raw=true"></img>
