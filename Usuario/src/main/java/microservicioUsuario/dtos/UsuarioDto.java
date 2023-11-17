package microservicioUsuario.dtos;

public class UsuarioDto {
	private int cel;
	private String nombre;
	private String apellido;
	private String email;
	private String rol;

	public UsuarioDto(int cel, String nombre, String apellido, String email, String rol) {
		this.email = email;
		this.cel = cel;
		this.nombre = nombre;
		this.apellido = apellido;
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
	
	
	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}

}
