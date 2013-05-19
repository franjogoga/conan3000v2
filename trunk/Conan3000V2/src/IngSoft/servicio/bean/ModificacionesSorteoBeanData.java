package IngSoft.servicio.bean;

public class ModificacionesSorteoBeanData {
	private String idSorteo;
	private String cambio;
	private String antiguo;
	private String nuevo;	
	
	public String getIdSorteo() {
		return idSorteo;
	}
	public void setIdSorteo(String idSorteo) {
		this.idSorteo = idSorteo;
	}
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