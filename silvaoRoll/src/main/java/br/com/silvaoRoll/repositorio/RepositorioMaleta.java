package br.com.silvaoRoll.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.silvaoRoll.dto.MaletaDTO;
import br.com.silvaoRoll.entidade.Maleta;

public interface RepositorioMaleta extends JpaRepository<Maleta, Integer> {
	
	
	@Query("SELECT new br.com.silvaoRoll.dto.MaletaDTO(maleta.id, maleta.caminhoImagem) FROM Maleta maleta")
	List<MaletaDTO> buscar();
	
	@Query("SELECT maleta FROM Maleta maleta")
	List<Maleta> buscarMaletasEntidade();
}
