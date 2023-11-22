package microservicioUsuario.dtos;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;

public class PreciosDto {
	//fecha
	@Column
	private Date fechaCambio;

	//hora
	private Time horaCambio;

	// tarifa precio original
	private float tarifa1;
	// tarifa precio pausa
	private float tarifa2;

	public PreciosDto(Date fechaCambio, Time horaCambio, float tarifa1, float tarifa2) {
		super();
		this.fechaCambio = fechaCambio;
		this.horaCambio = horaCambio;
		this.tarifa1 = tarifa1;
		this.tarifa2 = tarifa2;
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
