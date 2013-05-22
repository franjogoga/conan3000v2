package IngSoft.administracion.bean;

public class ModificacionesPerfilBeanData {
	private String codigo;
	private String cambio;
	private String antiguo;
	private String nuevo;

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
