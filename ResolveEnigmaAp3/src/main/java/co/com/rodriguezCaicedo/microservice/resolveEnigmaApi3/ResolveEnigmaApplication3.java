package co.com.rodriguezCaicedo.microservice.resolveEnigmaApi3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "co.com.rodriguezCaicedo.microservice.resolveEnigmaApi3", "co.com.rodriguezCaicedo.microservice.resolveEnigmaApi3.api" , "co.com.rodriguezCaicedo.microservice.resolveEnigmaApi3.config"})
public class ResolveEnigmaApplication3 {

    public static void main(String[] args) throws Exception {
        new SpringApplication(ResolveEnigmaApplication3.class).run(args);
    }

}
