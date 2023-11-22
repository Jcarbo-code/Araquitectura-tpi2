package microservicioUsuario.servicio;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import microservicioUsuario.dtos.MonopatinDto;


@Service
public class MonopatinServicio {
	@Value("${monopatin_url}")
	private String baseUrl;

	private final RestTemplate rest;

	public MonopatinServicio(RestTemplate rest) {
		this.rest = rest;
	}
	public void crearMonopatin(MonopatinDto monopatin) {
		rest.postForEntity(baseUrl, monopatin, MonopatinDto.class);
	}

}
