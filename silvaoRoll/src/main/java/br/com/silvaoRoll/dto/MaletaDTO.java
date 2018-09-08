package br.com.silvaoRoll.dto;

import java.io.Serializable;

public class MaletaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	public MaletaDTO() {
	}

	public MaletaDTO(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
