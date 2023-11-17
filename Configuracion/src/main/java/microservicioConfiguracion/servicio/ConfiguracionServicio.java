package microservicioConfiguracion.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservicioConfiguracion.dto.PreciosDto;
import microservicioConfiguracion.modelo.Configuracion;
import microservicioConfiguracion.repositorio.ConfiguracionRepositorio;

@Service
public class ConfiguracionServicio {

	@Autowired
	private ConfiguracionRepositorio configuracionRepositorio;

	public List<PreciosDto> traerPreciosDto() {
		List<Configuracion> todos = configuracionRepositorio.findAll();
		List<PreciosDto> resultado = new ArrayList<>();
		for (int i = 0; i < todos.size(); i++) {
			PreciosDto nuevo = new PreciosDto(todos.get(i).getFechaCambio(), todos.get(i).getHoraCambio(),
					todos.get(i).getTarifa1(), todos.get(i).getTarifa2());
			resultado.add(nuevo);
		}
		return resultado;
	}

}
