package IngSoft.venta.bean;
import java.io.Serializable;
import java.sql.Date;

public class TrasladoBeanData implements Serializable{
	
	private String idtraslado;
	private String idmembresiaNuevo;
	private String idmembresiaAntiguo;
	private Date fecha;
	private String parentesco;
	private double monto;

	public String getIdtraslado() {
		return idtraslado;
	}
	public void setIdtraslado(String idtraslado) {
		this.idtraslado = idtraslado;
	}
	
	public String getIdMembresiaNuevo() {
		return idmembresiaNuevo;
	}
	public void setIdMembresiaNuevo(String idMembresiaNuevo) {
		this.idmembresiaNuevo = idMembresiaNuevo;
	}
	public String getIdMembresiaAntiguo() {
		return idmembresiaAntiguo;
	}
	public void setIdMembresiaAntiguo(String idMembresiaAntiguo) {
		this.idmembresiaAntiguo = idMembresiaAntiguo;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getParentesco() {
		return parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
		
}