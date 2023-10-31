package microservicioUsuario.modelo;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

	// id viaje
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private int cel;

	@Column
	private String nombre;

	@Column
	private String apellido;
	
	@Column
	private String email;

	@Column
	private String pass;
	
	@Column
	private String rol;


	// constructor vacio
	public Usuario() {
	}

	public Usuario(int cel, String nombre, String apellido, String email, String pass, String rol) {
		this.email = email;
		this.cel = cel;
		this.nombre = nombre;
		this.apellido = apellido;
		this.pass = pass;
		this.rol = rol;
	}

	public int getId() {
		return id;
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

	@Override
	public String toString() {
		return "Usuario [cel=" + cel + ", nombre=" + nombre + ", apellido=" + apellido + ", email="
				+ email + ", pass=" + pass + ", rol=" + rol +  "]";
	}
}