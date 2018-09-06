package br.com.silvaoRoll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SilvaoRollApplication {

	public static void main(String[] args) {
		SpringApplication.run(SilvaoRollApplication.class, args);
	}
	
	@RequestMapping("teste")
	public String teste() {
		return "Hello World";
	}
}
