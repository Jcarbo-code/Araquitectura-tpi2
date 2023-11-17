package microservicioConfiguracion.repositorio;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import microservicioConfiguracion.modelo.Configuracion;

public interface ConfiguracionRepositorio extends JpaRepository<Configuracion, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Configuracion c SET c.fechaCambio = :fechaCambio, c.tarifa1= :tarifa1, c.tarifa2= :tarifa2 WHERE c.id = :idConfiguracion")
	void finalizarConfiguracion(int idConfiguracion, float tarifa1, float tarifa2, Date fechaCambio);

}
