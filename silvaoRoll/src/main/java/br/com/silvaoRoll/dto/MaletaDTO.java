package br.com.silvaoRoll.dto;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;

import javax.swing.ImageIcon;

public class MaletaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nomeImagem;
	private String caminhoLocalizacaoImagem;
	private byte[] arquivo;
	
	public MaletaDTO() {
	}

	public MaletaDTO(Integer id, String caminhoImagem) {
		this.id = id;
		try {
			if(caminhoImagem != null) {
				File file = new File(caminhoImagem);
				this.arquivo = Files.readAllBytes(file.toPath());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.caminhoLocalizacaoImagem = caminhoImagem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	public String getCaminhoLocalizacaoImagem() {
		return caminhoLocalizacaoImagem;
	}

	public void setCaminhoLocalizacaoImagem(String caminhoLocalizacaoImagem) {
		this.caminhoLocalizacaoImagem = caminhoLocalizacaoImagem;
	}

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}
	
	
}
