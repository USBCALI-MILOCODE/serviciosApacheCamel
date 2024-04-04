package co.com.rodriguezCaicedo.microservice.resolveEnigmaApi2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "co.com.rodriguezCaicedo.microservice.resolveEnigmaApi2", "co.com.rodriguezCaicedo.microservice.resolveEnigmaApi2.api" , "co.com.rodriguezCaicedo.microservice.resolveEnigmaApi2.config"})
public class ResolveEnigmaApplication2{

    public static void main(String[] args) throws Exception {
        new SpringApplication(ResolveEnigmaApplication2.class).run(args);
    }

}
