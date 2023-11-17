package microservicioUsuario.controlador;

import java.sql.Date;
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
import microservicioUsuario.dtos.ReporteUso;
import microservicioUsuario.dtos.UsuarioDto;
import microservicioUsuario.modelo.Usuario;
import microservicioUsuario.repositorio.UsuarioRepositorio;
import microservicioUsuario.servicio.UsuarioServicio;

@RestController
@RequestMapping("/Usuario")
@Tag(name = "Servicio usuario", description = "se encarga de todo lo referente a los usuarios y la generacion de reportes")
public class UsuarioControlador {

	@Autowired
	private UsuarioRepositorio UsuarioRepositorio;

	@Autowired
	private UsuarioServicio usuarioservicio;

	// crear usser listo
	@PostMapping
	public void crearUsuario(@RequestBody Usuario u) {
		UsuarioRepositorio.save(u);
	}

	// traer usuarios asigandos a una cuenta especifica
	@GetMapping("/traerUsuarios/{idCuenta}")
	public List<UsuarioDto> traerUsuarios(@PathVariable int idCuenta) {
		return usuarioservicio.traerUsuarios(idCuenta);
	}

	// borra un usuario de una cuenta especifica
	@DeleteMapping("/borrarUsuario/{idCuenta}/{nombre}/{apellido}")
	public void BorrarUsuarios(@PathVariable int idCuenta, @PathVariable String nombre, @PathVariable String apellido) {
		usuarioservicio.borrarUsuario(idCuenta, nombre, apellido);
	}

	// iniciarViaje tengo que comunicar este microservicio con viaje y crear un
	// viaje
	@PostMapping("/iniciarViaje/{idUsuario/{idParadaInicio}/{idMonopatin")
	public void iniciarViaje(@PathVariable int idUsuario,@PathVariable int idParadaInicio,@PathVariable int idMonopatin) {
		usuarioservicio.crearViaje(idUsuario,idParadaInicio,idMonopatin);
	}

	// tengo que comunicar con viaje
	@PostMapping("/finalizarViaje/{idViaje}/{idParada}/{kmReco}")
	public void finalizarViaje(@PathVariable int idViaje,@PathVariable int idParada,@PathVariable float kmReco) {
		usuarioservicio.finalizarViaje(idViaje,idParada,kmReco);
	}

	@GetMapping("/reporteUso/{selector}")
	public List<ReporteUso> reporteUso(@PathVariable int selector) {
		return usuarioservicio.reporteUso(selector);
	}
	
	@GetMapping("/reporteCantUso/{cantViajes}/{ano}")
	public List<Integer> reporteCantMonopatinesUso(@PathVariable int cantViajes,@PathVariable int ano) {
		return usuarioservicio.reporteCantMonopatinesUso(cantViajes,ano);
	}
	
	@GetMapping("/reporteGanancias/{fInicio}/{fFin}")
	public float Reporteganancias(@PathVariable Date fInicio,@PathVariable Date fFin) {
		return usuarioservicio.Reporteganancias(fInicio,fFin);
	}
	/*
	 * reportes
	 */
}
