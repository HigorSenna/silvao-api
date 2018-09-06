package br.com.silvaoRoll.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Maleta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	//muitos premios para uma maleta
	private List<Premio> premios;
	
	public Maleta() {
		if(this.premios == null) {
			this.premios = new ArrayList<>();
		}
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Premio> getPremios() {
		return premios;
	}
	public void setPremios(List<Premio> premios) {
		this.premios = premios;
	}
}
