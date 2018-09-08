package br.com.silvaoRoll.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.silvaoRoll.dto.MaletaDTO;
import br.com.silvaoRoll.entidade.Maleta;
import br.com.silvaoRoll.repositorio.RepositorioMaleta;

@Service
public class ServicoMaleta {
	
	@Autowired
	private RepositorioMaleta repositorioMaleta;
	
	public void salvar(List<MaletaDTO> maletasCadastrar) {
		List<Maleta> maletasParaCriar = new ArrayList<>();
		for(MaletaDTO maletaDTO: maletasCadastrar) {
			maletasParaCriar.add(new Maleta());
		}
		repositorioMaleta.saveAll(maletasParaCriar);
	}
	
	public List<MaletaDTO> buscar() {
		return repositorioMaleta.buscar();
	}
}
