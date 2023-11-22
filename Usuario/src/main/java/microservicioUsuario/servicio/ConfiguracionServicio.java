package microservicioUsuario.servicio;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import microservicioUsuario.dtos.PreciosDto;

@Service
public class ConfiguracionServicio {
	@Value("${configuracion_url}")
	private String baseUrl;

	private final RestTemplate rest;

	public ConfiguracionServicio(RestTemplate rest) {
		this.rest = rest;
	}

	public void crearConfiguracion(PreciosDto configuracion) {
		rest.postForEntity(baseUrl, configuracion, PreciosDto.class);
	}

}
