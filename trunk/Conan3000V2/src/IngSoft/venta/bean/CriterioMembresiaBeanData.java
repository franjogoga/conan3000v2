package IngSoft.venta.bean;

import java.io.Serializable;
import java.util.Date;

public class CriterioMembresiaBeanData implements Serializable{
	
	private String codigo;
	private String codigoSocio;
	private SocioBeanData socio;
	private Date limInicio;
	private Date limFin;
	private String estado;
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public SocioBeanData getSocio() {
		return socio;
	}
	
	public void setSocio(SocioBeanData socio) {
		this.socio = socio;
	}
	

	public Date getLimInicio() {
		return limInicio;
	}

	public void setLimInicio(Date limInicio) {
		this.limInicio = limInicio;
	}

	public Date getLimFin() {
		return limFin;
	}

	public void setLimFin(Date limFin) {
		this.limFin = limFin;
	}

	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}		
}

