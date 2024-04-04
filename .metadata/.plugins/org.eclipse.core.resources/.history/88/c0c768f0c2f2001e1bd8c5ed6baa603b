package co.com.rodriguezCaicedo.microservice.resolveEnigmaApi4.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi.model.ErrorDetail;
import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi.model.JsonApiBodyResponseErrors;
import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi4.model.GetEnigmaRequest;
import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi4.model.GetEnigmaStepResponse;
import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi4.model.Header;
import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi4.model.JsonApiBodyRequest;
import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi4.model.JsonApiBodyResponseSuccess;
import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi4.servicio.RestTemplateService;
import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-03-12T17:47:40.265921400-05:00[America/Bogota]")
@Controller
public class GetStepApiController implements GetStepApi {
    private final Logger logger = LoggerFactory.getLogger(GetStepApiController.class);

    @Autowired
    private RestTemplateService restTemplateService;
    
    @Override
    public ResponseEntity<?> getStep(@Valid @RequestBody JsonApiBodyRequest body) {
        List<String> responses = new ArrayList<>();

        try {
            // Llamadas a los servicios
            ResponseEntity<String> response1 = restTemplateService.callService("http://localhost:8081/v1/getOneEnigma/getStep");
            ResponseEntity<String> response2 = restTemplateService.callService("http://localhost:8082/v1/getOneEnigma/getStep");
            ResponseEntity<String> response3 = restTemplateService.callService("http://localhost:8083/v1/getOneEnigma/getStep" );

            // Verificar si la llamada fue exitosa
            if (response1.getStatusCode().is2xxSuccessful() && response2.getStatusCode().is2xxSuccessful() && response3.getStatusCode().is2xxSuccessful()) {
            	logger.error("Al menos una llamada a los servicios externos falló.");
            	responses.add(response1.getBody() + " - " + response2.getBody() + " - " +  response3.getBody());
                return new ResponseEntity<>(responses, HttpStatus.OK);
            } else {
                // Al menos una llamada falló
                logger.error("Al menos una llamada a los servicios externos falló.");
                return new ResponseEntity<>("Al menos una llamada a los servicios externos falló.", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error("Error al llamar a los servicios externos: {}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}