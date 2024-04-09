package co.com.rodriguezCaicedo.microservice.resolveEnigmaApi4.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import co.com.rodriguezCaicedo.microservice.resolveEnigmaApi4.model.client.ClientJsonApiBodyResponseSuccess;

public class GetStepOneClientRoute extends RouteBuilder{

	@Override
    public void configure() throws Exception {
        from("direct:get-step-one")
		.routeId("getStepOne")
    	.setHeader(Exchange.HTTP_METHOD, constant("POST"))
    	.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
        .to("freemarker:templates/GetStepOneClientTemplate.ftl")
        .hystrix()
        .hystrixConfiguration().executionTimeoutInMilliseconds(5000).end()
        .to("http4://localhost:8081/EnigmaSteps/getStep")
    	.convertBodyTo(String.class)
    	.unmarshal().json(JsonLibrary.Jackson, ClientJsonApiBodyResponseSuccess[].class)
        .process(new Processor() {
    		@Override
    		public void process(Exchange exchange) throws Exception {
    			ClientJsonApiBodyResponseSuccess stepOneResponse = ( ClientJsonApiBodyResponseSuccess ) exchange.getIn().getBody(ClientJsonApiBodyResponseSuccess.class);

    			boolean isStepOne = stepOneResponse.getData().get(0).getStep().equalsIgnoreCase("1");
    			
    			if (isStepOne) {
    				exchange.setProperty("Step1", "Step 1: ".concat(stepOneResponse.getData().get(0).getStepDescription()));
    			} else {
    				exchange.setProperty("Error", "0001");
    				exchange.setProperty("descError", "Step one is not valid");
    			}
    		}
        })
        .endHystrix()
        .onFallback()
        .process(new Processor() {
        	@Override
        	public void process(Exchange exchange) throws Exception {
        		exchange.setProperty("Error", "0002");
        		exchange.setProperty("descError", "Error consulting the step one");
        	}
        })
        .end()
        .log("Response error code: ${exchangeProperty[Error]}")
        .log("Response error description: ${exchangeProperty[descError]}")
        .log("Response step description: ${exchangeProperty[Step1]}");
    }

}
