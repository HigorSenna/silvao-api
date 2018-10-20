package br.com.silvaoRoll.servico;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ServicoImagem {
	
	@Value("${url.salvar.imagem}")
	private String urlSalvarImagem;

	public void salvar(MultipartFile arquivoMultipart) {
		if(arquivoMultipart != null) {
			salvarArquivo(arquivoMultipart);
		}
	}

	private void salvarArquivo(MultipartFile arquivoMultipart) {
		try {
			File arquivoSalvar = new File(urlSalvarImagem.concat(arquivoMultipart.getOriginalFilename()));
	    	escreverArquivo(arquivoMultipart.getBytes(), arquivoSalvar);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}


	private void escreverArquivo(byte[] bytes, File arquivoSalvar) throws FileNotFoundException, IOException {
		OutputStream os = new FileOutputStream(arquivoSalvar);
		os.write(bytes);
		os.close();
	} 

}
