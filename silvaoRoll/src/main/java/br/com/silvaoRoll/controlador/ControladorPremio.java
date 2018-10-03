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

import br.com.silvaoRoll.dto.PremioDTO;
import br.com.silvaoRoll.servico.ServicoPremio;

@RestController
@RequestMapping("/premios")
public class ControladorPremio {
	
	@Autowired
	private ServicoPremio servicoPremio;

	@PostMapping
	public void salvar(@RequestBody PremioDTO premioDTO) {
		this.servicoPremio.salvar(premioDTO);
	}
	
	@GetMapping
	public List<PremioDTO> buscar() {
		return this.servicoPremio.buscar();
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable("id") Integer id) {
		this.servicoPremio.excluir(id);
	}
}
