package microservicioConfiguracion.controlador;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservicioConfiguracion.modelo.Configuracion;
import microservicioConfiguracion.repositorio.ConfiguracionRepositorio;

@RestController
@RequestMapping("/Configuracion/Configuracion")
public class ConfiguracionControlador {

	@Autowired
	private ConfiguracionRepositorio configuracionRepositorio;

	// crear configuracion de viaje
	@PostMapping
	public void crearConfiguracion(@RequestBody Configuracion c) {
		configuracionRepositorio.save(c);
	}
	
}
