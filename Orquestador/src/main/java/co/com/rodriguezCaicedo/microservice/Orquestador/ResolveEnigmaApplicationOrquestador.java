package co.com.rodriguezCaicedo.microservice.Orquestador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "co.com.rodriguezCaicedo.microservice.Orquestador", "co.com.rodriguezCaicedo.microservice.Orquestador.api" , "co.com.rodriguezCaicedo.microservice.Orquestador.config"})
public class ResolveEnigmaApplicationOrquestador {

	  public static void main(String[] args) throws Exception {
	        new SpringApplication(ResolveEnigmaApplicationOrquestador.class).run(args);
	    }
}
