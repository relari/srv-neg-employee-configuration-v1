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

  @Schema(
          description = "Representa el nombre del empleado",
          name = "firstName",
          implementation = String.class,
          pattern = Regex.REGEXP_ONLY_LETTERS,
          example = "Daniel",
          requiredMode = Schema.RequiredMode.REQUIRED)
  @NotNull(message = "{application.message.employee.firstName.notNull}")
  @NotBlank(message = "{application.message.employee.firstName.notBlank}")
  @Size(min = 1, max = 50, message = "{application.message.employee.firstName.size}")
  @Pattern(regexp = Regex.REGEXP_ONLY_LETTERS, message = "{application.message.employee.firstName.pattern}")
  @JsonProperty("firstName")
  private String firstName;

  @Schema(
          description = "Representa el apellido paterno del empleado",
          name = "fatherLastName",
          implementation = String.class,
          pattern = Regex.REGEXP_ONLY_LETTERS,
          example = "Gonzales",
          requiredMode = Schema.RequiredMode.REQUIRED)
  @NotNull(message = "{application.message.employee.fatherLastName.notNull}")
  @NotBlank(message = "{application.message.employee.fatherLastName.notBlank}")
  @Size(min = 1, max = 50, message = "{application.message.employee.fatherLastName.size}")
  @Pattern(regexp = Regex.REGEXP_ONLY_LETTERS, message = "{application.message.employee.fatherLastName.pattern}")
  @JsonProperty("fatherLastName")
  private String fatherLastName;

  @Schema(
          description = "Representa el apellido materno del empleado",
          name = "motherLastName",
          implementation = String.class,
          pattern = Regex.REGEXP_ONLY_LETTERS,
          example = "Perez",
          requiredMode = Schema.RequiredMode.REQUIRED)
  @NotNull(message = "{application.message.employee.motherLastName.notNull}")
  @NotBlank(message = "{application.message.employee.motherLastName.notBlank}")
  @Size(min = 1, max = 50, message = "{application.message.employee.motherLastName.size}")
  @Pattern(regexp = Regex.REGEXP_ONLY_LETTERS, message = "{application.message.employee.motherLastName.pattern}")
  @JsonProperty("motherLastName")
  private String motherLastName;

  @Schema(
          description = "Representa el género o sexo del empleado.",
          name = "gender",
          implementation = String.class,
          pattern = Regex.REGEXP_GENDER,
          example = "M",
          requiredMode = Schema.RequiredMode.REQUIRED)
  @NotNull(message = "{application.message.employee.gender.notNull}")
  @NotBlank(message = "{application.message.employee.gender.notBlank}")
  @Size(min = 1, max = 1, message = "{application.message.employee.gender.size}")
  @Pattern(regexp = Regex.REGEXP_GENDER, message = "{application.message.employee.gender.pattern}")
  @JsonProperty("gender")
  private String gender;

  @Schema(
          description = "Representa la fecha de nacimiento del empleado",
          name = "birthdate",
          implementation = String.class,
          pattern = Regex.REGEXP_DATE,
          example = "03/05/1995",
          requiredMode = Schema.RequiredMode.REQUIRED)
  @NotNull(message = "{application.message.employee.birthdate.notNull}")
  @NotBlank(message = "{application.message.employee.birthdate.notBlank}")
  @Size(min = 10, max = 10, message = "{application.message.employee.birthdate.size}")
  @Pattern(regexp = Regex.REGEXP_DATE, message = "{application.message.employee.birthdate.pattern}")
  @JsonProperty("birthdate")
  private String birthdate;

  @Valid
  private DocumentRequest document;

  @Valid
  private ContactRequest contactInfo;

  @Valid
  private CompanyRequest company;

}