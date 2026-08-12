package pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import pe.com.relari.commons.constant.Regex;

@Getter
@Setter
public class CompanyRequest {

    @NotNull
    @NotBlank
    @Pattern(regexp = Regex.REGEXP_JOBS_TITLES)
    @Size(min = 1, max = 50)
    @Schema(
            description = "Representa el cargo o posición del empleado en la empresa",
            name = "jobTitle",
            implementation = String.class,
            pattern = Regex.REGEXP_JOBS_TITLES,
            example = "Asistente",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String jobTitle;

    @NotNull
    @Schema(
            description = "Representa el salario o sueldo del empleado",
            name = "salary",
            implementation = Double.class,
            example = "1500",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Double salary;

}
