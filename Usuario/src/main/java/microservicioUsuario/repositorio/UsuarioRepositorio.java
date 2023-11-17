package microservicioUsuario.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import microservicioUsuario.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

	@Query("SELECT u FROM Usuario u WHERE u.idCuenta = :idCuenta")
	List<Usuario> getUsuariosIdCuenta(int idCuenta);

	@Transactional
	@Modifying
	@Query("DELETE FROM Usuario u WHERE u.idCuenta = :idCuenta AND u.nombre = :nombre AND u.apellido = :apellido")
	void borrarUsuario(int idCuenta, String nombre, String apellido);

}
