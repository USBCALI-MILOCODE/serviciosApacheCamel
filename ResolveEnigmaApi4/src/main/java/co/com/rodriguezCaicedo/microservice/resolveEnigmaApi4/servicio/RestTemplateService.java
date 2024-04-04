package co.com.rodriguezCaicedo.microservice.resolveEnigmaApi4.servicio;

import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi4.model.JsonApiBodyRequest;
import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi4.model.GetEnigmaStepResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateService {

    private final RestTemplate restTemplate;

    public RestTemplateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> callService(String serviceUrl) {
        return restTemplate.getForEntity(serviceUrl, String.class);
    }
}