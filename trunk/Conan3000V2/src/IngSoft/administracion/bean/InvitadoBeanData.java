package IngSoft.administracion.bean;

public class InvitadoBeanData {
	int codigo;
	String nombre;
	
	
	public int getCodigo( ) {
		System.out.print("Paso 1  InvitadoBeanData ");
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	

}
