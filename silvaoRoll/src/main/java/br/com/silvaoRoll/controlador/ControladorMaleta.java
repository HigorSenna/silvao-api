package br.com.silvaoRoll.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.silvaoRoll.entidade.Maleta;
import br.com.silvaoRoll.servico.ServicoMaleta;

@RestController
@RequestMapping("/maletas")
public class ControladorMaleta {
	
	@Autowired
	private ServicoMaleta servicoMaleta;
	
	@GetMapping
	public List<Maleta> buscar() {
		return servicoMaleta.buscar();
	}
	
	@GetMapping("/{id}")
	public Maleta buscar(@PathVariable("id") Integer id) {
		return servicoMaleta.buscar(id);
	}
}
