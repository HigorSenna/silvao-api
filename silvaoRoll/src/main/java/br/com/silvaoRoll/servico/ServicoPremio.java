package br.com.silvaoRoll.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.silvaoRoll.dto.PremioDTO;
import br.com.silvaoRoll.entidade.Premio;
import br.com.silvaoRoll.repositorio.RepositorioPremio;

@Service
public class ServicoPremio {
	
	@Autowired
	private RepositorioPremio repositorioPremio;
	
	public void salvar(PremioDTO premioDTO) {
		Premio premio = new Premio(premioDTO.getDescricao());
		this.repositorioPremio.save(premio);
	}
	
	public List<PremioDTO> buscar() {
		return this.repositorioPremio.buscar();
	}
	
	public void excluir(Integer id) {
		//TODO: Verificar se quando deleto premio vinculado a maleta, ela tbm está sendo deletada
		this.repositorioPremio.deleteById(id);
	}
}
