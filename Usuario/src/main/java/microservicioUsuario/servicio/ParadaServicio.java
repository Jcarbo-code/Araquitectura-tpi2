package microservicioUsuario.servicio;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import microservicioUsuario.dtos.ParadaDto;

@Service
public class ParadaServicio {
	@Value("${parada_url}")
	private String baseUrl;

	private final RestTemplate rest;

	public ParadaServicio(RestTemplate rest) {
		this.rest = rest;
	}

	public void CrearParada(ParadaDto parada) {
		rest.postForEntity(baseUrl, parada, ParadaDto.class);
	}
}
