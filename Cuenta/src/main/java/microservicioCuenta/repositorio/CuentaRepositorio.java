package microservicioCuenta.repositorio;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import microservicioCuenta.modelo.Cuenta;

public interface CuentaRepositorio extends JpaRepository<Cuenta, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Cuenta c SET c.monto = :monto, c.mercadopago = :mercadopago, c.estado = :estado, c.fechaInicio= :fechaInicio WHERE c.idCuenta = :idCuenta")
	void actualizarCuenta(int idCuenta, String monto, String mercadopago, boolean estado, Date fechaInicio);

	@Transactional
	@Modifying
	@Query("UPDATE Cuenta c SET c.estado = false WHERE c.idCuenta = :idCuenta")
	void inhabilitarCuenta(int idCuenta);
	
	@Transactional
	@Modifying
	@Query("UPDATE Cuenta c SET c.monto = c.monto + :montoAgregar WHERE c.idCuenta = :idCuenta")
	void modificarSaldo(float montoAgregar, int idCuenta);
}
