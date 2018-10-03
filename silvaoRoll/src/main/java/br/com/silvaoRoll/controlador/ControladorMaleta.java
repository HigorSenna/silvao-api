package br.com.silvaoRoll.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.silvaoRoll.dto.MaletaDTO;
import br.com.silvaoRoll.servico.ServicoMaleta;

@RestController
@RequestMapping("/maletas")
public class ControladorMaleta {
	
	@Autowired
	private ServicoMaleta servicoMaleta;
	
	@PostMapping
	public void salvar(@RequestBody List<MaletaDTO> maletasCadastrar) {
		servicoMaleta.salvar(maletasCadastrar);
	}
	
	@GetMapping
	public List<MaletaDTO> buscar() {
		return servicoMaleta.buscar();
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable("id") Integer id) {
		servicoMaleta.excluir(id);
	}
}
