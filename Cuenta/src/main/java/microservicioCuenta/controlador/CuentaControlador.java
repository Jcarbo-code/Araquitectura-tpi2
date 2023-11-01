package microservicioCuenta.controlador;

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

import microservicioCuenta.modelo.Cuenta;
import microservicioCuenta.repositorio.CuentaRepositorio;

@RestController
@RequestMapping("/Cuenta/Cuenta")
public class CuentaControlador {

	@Autowired
	private CuentaRepositorio cuentaRepositorio;

	// crear cuenta listo
	@PostMapping
	public void crearCuenta(@RequestBody Cuenta c) {
		//cuentaRepositorio.(c);
	}

	// cambia el estado de cuenta a baneado
	@PutMapping("/cuenta/{idCuenta}")
	public void inhabilitarCuenta(@PathVariable int idCuenta) {
		cuentaRepositorio.inhabilitarCuenta(idCuenta);
	}
}
