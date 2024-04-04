package co.com.rodriguezCaicedo.microservice.resolveEnigmaApi4.routes;

import org.apache.camel.builder.RouteBuilder;

public class GetStepOneClientRoute extends RouteBuilder{

	@Override
    public void configure() throws Exception {
        from("direct:getStepRoute")
            .log("Request body ${body}")
            .setHeader("Content-Type", constant("application/json"))
            .setHeader("ServiceId", simple("${body.data[0].header.id}"))
            .setHeader("ServiceType", simple("${body.data[0].header.type}"))
            .setHeader("ServiceEnigma", simple("${body.data[0].enigma}"))
            .to("http://localhost:8080/v1/getOneEnigma/getStep")
            .to("http://localhost:8082/v1/getOneEnigma/getStep")
            .to("http://localhost:8083/v1/getOneEnigma/getStep")
            .log("Response body ${body}")
            .choice()
                .when(simple("${header.CamelHttpResponseCode} >= 200 && ${header.CamelHttpResponseCode} < 300"))
                    .log("All calls were successful")
                    .setBody(simple("${body}"))
                    .setHeader("Content-Type", constant("application/json"))
                    .setHeader("HttpStatus", constant("200"))
                .otherwise()
                    .log("At least one call failed")
                    .setBody(simple("At least one call to the external services failed"))
                    .setHeader("Content-Type", constant("text/plain"))
                    .setHeader("HttpStatus", constant("500"))
            .end();
    }

}
