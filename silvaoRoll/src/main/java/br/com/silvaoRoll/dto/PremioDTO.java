package br.com.silvaoRoll.dto;

import java.io.Serializable;

public class PremioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String descricao;
	private MaletaDTO maletaDTO;
	
	public PremioDTO() {
	}
	
	public PremioDTO(String descricao, Integer id) {
		this.descricao = descricao;
		this.id = id;
	}
	
	public PremioDTO(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public MaletaDTO getMaletaDTO() {
		return maletaDTO;
	}
	public void setMaletaDTO(MaletaDTO maletaDTO) {
		this.maletaDTO = maletaDTO;
	}
}
