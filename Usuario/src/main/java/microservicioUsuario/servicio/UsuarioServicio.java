package microservicioUsuario.servicio;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservicioUsuario.repositorio.UsuarioRepositorio;
import microservicioUsuario.dtos.*;
import microservicioUsuario.modelo.Usuario;
import microservicioUsuario.modelo.viaje;

@Service
public class UsuarioServicio {
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	@Autowired
	private ViajeServicio viajeServicio;
	@Autowired
	private ParadaServicio paradaServicio;
	@Autowired
	private ConfiguracionServicio configuracionServicio;
	@Autowired
	private MonopatinServicio monopatinServicio;
	@Autowired
	private CuentaServicio cuentaServicio;

	public List<UsuarioDto> traerUsuarios(int idCuenta) {
		List<Usuario> usuarios = usuarioRepositorio.getUsuariosIdCuenta(idCuenta);
		List<UsuarioDto> resultado = new ArrayList<>();
		for (int i = 0; i < usuarios.size(); i++) {
			int telefono = usuarios.get(i).getCel();
			String nombre = usuarios.get(i).getNombre();
			String apellido = usuarios.get(i).getApellido();
			String email = usuarios.get(i).getEmail();
			String rol = usuarios.get(i).getRol();
			UsuarioDto nuevo = new UsuarioDto(telefono, nombre, apellido, email, rol);
			resultado.add(nuevo);
		}
		return resultado;
	}

	public void borrarUsuario(int idCuenta, String nombre, String apellido) {
		usuarioRepositorio.borrarUsuario(idCuenta, nombre, apellido);
	}

	public void finalizarViaje(int idViaje, int idParada, float kmReco) {
		viajeServicio.finalizarViaje(idViaje, idParada, kmReco);
		float precioViaje = viajeServicio.calcularPrecio(idViaje);
		cuentaServicio.modificarSaldo(idParada, precioViaje);
	}

	public List<ReporteUso> reporteUso(int selector) {
		return viajeServicio.reporteUso(selector);
	}

	public List<Integer> reporteCantMonopatinesUso(int cantViajes, int ano) {
		return viajeServicio.reporteCantMonopatinesUso(cantViajes, ano);
	}

	public float Reporteganancias(Date fInicio, Date fFin) {
		return viajeServicio.Reporteganancias(fInicio, fFin);
	}

	public viaje crearViaje(int idUsuario, int idParadaInicio, int idMonopatin) {
		// aclaracion para que funcione el test de la funcion hay que comentar la linea
		// del viajeServicio.crearViaje()
		Date diaActual = Date.valueOf(LocalDate.now());
		LocalTime horaActual = LocalTime.now();
		Time hora = Time.valueOf(horaActual);
		viaje nuevoViaje = new viaje(idUsuario, idParadaInicio, idMonopatin, diaActual, hora);
		viajeServicio.crearViaje(nuevoViaje);
		return nuevoViaje;
	}

	public void crearParada(double latitud, double longitud) {
		ParadaDto parada = new ParadaDto(latitud, longitud);
		paradaServicio.CrearParada(parada);
	}

	public void crearConfiguracion(float precio1, float precio2, Date dia, Time hora) {
		PreciosDto configuracion = new PreciosDto(dia, hora, precio1, precio2);
		configuracionServicio.crearConfiguracion(configuracion);
	}

	public void crearMonopatin(String estado, float latitud, float longitud) {
		MonopatinDto monopatin = new MonopatinDto(estado, latitud, longitud);
		monopatinServicio.crearMonopatin(monopatin);
	}

}
