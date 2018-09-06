package br.com.silvaoRoll.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.silvaoRoll.entidade.Maleta;
import br.com.silvaoRoll.entidade.Premio;
import br.com.silvaoRoll.repositorio.RepositorioMaleta;

@Service
public class ServicoMaleta {
	
//	@Autowired
//	private RepositorioMaleta repositorioMaleta;
	
	public List<Maleta> buscar() {
		List<Maleta> maletas = new ArrayList<>();
		
		for(int i = 0; i < 5; i++) {
			Maleta maleta = new Maleta();
			maleta.setId(i);
			maletas.add(maleta);
		}
		
		return maletas;
	}
	
	public Maleta buscar(Integer id) {
		Maleta maleta = new Maleta();
		
		for(int i = 0; i < 5; i++) {
			Premio premio = new Premio();
			premio.setId(i);
			premio.setDescricao("item " + i);
			maleta.getPremios().add(premio);
		}
		
		return maleta;
	}
}
