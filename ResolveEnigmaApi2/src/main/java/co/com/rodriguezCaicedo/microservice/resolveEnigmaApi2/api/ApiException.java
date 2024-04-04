package co.com.rodriguezCaicedo.microservice.resolveEnigmaApi2.api;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-03-06T19:26:48.648222-05:00[America/Bogota]")
public class ApiException extends Exception{
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
