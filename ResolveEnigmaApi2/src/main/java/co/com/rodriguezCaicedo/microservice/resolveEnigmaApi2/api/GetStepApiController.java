package co.com.rodriguezCaicedo.microservice.resolveEnigmaApi2.api;

import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi2.model.JsonApiBodyRequest;
import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi2.model.JsonApiBodyResponseErrors;
import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi2.model.JsonApiBodyResponseSuccess;
import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi2.model.GetEnigmaRequest;
import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi2.model.GetEnigmaStepResponse;
import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi2.model.Header;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-03-06T19:26:48.648222-05:00[America/Bogota]")
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
        if (enigmaQuestion.equals("2")) {
            return "Servicio 2 :  Poner la jirafa adentro ";
        } else {
            return "Paso no válido";
        }
    }
    
    @GetMapping("/getStep")
    public ResponseEntity<String> getStep() {
        // Devolver el string deseado
        String response = "Poner la jirafa adentro";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
