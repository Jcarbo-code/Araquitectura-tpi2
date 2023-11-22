package microservicioUsuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import microservicioUsuario.dtos.ViajeDto;
import microservicioUsuario.modelo.viaje;
import microservicioUsuario.repositorio.UsuarioRepositorio;
import microservicioUsuario.servicio.UsuarioServicio;

public class UsuarioUnitarioTest {

	@Mock // Clase simulada
	private UsuarioRepositorio usuarioRepositorio;

	@InjectMocks // Clase donde se inyectara el mock
	private UsuarioServicio usuarioServicio;

	// Inicializa todo
	public UsuarioUnitarioTest() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCrearViaje() {
		// parametros del test
		int idUsuario = 1;
		int idParadaInicio = 2;
		int idMonopatin = 3;

		// crea y devuelve
		ViajeDto resultado = usuarioServicio.crearViaje(idUsuario, idParadaInicio, idMonopatin);

		// Assert
		assertNotNull(resultado);
		assertEquals(idUsuario, resultado.getIdUsuario());
		assertEquals(idParadaInicio, resultado.getIdParadaInicio());
		assertEquals(idMonopatin, resultado.getIdMonopatin());
	}

}
