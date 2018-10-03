package br.com.silvaoRoll.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.silvaoRoll.dto.PremioDTO;
import br.com.silvaoRoll.entidade.Premio;

public interface RepositorioPremio extends JpaRepository<Premio, Integer>{
	
	@Query("SELECT new br.com.silvaoRoll.dto.PremioDTO(p.descricao, p.id) FROM Premio p")
	List<PremioDTO> buscar();
	
	@Query("SELECT new br.com.silvaoRoll.dto.PremioDTO(p.descricao, p.id) " +
		   "FROM Premio p                                                 " + 
		   "INNER JOIN p.maleta maleta                                    " +
		   "WHERE maleta.id = :idMaleta")
	PremioDTO buscarPorMaleta(@Param("idMaleta") Integer idMaleta);
}
