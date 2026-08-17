package pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import pe.com.relari.commons.constant.Regex;

@Getter
@Setter
public class DocumentRequest {
    
    @Schema(
          description = "Representa el tipo de documento del empleado",
          name = "type",
          implementation = String.class,
          pattern = Regex.REGEXP_DOCUMENT_TYPE,
          example = "DNI",
          requiredMode = Schema.RequiredMode.REQUIRED)
  @NotNull(message = "{application.message.document.type.notNull}")
  @NotBlank(message = "{application.message.document.type.notBlank}")
  @Pattern(regexp = Regex.REGEXP_DOCUMENT_TYPE, message = "{application.message.document.type.pattern}")
  @JsonProperty("type")
  private String type;

  @Schema(
          description = "Representa el numero de documento del empleado",
          name = "number",
          implementation = String.class,
          example = "12345678",
          requiredMode = Schema.RequiredMode.REQUIRED)
  @NotNull(message = "{application.message.document.number.notNull}")
  @NotBlank(message = "{application.message.document.number.notBlank}")
  @Pattern(regexp = Regex.REGEXP_DOCUMENT_NUMBER, message = "{application.message.document.number.pattern}")
  @JsonProperty("number")
  private String number;

}
