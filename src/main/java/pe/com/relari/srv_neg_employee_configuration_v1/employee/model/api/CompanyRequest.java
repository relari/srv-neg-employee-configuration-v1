package pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @Schema(
            description = "Representa el cargo o posición del empleado en la empresa",
            name = "jobTitle",
            implementation = String.class,
            pattern = Regex.REGEXP_JOBS_TITLES,
            example = "Asistente",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "{application.message.company.jobTitle.notNull}")
    @NotBlank(message = "{application.message.company.jobTitle.notBlank}")
    @Size(min = 1, max = 100, message = "{application.message.company.jobTitle.size}")
    @Pattern(regexp = Regex.REGEXP_JOBS_TITLES, message = "{application.message.company.jobTitle.pattern}")
    @JsonProperty("jobTitle")
    private String jobTitle;

    @Schema(
            description = "Representa el salario o sueldo del empleado",
            name = "salary",
            implementation = Double.class,
            example = "1500",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "{application.message.company.salary.notNull}")
    @JsonProperty("salary")
    private Double salary;

}
