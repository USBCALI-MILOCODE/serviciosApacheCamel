package co.com.rodriguezCaicedo.microservice.resolveEnigmaApi4.api;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-03-12T17:47:40.265921400-05:00[America/Bogota]")
public class NotFoundException extends ApiException {
    private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
