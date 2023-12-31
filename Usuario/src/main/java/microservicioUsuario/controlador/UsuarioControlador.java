package microservicioUsuario.controlador;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import microservicioUsuario.dtos.MonopatinDto;
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
	public String crearUsuario(@RequestBody Usuario u, @RequestHeader("Authorization") String authorization) {
		UsuarioRepositorio.save(u);
		return "Operacion satisfactoria";
	}

	// traer usuarios asigandos a una cuenta especifica
	@GetMapping("/traerUsuarios/{idCuenta}")
	public List<UsuarioDto> traerUsuarios(@PathVariable int idCuenta,
			@RequestHeader("Authorization") String authorization) {
		return usuarioservicio.traerUsuarios(idCuenta);
	}

	// borra un usuario de una cuenta especifica
	@DeleteMapping("/borrarUsuario/{idCuenta}/{nombre}/{apellido}")
	public String BorrarUsuarios(@PathVariable int idCuenta, @RequestHeader("Authorization") String authorization,
			@PathVariable String nombre, @PathVariable String apellido) {

		usuarioservicio.borrarUsuario(idCuenta, nombre, apellido);
		return "Operacion satisfactoria";
	}

	// iniciarViaje tengo que comunicar este microservicio con viaje y crear un
	// viaje
	@PostMapping("/iniciarViaje/{idUsuario}/{idParadaInicio}/{idMonopatin}")
	public String iniciarViaje(@PathVariable int idUsuario, @RequestHeader("Authorization") String authorization,
			@PathVariable int idParadaInicio, @PathVariable int idMonopatin) {

		usuarioservicio.crearViaje(idUsuario, idParadaInicio, idMonopatin);
		return "Operacion satisfactoria";
	}

	// tengo que comunicar con viaje
	@PostMapping("/finalizarViaje/{idViaje}/{idParada}/{kmReco}")
	public String finalizarViaje(@PathVariable int idViaje, @RequestHeader("Authorization") String authorization,
			@PathVariable int idParada, @PathVariable float kmReco) {

		usuarioservicio.finalizarViaje(idViaje, idParada, kmReco);
		return "Operacion satisfactoria";
	}

	// tengo que comunicar con parada
	@PostMapping("/crearParada/{latitud}/{longitud}")
	public String crearParada(@RequestHeader("Authorization") String authorization, @PathVariable double latitud,
			@PathVariable double longitud) {
		usuarioservicio.crearParada(latitud, longitud);
		return "Operacion satisfactoria";
	}

	// tengo que comunicar con configuracion
	@PostMapping("/crearConfiguracion/{precio1}/{precio2}/{dia}/{hora}")
	public String crearConfiguracion(@RequestHeader("Authorization") String authorization, @PathVariable float precio1,
			@PathVariable float precio2, @PathVariable Date dia, @PathVariable Time hora) {
		usuarioservicio.crearConfiguracion(precio1, precio2, dia, hora);
		return "Operacion satisfactoria";
	}

	// tengo que comunicar con configuracion
	@PostMapping("/crearMonopatin/{estado}/{latitud}/{longitud}")
	public String crearMonopatin(@PathVariable String estado, @PathVariable float latitud,
			@PathVariable float longitud) {
		usuarioservicio.crearMonopatin(estado, latitud, longitud);
		return "Operacion satisfactoria";
	}

	@GetMapping("/reporteUso/{latitud}/{longitud}/{margen}")
	public List<MonopatinDto> reporteMonopatinesCercanos(@PathVariable float latitud, @PathVariable float longitud,
			@PathVariable float margen, @RequestHeader("Authorization") String authorization) {
		return usuarioservicio.reporteMonopatinesCercanos(latitud,longitud,margen);
	}

	@GetMapping("/reporteUso/{selector}")
	public List<ReporteUso> reporteUso(@PathVariable int selector,
			@RequestHeader("Authorization") String authorization) {
		return usuarioservicio.reporteUso(selector);
	}

	@GetMapping("/reporteCantUso/{cantViajes}/{ano}")
	public List<Integer> reporteCantMonopatinesUso(@PathVariable int cantViajes,
			@RequestHeader("Authorization") String authorization, @PathVariable int ano) {
		return usuarioservicio.reporteCantMonopatinesUso(cantViajes, ano);
	}

	@GetMapping("/reporteGanancias/{fInicio}/{fFin}")
	public float Reporteganancias(@PathVariable Date fInicio, @RequestHeader("Authorization") String authorization,
			@PathVariable Date fFin) {
		return usuarioservicio.Reporteganancias(fInicio, fFin);
	}

}
