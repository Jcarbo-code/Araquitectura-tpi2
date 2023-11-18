package microservicioCuenta.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;

import io.swagger.v3.oas.annotations.tags.Tag;
import microservicioCuenta.dto.UsuarioDto;
import microservicioCuenta.modelo.Cuenta;
import microservicioCuenta.repositorio.CuentaRepositorio;
import microservicioCuenta.servicio.CuentaServicio;
import microservicioCuenta.servicio.TokenServicio;

@RestController
@RequestMapping("/Cuenta")
@Tag(name = "Servicio cuenta", description = "se encarga de todo lo referente a las cuentas")
public class CuentaControlador {

	@Autowired
	private TokenServicio token;

	@Autowired
	private CuentaRepositorio cuentaRepositorio;

	@Autowired
	private CuentaServicio cuentaServicio;

	// crear cuenta listo
	@PostMapping
	public void crearCuenta(@RequestBody Cuenta c) {
		cuentaRepositorio.save(c);
	}

	@GetMapping("/modificarSaldo/{idCuenta}/{valor}")
	public String modificarSaldo(@PathVariable float valor, @PathVariable int idCuenta,
			@RequestHeader("Authorization") String authorization) {
		if (token.autorizado(authorization) == null)
			return null;
		cuentaRepositorio.modificarSaldo(valor, idCuenta);
		return "Operacion satisfactoria";
	}

	// obtiene los usuarios asignado a la cuenta listo
	@GetMapping("/obtenerUsuarios/{idCuenta}")
	public List<UsuarioDto> obtenerUsuarios(@PathVariable int idCuenta,
			@RequestHeader("Authorization") String authorization) {
		if (token.autorizado(authorization) == null)
			return null;
		return cuentaServicio.obtenerUsuarios(idCuenta);
	}

	// crear usuario desde aca comunicarse con el microservicio de usuario falta
	@PostMapping("/crearUsuario/{cel}/{nombre}/{apellido}/{email}/{rol}/{idCuenta}")
	public String crearUsuario(@PathVariable int cel, @PathVariable String nombre, @PathVariable String apellido,
			@PathVariable String email, @RequestBody String pass, @PathVariable String rol, @PathVariable int idCuenta,
			@RequestHeader("Authorization") String authorization) {
		if (token.autorizado(authorization) == null)
			return null;
		cuentaServicio.CrearUsuario(cel, nombre, apellido, email, pass, rol, idCuenta);
		return "Operacion satisfactoria";
	}

	// elimina un usuario asignado a la cuenta microservicio de usuario listo
	@DeleteMapping("/borrarUsuario/{idCuenta}/{nombre}/{apellido}")
	public String eliminarUsuario(@PathVariable int idCuenta, @PathVariable String nombre,
			@PathVariable String apellido, @RequestHeader("Authorization") String authorization) {
		if (token.autorizado(authorization) == null)
			return null;
		cuentaServicio.eliminarUsuario(idCuenta, nombre, apellido);
		return "Operacion satisfactoria";
	}

	// cambia el estado de cuenta a baneado
	@PutMapping("/cuenta/{idCuenta}")
	public String inhabilitarCuenta(@PathVariable int idCuenta, @RequestHeader("Authorization") String authorization) {
		if (token.autorizado(authorization) == null)
			return null;
		cuentaRepositorio.inhabilitarCuenta(idCuenta);
		return "Operacion satisfactoria";
	}
}
