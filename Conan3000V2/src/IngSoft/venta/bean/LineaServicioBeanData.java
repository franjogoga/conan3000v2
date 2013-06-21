package IngSoft.venta.bean;

import java.io.Serializable;

public class LineaServicioBeanData implements Serializable {
	
	private String codLineaServicio;
	private String codServicioP;
	private String codSolicitudS;
	private double monto;
	
	public String getCodLineaServicio() {
		return codLineaServicio;
	}
	
	public void setCodLineaServicio(String codLineaServicio) {
		this.codLineaServicio = codLineaServicio;
	}
	
	public String getCodServicioP() {
		return codServicioP;
	}
	
	public void setCodServicioP(String codServicioP) {
		this.codServicioP = codServicioP;
	}
	
	public String getCodSolicitudS() {
		return codSolicitudS;
	}
	
	public void setCodSolicitudS(String codSolicitudS) {
		this.codSolicitudS = codSolicitudS;
	}
	
	public double getMonto() {
		return monto;
	}
	
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	

}
