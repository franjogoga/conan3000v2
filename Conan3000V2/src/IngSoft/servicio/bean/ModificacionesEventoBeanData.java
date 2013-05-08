package IngSoft.servicio.bean;

public class ModificacionesEventoBeanData {
	private String cambio;
	private String antiguo;
	private String nuevo;	
	public String getCambio() {
		return cambio;
	}
	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
	public String getAntiguo() {
		return antiguo;
	}
	public void setAntiguo(String antiguo) {
		this.antiguo = antiguo;
	}
	public String getNuevo() {
		return nuevo;
	}
	public void setNuevo(String nuevo) {
		this.nuevo = nuevo;
	}
}
