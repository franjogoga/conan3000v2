package IngSoft.administracion.bean;
import java.io.Serializable;
import java.util.Date;

public class PersonaBeanData implements Serializable{
	
	
	private String codigo;
	private String nombre;
	private String apaterno;
	private String amaterno;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApaterno() {
		return apaterno;
	}
	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}
	public String getAmaterno() {
		return amaterno;
	}
	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}



	

}
