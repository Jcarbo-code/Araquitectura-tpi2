package microservicioUsuario.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CuentaServicio {
	@Value("${cuenta_url}")
	private String baseUrl;

	private final RestTemplate rest;

	@Autowired
	public CuentaServicio(RestTemplate rest) {
		this.rest = rest;
	}

	// sirve para modificar el saldo de la cuenta asociada permite descontar como
	// agregar
	public void modificarSaldo(int idCuenta, float saldo) {
		rest.put(baseUrl + "/modificarSaldo/" + idCuenta + "/" + saldo, null);
	}
}
