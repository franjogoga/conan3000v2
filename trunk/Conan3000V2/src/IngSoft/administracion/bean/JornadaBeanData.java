package IngSoft.administracion.bean;

import java.io.Serializable;
import java.util.Date;

public class JornadaBeanData implements Serializable {
	private String idJornada;
	private String idEmpleado;
	private String horaInicio;
	private String horaFin;
	
	
	   //----- atributos nuevos ----
		private String nombreEmpleado;
		private String apaterno;
		private String amaterno; 
	    private Date fecha;
	    private String horaMarca;	
	    private int flag;
		//----- fin atributos nuevos ----
	
	
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public void setIdJornada(String idJornada) {
		this.idJornada = idJornada;
	}
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	
	//----------  metodos nuevos --------------
		public String getNombreEmpleado() {
			return nombreEmpleado;
		}
		public void setNombreEmpleado(String nombEmpleado) {
			this.nombreEmpleado = nombEmpleado;
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
		public Date getFecha() {
			return fecha;
		}
		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}
		public String getHoraMarca() {
			return horaMarca;
		}
		public void setHoraMarca(String horaMarca) {
			this.horaMarca = horaMarca;
		}
		public int getFlag() {
			return flag;
		}
		public void setFlag(int flag) {
			this.flag = flag;
		}
	//---------- fin metodos nuevos --------------
	
}
