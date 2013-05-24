package IngSoft.venta.bean;

import java.io.Serializable;

public class SocioBeanData implements Serializable{

	private String codigo;
	private String codigo2;
	//private String nombres;
	//private String apellidoPaterno;
	//private String apellidoMaterno;
	//private String fechaNacimiento;
	//private String tipoDocumento;
	//private int numeroDocumento;
	private String idMembresia;
	

	private String correoElectronico;
	private String direccion;
	private long telefonoFijo;
	private long telefonoCelular;
	private String idSolicitud;
	private String idDistrito;
	private String idPerfil;
	
	public String getCodigo2() {
		return codigo2;
	}

	public void setCodigo2(String codigo2) {
		this.codigo2 = codigo2;
	}

	public String getIdMembresia() {
		return idMembresia;
	}

	public void setIdMembresia(String idMembresia) {
		this.idMembresia = idMembresia;
	}
	
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	/*public String getNombres() {
		return nombres;
	}
	
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	public int getNumeroDocumento() {
		return numeroDocumento;
	}
	
	public void setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}*/
	
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
	public String getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(String idSolicitud) {
		this.idSolicitud = idSolicitud;
	}


	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public long getTelefonoFijo() {
		return telefonoFijo;
	}
	
	public void setTelefonoFijo(long telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}
	
	public long getTelefonoCelular() {
		return telefonoCelular;
	}
	
	public void setTelefonoCelular(long telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public String getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(String idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(String idPerfil) {
		this.idPerfil = idPerfil;
	}
	
	
}
