package co.com.rodriguezCaicedo.microservice.resolveEnigmaApi2.api;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-03-06T19:26:48.648222-05:00[America/Bogota]")
public class NotFoundException extends ApiException {
    private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
