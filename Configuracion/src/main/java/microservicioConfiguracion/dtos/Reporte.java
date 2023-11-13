package microservicioConfiguracion.dtos;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;

public class Reporte {
	private int id;
	private Date fechaCambio;
	private Time horaCambio;
	private float tarifa1;
	private float tarifa2;

	public Reporte(float tarifa1,float tarifa2, Date diaCambio,Time horaCambio) {
		this.tarifa1 = tarifa1;
		this.tarifa2 = tarifa2;
		this.fechaCambio = diaCambio;
		this.horaCambio = horaCambio;
	}

	public int getId() {
		return id;
	}

	public Date getFechaCambio() {
		return fechaCambio;
	}

	public void setFechaCambio(Date fechaCambio) {
		this.fechaCambio = fechaCambio;
	}

	public Time getHoraCambio() {
		return horaCambio;
	}

	public void setHoraCambio(Time horaCambio) {
		this.horaCambio = horaCambio;
	}

	public float getTarifa1() {
		return tarifa1;
	}

	public void setTarifa1(float tarifa1) {
		this.tarifa1 = tarifa1;
	}

	public float getTarifa2() {
		return tarifa2;
	}

	public void setTarifa2(float tarifa2) {
		this.tarifa2 = tarifa2;
	}
}
