package com.example.demo;

public class Mensaje {

	private String correo;
	private String asunto;
	private String mensaje;
	
	public Mensaje() {
		
	}
	
	public Mensaje(String correo,String asunto,String mensaje) {
		this.correo=correo;
		this.asunto=asunto;
		this.mensaje=mensaje;
	}
	
	public String toString() {
		return "{ \n	\"correo\": \""+correo+",\"\n"+"	\"asunto\": \""+asunto+"\"\n	\"mensaje\": \""+mensaje+"\"\n}";
				
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
