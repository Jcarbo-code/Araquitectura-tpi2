package microservicioCuenta.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import microservicioCuenta.dto.UsuarioDto;
import microservicioCuenta.modelo.Usuario;

@Service
public class UsuarioServicio {
	@Value("${usuarios_url}")
	private String baseUrl;

	private final RestTemplate rest;

	public UsuarioServicio(RestTemplate rest) {
		this.rest = rest;
	}

	public List<UsuarioDto> traerUsuariosAsignados(int idCuenta) {
		ResponseEntity<List<UsuarioDto>> responseEntity = rest.exchange(baseUrl + "/traerUsuarios/" + idCuenta,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<UsuarioDto>>() {
				});

		return responseEntity.getBody();
	}

	public void crearUsuarios(Usuario nuevo) {
		rest.postForEntity(baseUrl, nuevo, Usuario.class);
	}

	public void BorrarUsuarioAsignado(int idCuenta, String nombre, String apellido) {
		rest.delete(baseUrl + "/borrarUsuario/" + idCuenta + "/" + nombre + "/" + apellido);
	}

}
