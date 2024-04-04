package co.com.rodriguezCaicedo.microservice.resolveEnigmaApi4.api;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-03-12T17:47:40.265921400-05:00[America/Bogota]")
public class ApiException extends Exception{
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
