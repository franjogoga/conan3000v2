package IngSoft.administracion.bean;

import java.io.Serializable;

public class ConSedeBeanData implements Serializable{
	
	private String codigoCon;
	private String codigoSede;
	
	public String getCodigo() {
		return codigoCon;
	}
	public void setCodigoCon(String codigoCon) {
		this.codigoCon = codigoCon;
	}
	public String getNombre() {
		return codigoSede;
	}
	public void setCodigoSede(String codigoSede) {
		this.codigoSede = codigoSede;
	}
}
