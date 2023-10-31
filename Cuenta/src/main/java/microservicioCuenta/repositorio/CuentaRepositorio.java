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
	@Query("UPDATE cuenta c SET c.montos = :montos, c.mercadopago = :mercadopago, c.estado = :estado, c.fechaInicio= :fechaInicio WHERE c.id = :idcuenta")
	void finalizarCuenta(int idCuenta, String montos, String mercadopago, boolean estado, Date fechaInicio);

}
