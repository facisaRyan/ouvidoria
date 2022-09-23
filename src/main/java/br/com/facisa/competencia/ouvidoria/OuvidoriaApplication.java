package br.com.facisa.competencia.ouvidoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableCaching
@Controller
public class OuvidoriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OuvidoriaApplication.class, args);
	}
	
	 @RequestMapping("/")
	    @ResponseBody
	    String home() {
	      return "Hello World!";
	    }
}
