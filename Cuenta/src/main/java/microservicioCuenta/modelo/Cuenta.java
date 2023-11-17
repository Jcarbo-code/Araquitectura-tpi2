package microservicioCuenta.modelo;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cuenta {

	// id cuenta
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCuenta;

	// fechas de creacion
	@Column
	private Date fechaInicio;

	// castear para usar como cadena de caracteres
	@Column
	private float monto;

	// VER
	@Column
	private String mercadopago;

	// estado, true = normal, false = baneado
	@Column
	private boolean estado;

	// constructores
	public Cuenta() {
	}

	public Cuenta(float monto, String mercadopago, boolean estado, Date fechaInicio) {
		this.monto = monto;
		this.mercadopago = mercadopago;
		this.estado = estado;
		this.fechaInicio = fechaInicio;
	}

	public int getId() {
		return idCuenta;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date f) {
		this.fechaInicio = f;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean e) {
		this.estado = e;
	}

	public String getMercadopago() {
		return mercadopago;
	}

	public void setMercadopago(String m) {
		this.mercadopago = m;
	}

	public float getMontos() {
		return monto;
	}

	public void setMontos(float m) {
		this.monto = m;
	}

	@Override
	public String toString() {
		return "Cuenta [idCuenta=" + idCuenta + ", montos=" + monto + ", mercadopago=" + mercadopago + ", estado="
				+ estado + ", fechaInicio=" + fechaInicio + "]";
	}
}
