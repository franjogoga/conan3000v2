package IngSoft.servicio.bean;

import java.io.Serializable;
import java.util.Vector;

public class BungalowBeanData implements Serializable{
	private String idSorteo;
	Vector<String> bungalows;
	public String getIdSorteo() {
		return idSorteo;
	}
	public void setIdSorteo(String idSorteo) {
		this.idSorteo = idSorteo;
	}
	public Vector<String> getBungalows() {
		return bungalows;
	}
	public void setBungalows(Vector<String> bungalows) {
		this.bungalows = bungalows;
	}

	
}
