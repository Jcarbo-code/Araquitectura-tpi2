package microservicioUsuario;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import microservicioUsuario.modelo.Usuario;
import microservicioUsuario.repositorio.UsuarioRepositorio;
import microservicioUsuario.servicio.UsuarioServicio;

public class usuarioIntregacionTest {
	@Mock // Clase simulada
	private UsuarioRepositorio usuarioRepositorio;

	@InjectMocks // Clase donde se inyectara el mock
	private UsuarioServicio usuarioServicio;

	// Inicializa todo
	public usuarioIntregacionTest() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void borrarUsuario() {
		// creo el usuario y lo agrego
		int idCuenta = 15;
		String nombre = "nombre";
		String apellido = "apellido";
		Usuario prueba = new Usuario(1, nombre, apellido, "email", "pass", "rol", idCuenta);
		usuarioRepositorio.save(prueba);
		// llamar al borrar del servicio con los datos del usuario
		usuarioServicio.borrarUsuario(idCuenta, nombre, apellido);
		// traer todos los usuarios que coinciden con los parametros si el tamaño es 0
		// es que lo borro
		List<Usuario> Usuarios = usuarioRepositorio.getUsuarioNombreApellidoYCuenta(idCuenta, nombre, apellido);
		assertEquals(Usuarios.size(), 0);
	}

}
