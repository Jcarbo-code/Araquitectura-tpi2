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
import microservicioCuenta.dto.UsuarioDto;
import microservicioCuenta.modelo.Cuenta;
import microservicioCuenta.repositorio.CuentaRepositorio;
import microservicioCuenta.servicio.CuentaServicio;

@RestController
@RequestMapping("/Cuenta")
public class CuentaControlador {

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
	public void modificarSaldo(@PathVariable float valor, @PathVariable int idCuenta) {
		cuentaRepositorio.modificarSaldo(valor, idCuenta);
	}

	// obtiene los usuarios asignado a la cuenta listo
	@GetMapping("/obtenerUsuarios/{idCuenta}")
	public List<UsuarioDto> obtenerUsuarios(@PathVariable int idCuenta) {
		return cuentaServicio.obtenerUsuarios(idCuenta);
	}

	// crear usuario desde aca comunicarse con el microservicio de usuario falta
	@PostMapping("/crearUsuario/{cel}/{nombre}/{apellido}/{email}/{rol}/{idCuenta}")
	public void crearUsuario(@PathVariable int cel,@PathVariable String nombre,@PathVariable String apellido,@PathVariable String email,@RequestBody String pass,@PathVariable String rol,@PathVariable int idCuenta) {
		cuentaServicio.CrearUsuario(cel,nombre,apellido,email,pass,rol,idCuenta);
	}

	// elimina un usuario asignado a la cuenta microservicio de usuario listo
	@DeleteMapping("/borrarUsuario/{idCuenta}/{nombre}/{apellido}")
	public void eliminarUsuario(@PathVariable int idCuenta, @PathVariable String nombre,
			@PathVariable String apellido) {
		cuentaServicio.eliminarUsuario(idCuenta, nombre, apellido);
	}

	// cambia el estado de cuenta a baneado
	@PutMapping("/cuenta/{idCuenta}")
	public void inhabilitarCuenta(@PathVariable int idCuenta) {
		cuentaRepositorio.inhabilitarCuenta(idCuenta);
	}
}
