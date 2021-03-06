package br.com.silvaoRoll.servico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.silvaoRoll.dto.MaletaDTO;
import br.com.silvaoRoll.entidade.Maleta;
import br.com.silvaoRoll.repositorio.RepositorioMaleta;

@Service
public class ServicoMaleta {
	
	@Autowired
	private RepositorioMaleta repositorioMaleta;
	
	@Value("${url.salvar.imagem}")
	private String urlSalvarImagem;
	
	public void salvar(List<MaletaDTO> maletasCadastrar) {
		List<Maleta> maletasParaCriar = new ArrayList<>();
		for(MaletaDTO maletaDTO: maletasCadastrar) {
			Maleta maleta = montarMaleta(maletaDTO);
			maletasParaCriar.add(maleta);
		}
		repositorioMaleta.saveAll(maletasParaCriar);
	}

	private Maleta montarMaleta(MaletaDTO maletaDTO) {
		Maleta maleta = new Maleta();
		maleta.setCaminhoImagem(getCaminhoImagem(maletaDTO.getNomeImagem()));
		
		return maleta;
	}
	
	private String getCaminhoImagem(String nomeImagem) {
		if(nomeImagem != null && !nomeImagem.trim().isEmpty()) {
			return urlSalvarImagem.concat(nomeImagem);
		}
		return null;
	}
	
	public List<MaletaDTO> buscar() {
		return repositorioMaleta.buscar();
	}
	
	public List<Maleta> buscarMaletasEntidade() {
		return this.repositorioMaleta.buscarMaletasEntidade();
	}
	
	public void excluir(Integer id) {
		Maleta maleta = this.repositorioMaleta.findById(id).get();
		if(maleta.getPremio() != null) {
			maleta.getPremio().setMaleta(null);
			this.repositorioMaleta.saveAndFlush(maleta);
		}
		this.repositorioMaleta.deleteById(id);
	}
	
	public List<MaletaDTO> embaralhar(List<MaletaDTO> maletas) {
		Collections.shuffle(maletas);
		return maletas;
	}
}
