package IngSoft.administracion.bean;

import java.io.Serializable;

public class CriterioConcesionarioBeanData implements Serializable{
	private String razonSocial;
	private long ruc;
	
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public long getRuc() {
		return ruc;
	}
	public void setRuc(long ruc) {
		this.ruc = ruc;
	}
}
