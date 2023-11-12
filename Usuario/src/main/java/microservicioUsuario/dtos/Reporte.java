package microservicioUsuario.dtos;

import jakarta.persistence.Column;

public class Reporte {
	private int cel;
	private String nombre;
	private String apellido;
	private String email;
	private String pass;
	private String rol;

	public Reporte(int cel, String nombre, String apellido, String email, String pass, String rol) {
		this.email = email;
		this.cel = cel;
		this.nombre = nombre;
		this.apellido = apellido;
		this.pass = pass;
		this.rol = rol;
	}

	public int getCel() {
		return cel;
	}
	
	public void setCel(int cel) {
		this.cel = cel;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}

}
