package co.com.rodriguezCaicedo.microservice.resolveEnigmaApi.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * GetEnigmaStepResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-03-06T18:57:51.220216900-05:00[America/Bogota]")
public class GetEnigmaStepResponse   {
	 @JsonProperty("header")
	  private Header header = null;

	  @JsonProperty("answer")
	  private String answer = null;

	  public GetEnigmaStepResponse header(Header header) {
	    this.header = header;
	    return this;
	  }

	  /**
	   * Get header
	   * @return header
	  **/
	  @ApiModelProperty(required = true, value = "")
	  @NotNull

	  @Valid
	  public Header getHeader() {
	    return header;
	  }

	  public void setHeader(Header header) {
	    this.header = header;
	  }

	  public GetEnigmaStepResponse answer(String answer) {
	    this.answer = answer;
	    return this;
	  }

	  /**
	   * Get answer
	   * @return answer
	  **/
	  @ApiModelProperty(required = true, value = "")
	  @NotNull

	  public String getAnswer() {
	    return answer;
	  }

	  public void setAnswer(String answer) {
	    this.answer = answer;
	  }

	  // Método setId
	  public void setId(String id) {
	    if (this.header == null) {
	      this.header = new Header();
	    }
	    this.header.setId(id);
	  }

	  // Método setType
	  public void setType(String type) {
	    if (this.header == null) {
	      this.header = new Header();
	    }
	    this.header.setType(type);
	  }

	  // Método setSolution
	  public void setSolution(String solution) {
	    this.answer = solution;
	  }

	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    GetEnigmaStepResponse getEnigmaStepResponse = (GetEnigmaStepResponse) o;
	    return Objects.equals(this.header, getEnigmaStepResponse.header) &&
	        Objects.equals(this.answer, getEnigmaStepResponse.answer);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(header, answer);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class GetEnigmaStepResponse {\n");
	    
	    sb.append("    header: ").append(toIndentedString(header)).append("\n");
	    sb.append("    answer: ").append(toIndentedString(answer)).append("\n");
	    sb.append("}");
	    return sb.toString();
	  }

	  /**
	   * Convert the given object to string with each line indented by 4 spaces
	   * (except the first line).
	   */
	  private String toIndentedString(java.lang.Object o) {
	    if (o == null) {
	      return "null";
	    }
	    return o.toString().replace("\n", "\n    ");
	  }
}