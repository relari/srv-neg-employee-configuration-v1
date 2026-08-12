package pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pe.com.relari.commons.constant.Regex;

/**
 * <b>Class:</b> EmployeeRequest.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {

  @NotBlank
  @Pattern(regexp = Regex.REGEXP_ONLY_LETTERS)
  @Size(min = 1, max = 50)
  @Schema(
          description = "Representa el nombre del empleado",
          name = "firstName",
          implementation = String.class,
          pattern = Regex.REGEXP_ONLY_LETTERS,
          example = "Daniel",
          requiredMode = Schema.RequiredMode.REQUIRED)
  private String firstName;

  @NotBlank
  @Pattern(regexp = Regex.REGEXP_ONLY_LETTERS)
  @Size(min = 1, max = 50)
  @Schema(
          description = "Representa el apellido paterno del empleado",
          name = "fatherLastName",
          implementation = String.class,
          pattern = Regex.REGEXP_ONLY_LETTERS,
          example = "Gonzales",
          requiredMode = Schema.RequiredMode.REQUIRED)
  private String fatherLastName;

  @NotBlank
  @Pattern(regexp = Regex.REGEXP_ONLY_LETTERS)
  @Size(min = 1, max = 50)
  @Schema(
          description = "Representa el apellido materno del empleado",
          name = "motherLastName",
          implementation = String.class,
          pattern = Regex.REGEXP_ONLY_LETTERS,
          example = "Perez",
          requiredMode = Schema.RequiredMode.REQUIRED)
  private String motherLastName;

  @NotBlank
  @Pattern(regexp = Regex.REGEXP_GENDER)
  @Schema(
          description = "Representa el género o sexo del empleado.",
          name = "gender",
          implementation = String.class,
          pattern = Regex.REGEXP_GENDER,
          example = "M",
          requiredMode = Schema.RequiredMode.REQUIRED)
  private String gender;

  @Schema(
          description = "Representa la fecha de nacimiento del empleado",
          name = "birthdate",
          implementation = String.class,
          pattern = Regex.REGEXP_DATE,
          example = "03/05/1995",
          requiredMode = Schema.RequiredMode.REQUIRED)
  @NotNull
  @NotBlank
  @Size(min = 10, max = 10)
  @Pattern(regexp = Regex.REGEXP_DATE)
  @JsonProperty("birthdate")
  private String birthdate;

  @Valid
  private DocumentRequest document;

  @Valid
  private ContactRequest contactInfo;

  @Valid
  private CompanyRequest company;

}