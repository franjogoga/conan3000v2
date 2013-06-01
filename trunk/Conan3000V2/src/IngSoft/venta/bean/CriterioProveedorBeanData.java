package IngSoft.venta.bean;

public class CriterioProveedorBeanData {
	
	private String codigo;
	private String razonSocial;
	private long ruc;
	private String direccion;
	private String correo;
	private String contacto;
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

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

	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getContacto() {
		return contacto;
	}
	
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	

}
