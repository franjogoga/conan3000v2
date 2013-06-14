package IngSoft.administracion.bean;

import java.io.Serializable;
import java.util.Date;

public class InvitadoBeanData implements Serializable {
	String codigo;
	String nombres;
	String aparterno;
	String amaterno;
	String tipodocumento;
	String numerodoc;
	Date fechanacimiento;
	Date fecharegistro;
	String correo;
	String telefonofijo;
	String telefonomovil;
	String estado;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getAparterno() {
		return aparterno;
	}
	public void setAparterno(String aparterno) {
		this.aparterno = aparterno;
	}
	public String getAmaterno() {
		return amaterno;
	}
	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}
	public String getTipodocumento() {
		return tipodocumento;
	}
	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}
	public String getNumerodoc() {
		return numerodoc;
	}
	public void setNumerodoc(String numerodoc) {
		this.numerodoc = numerodoc;
	}
	public Date getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	public Date getFecharegistro() {
		return fecharegistro;
	}
	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefonofijo() {
		return telefonofijo;
	}
	public void setTelefonofijo(String telefonofijo) {
		this.telefonofijo = telefonofijo;
	}
	public String getTelefonomovil() {
		return telefonomovil;
	}
	public void setTelefonomovil(String telefonomovil) {
		this.telefonomovil = telefonomovil;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}



	
	
	
	
	
	
	

	

}
