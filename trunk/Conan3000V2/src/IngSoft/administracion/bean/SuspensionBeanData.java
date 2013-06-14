package IngSoft.administracion.bean;

import java.io.Serializable;

public class SuspensionBeanData implements Serializable{
	private String idSuspensionPago;
	private String fechaRegistro;
	private String idMembresia;
	
	public String getIdSuspensionPago() {
		return idSuspensionPago;
	}
	public void setIdSuspensionPago(String idSuspensionPago) {
		this.idSuspensionPago = idSuspensionPago;
	}
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getIdMembresia() {
		return idMembresia;
	}
	public void setIdMembresia(String idMembresia) {
		this.idMembresia = idMembresia;
	}			
}
