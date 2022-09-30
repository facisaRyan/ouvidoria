package br.com.facisa.competencia.ouvidoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@EnableCaching
@Controller
public class OuvidoriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OuvidoriaApplication.class, args);
	}
	
	 
}
