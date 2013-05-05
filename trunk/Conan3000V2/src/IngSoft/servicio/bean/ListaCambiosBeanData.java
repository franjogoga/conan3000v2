package IngSoft.servicio.bean;

public class ListaCambiosBeanData {
	private int tipo;
	private int codigo;
	private String actual;
	private String antiguo;
	
	private ListaCambiosBeanData(){} 
	public ListaCambiosBeanData(int tipo, int codigo, String actual,
			String antiguo) {
		super();
		this.tipo = tipo;
		this.codigo = codigo;
		this.actual = actual;
		this.antiguo = antiguo;
	}
	
	public int getTipo() {
		return tipo;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getActual() {
		return actual;
	}
	public String getAntiguo() {
		return antiguo;
	}
	
	
}
