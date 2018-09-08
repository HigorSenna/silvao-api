package br.com.silvaoRoll.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.silvaoRoll.servico.ServicoImagem;

@RestController
@RequestMapping("/imagens")
public class ControladorImagem {
	
	@Autowired
	private ServicoImagem servicoImagem;
	
	@PostMapping
    public void save(@RequestParam(value = "image", required = false) MultipartFile file) {
		servicoImagem.salvar(file);
    }
}
