package microservicioCuenta.modelo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cuenta {

	// id viaje
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// fechas de creacion
	@Column
	private Date fechaInicio;

	// castear para usar como cadena de caracteres
	@Column
	private String montos;

	// VER
	@Column
	private String mercadopago;

	// estado, true = normal, false = baneado
	@Column
	private boolean estado;

	// constructores
	public Cuenta() {
	}

	public Cuenta(String montos, String mercadopago, boolean estado,Date fechaInicio) {
		this.montos = montos;
		this.mercadopago = mercadopago;
		this.estado = estado;
		this.fechaInicio = fechaInicio;
	}

	public int getId() {
		return id;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date f){
		this.fechaInicio = f;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean e){
		this.estado = e;
	}

	public String getMercadopago() {
		return mercadopago;
	}

	public void setMercadopago(String m){
		this.mercadopago = m;
	}

	public String getMontos() {
		return montos;
	}

	public void setMontos(String m){
		this.montos = m;
	}

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", montos=" + montos + ", mercadopago=" + mercadopago 
		+ ", estado=" + estado + ", fechaInicio=" + fechaInicio + "]";
	}
}
