package microservicioCuenta.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import microservicioCuenta.dto.UsuarioDto;
import microservicioCuenta.modelo.*;

@Service
public class CuentaServicio {
	
	@Autowired
	private UsuarioServicio usuarioServicio;

	// obtiene los usuarios asignado a la cuenta se comunica al otro microservicio
	public List<UsuarioDto> obtenerUsuarios(int idCuenta) {
		List<UsuarioDto> resultado = usuarioServicio.traerUsuariosAsignados(idCuenta);
		return resultado;
	}
	
	public void CrearUsuario(int cel, String nombre, String apellido, String email, String pass, String rol, int idCuenta) {
		Usuario nuevo = new Usuario(cel,nombre,apellido,email,pass,rol,idCuenta);
		usuarioServicio.crearUsuarios(nuevo);
	}

	public void eliminarUsuario(int idCuenta, String nombre, String apellido) {
		usuarioServicio.BorrarUsuarioAsignado(idCuenta,nombre,apellido);
	}

}
