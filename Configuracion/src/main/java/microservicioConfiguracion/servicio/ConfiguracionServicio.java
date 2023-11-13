package microservicioConfiguracion.servicio;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.read.ListAppender;
import microservicioConfiguracion.repositorio.ConfiguracionRepositorio;
import microservicioConfiguracion.controlador.ConfiguracionControlador;
import microservicioConfiguracion.dtos.*;
import microservicioConfiguracion.modelo.Configuracion; 

@Service
public class ConfiguracionServicio {
	@Autowired
	private ConfiguracionRepositorio configuracionRepositorio;
	@Autowired
	private ConfiguracionControlador confioguracionControlador;

	private List<Reporte> reporte() {
		
		List<Configuracion> Configuraciones = configuracionRepositorio.findAll();
		List<Reporte> resultados = new ArrayList<>();
		for (Configuracion Configuracion : Configuraciones) {		
				int idConfig = Configuracion.getId();
				Date fechaCambio = Configuracion.getFechaCambio();
				Time horaCambio = Configuracion.getHoraCambio();
				float tarifa1 = Configuracion.getTarifa1();
				float tarifa2 = Configuracion.getTarifa2();

				// Agregar un nuevo registro
				Reporte nuevo = new Reporte(tarifa1,tarifa2,fechaCambio,horaCambio);
				resultados.add(nuevo);
				}	
		return resultados;
	}
}
