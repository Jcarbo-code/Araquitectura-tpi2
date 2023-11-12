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
import microservicioUsuario.controlador.UsuarioControlador;
import microservicioUsuario.dtos.*;
import microservicioUsuario.modelo.Usuario; 

@Service
public class UsuarioServicio {
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	@Autowired
	private UsuarioControlador usuarioControlador;

	
}
