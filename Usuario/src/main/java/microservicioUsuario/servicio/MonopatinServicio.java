package microservicioUsuario.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import microservicioUsuario.dtos.MonopatinDto;
import microservicioUsuario.dtos.ReporteUso;


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
	public List<MonopatinDto> reporteMonopatinesCercanos(float latitud, float longitud, float margen) {
		ResponseEntity<List<MonopatinDto>> responseEntity = rest.exchange(baseUrl + "/buscarMonopatines/" + latitud+"/"+longitud+"/"+margen,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<MonopatinDto>>() {
				});

		return responseEntity.getBody();
	}

}
