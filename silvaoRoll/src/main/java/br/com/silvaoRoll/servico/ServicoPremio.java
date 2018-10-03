package br.com.silvaoRoll.servico;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.silvaoRoll.dto.PremioDTO;
import br.com.silvaoRoll.entidade.Maleta;
import br.com.silvaoRoll.entidade.Premio;
import br.com.silvaoRoll.repositorio.RepositorioPremio;

@Service
public class ServicoPremio {
	
	@Autowired
	private RepositorioPremio repositorioPremio;
	
	@Autowired
	private ServicoMaleta servicoMaleta;
	
	public void salvar(PremioDTO premioDTO) {
		Premio premio = new Premio(premioDTO.getDescricao());
		this.repositorioPremio.save(premio);
	}
	
	public List<PremioDTO> buscar() {
		return this.repositorioPremio.buscar();
	}
	
	public void excluir(Integer id) {
		this.repositorioPremio.deleteById(id);
	}
	
	public void vincular(List<PremioDTO> premiosDTO) {
		Collections.shuffle(premiosDTO);
		List<Maleta> maletas = servicoMaleta.buscarMaletasEntidade();
		if(maletas.size() <= premiosDTO.size()) {
			for(int i= 0; i < maletas.size(); i++) {
				realizarVinculo(premiosDTO, maletas, i);
			}
		}
		else {
			for(int i= 0; i < premiosDTO.size(); i++) {
				realizarVinculo(premiosDTO, maletas, i);
			}
		}
	}

	private void realizarVinculo(List<PremioDTO> premiosDTO, List<Maleta> maletas, int i) {
		Integer idPremio = premiosDTO.get(i).getId();
		Premio premio = this.repositorioPremio.findById(idPremio).get();
		if(premio.getMaleta() == null) {
			premio.setMaleta(maletas.get(i));
			this.repositorioPremio.save(premio);
		} 
		else {
			premio.setMaleta(null);
			this.repositorioPremio.save(premio);
		}
	}
	
	public PremioDTO buscarPorMaleta(Integer idMaleta) {
		PremioDTO premioDTO = this.repositorioPremio.buscarPorMaleta(idMaleta);
		if(premioDTO == null) {
			return new PremioDTO();
		}
		return premioDTO;
	}
}
