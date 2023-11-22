package microservicioUsuario.servicio;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import microservicioUsuario.dtos.ReporteUso;
import microservicioUsuario.dtos.ViajeDto;
import microservicioUsuario.modelo.viaje;

@Service
public class ViajeServicio {
	@Value("${viaje_url}")
	private String baseUrl;

	private final RestTemplate rest;

	@Autowired
	public ViajeServicio(RestTemplate rest) {
		this.rest = rest;
	}

	// creacion de viaje falta hacer
	public void crearViaje(ViajeDto nuevoViaje) {
		rest.postForEntity(baseUrl, nuevoViaje, ViajeDto.class);
	}

	// finaliza el viaje listo
	public void finalizarViaje(int idViaje, int idParada, float kmReco) {
		rest.put(baseUrl + "/finalizarViaje/" + idViaje + "/" + idParada + "/" + kmReco, null);
	}

	// pide el precio del viaje listo
	public float calcularPrecio(int idViaje) {
		return rest.getForEntity(baseUrl + "/precio/" + idViaje, Float.class).getBody();
	}

	public List<ReporteUso> reporteUso(int selector) {
		ResponseEntity<List<ReporteUso>> responseEntity = rest.exchange(baseUrl + "/reporteUso/" + selector,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<ReporteUso>>() {
				});

		return responseEntity.getBody();
	}

	public List<Integer> reporteCantMonopatinesUso(int cantViajes, int ano) {
		ResponseEntity<List<Integer>> responseEntity = rest.exchange(
				baseUrl + "/reporteMonoViaje/" + cantViajes + "/" + ano, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Integer>>() {
				});

		return responseEntity.getBody();
	}

	public float Reporteganancias(Date fInicio, Date fFin) {
		return rest.getForEntity(baseUrl + "/reporteGanancias/" + fInicio + "/" + fFin, Float.class).getBody();
	}
}
