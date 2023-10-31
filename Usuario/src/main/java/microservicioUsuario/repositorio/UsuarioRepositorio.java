package microservicioUsuario.repositorio;

import java.sql.Date;
import java.sql.Time;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import microservicioUsuario.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE Usuario v SET v.cel = :cel, v.nombre = :nombre,v.pass = :pass, v.rol = :rol, v.apellido = :apellido, v.email= :email WHERE v.id = :idViaje")
	void finalizarViaje(int idViaje, Date fechaFin, Time horaFin, int idParada, float kmReco);

}
