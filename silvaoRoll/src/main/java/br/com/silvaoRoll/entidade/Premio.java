package br.com.silvaoRoll.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="premios")
@Entity
public class Premio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	
    @JoinColumn(name="id_maleta", referencedColumnName="id")
    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
	private Maleta maleta;
    
    public Premio() {
	}
	
	public Premio(String descricao) {
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

	public Maleta getMaleta() {
		return maleta;
	}

	public void setMaleta(Maleta maleta) {
		this.maleta = maleta;
	}
}
