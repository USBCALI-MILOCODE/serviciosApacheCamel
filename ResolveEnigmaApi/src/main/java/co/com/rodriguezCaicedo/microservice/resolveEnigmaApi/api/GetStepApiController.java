package co.com.rodriguezCaicedo.microservice.resolveEnigmaApi.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi.model.GetEnigmaRequest;
import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi.model.GetEnigmaStepResponse;
import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi.model.Header;
import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi.model.JsonApiBodyRequest;
import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi.model.JsonApiBodyResponseSuccess;
import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-03-06T19:46:31.895722200-05:00[America/Bogota]")
@Controller
public class GetStepApiController implements GetStepApi {


	private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    public GetStepApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<JsonApiBodyResponseSuccess>> getStep(@ApiParam(value = "request body get enigma step", required = true) @Valid @RequestBody JsonApiBodyRequest body) {
        List<GetEnigmaRequest> enigmas = body.getData();
        List<JsonApiBodyResponseSuccess> responseList = new ArrayList<>();

        for (GetEnigmaRequest enigma : enigmas) {
            // Obtener los datos del enigma
            Header header = enigma.getHeader();
            String id = header.getId();
            String type = header.getType();
            String enigmaQuestion = enigma.getStep();

            // Obtener el paso del enigma
            String step = enigma.getStep();

            // Resolver el enigma
            String solution = solveEnigma(enigmaQuestion);

            // Construir la respuesta
            GetEnigmaStepResponse enigmaStepResponse = new GetEnigmaStepResponse();
            enigmaStepResponse.setId(id);
            enigmaStepResponse.setType(type);
            enigmaStepResponse.setSolution(solution);

            // Construir la respuesta JSON
            JsonApiBodyResponseSuccess responseBody = new JsonApiBodyResponseSuccess();
            responseBody.addDataItem(enigmaStepResponse);
            responseList.add(responseBody);
        }

        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    // Método para resolver el enigma
    private String solveEnigma(String enigmaQuestion) {
        if (enigmaQuestion.equals("1")) {
            return "Servicio 1: Abrir el refrigerador";
        } else {
            return "Paso no válido";
        }
    }
    
   
    @GetMapping("/getStep")
    public ResponseEntity<String> getStep() {
        // Devolver el string deseado
        String response = "Abrir el refrigerador";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
}
