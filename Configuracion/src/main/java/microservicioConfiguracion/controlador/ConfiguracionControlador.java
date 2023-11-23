package microservicioConfiguracion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import microservicioConfiguracion.dto.PreciosDto;
import microservicioConfiguracion.modelo.Configuracion;
import microservicioConfiguracion.repositorio.ConfiguracionRepositorio;
import microservicioConfiguracion.servicio.ConfiguracionServicio;

@RestController
@RequestMapping("/Configuracion")
@Tag(name = "Servicio configuracion", description = "se encarga de todo lo referente a las configuraciones de los precios")
public class ConfiguracionControlador {

	@Autowired
	private ConfiguracionRepositorio configuracionRepositorio;
	@Autowired
	private ConfiguracionServicio configuracionServicio;

	// crear configuracion de viaje
	@PostMapping
	public void crearConfiguracion(@RequestBody Configuracion c) {
		configuracionRepositorio.save(c);
	}

	// devulve todos los precios
	@GetMapping("/traer")
	public List<PreciosDto> traerPrecios() {
		return configuracionServicio.traerPreciosDto();
	}

	// eliminar precio
	@DeleteMapping("/borrar/{id}")
	public void eliminarPrecio(@PathVariable int id) {
		configuracionRepositorio.deleteById(id);
	}
}