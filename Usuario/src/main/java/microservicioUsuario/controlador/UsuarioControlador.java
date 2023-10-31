package microservicioUsuario.controlador;

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

import microservicioUsuario.modelo.Usuario;
import microservicioUsuario.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/Usuario/usuario")
public class UsuarioControlador {

	@Autowired
	private UsuarioRepositorio viajeRepositorio;

	// crear viaje listo
	@PostMapping
	public void crearUsuario(@RequestBody Usuario u) {
		//UsuarioRepositorio.save(u);
	}
}
