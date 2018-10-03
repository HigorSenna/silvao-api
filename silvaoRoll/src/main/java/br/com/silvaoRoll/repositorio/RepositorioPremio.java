package br.com.silvaoRoll.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.silvaoRoll.dto.PremioDTO;
import br.com.silvaoRoll.entidade.Premio;

public interface RepositorioPremio extends JpaRepository<Premio, Integer>{
	
	@Query("SELECT new br.com.silvaoRoll.dto.PremioDTO(p.descricao, p.id) FROM Premio p")
	List<PremioDTO> buscar();
}
