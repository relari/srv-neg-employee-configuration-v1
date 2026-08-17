package pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Company;

@Getter
@AllArgsConstructor
public class CompanyResponse {

    @Schema(
            description = "Representa el cargo o posición del empleado en la empresa",
            name = "jobTitle",
            implementation = String.class,
            example = "Asistente")
    @JsonProperty("jobTitle")
    private String jobTitle;

    @Schema(
            description = "Representa el salario o sueldo del empleado",
            name = "salary",
            implementation = Double.class,
            example = "1500")
    @JsonProperty("salary")
    private Double salary;

    public CompanyResponse(Company company) {
        this.jobTitle = company.getJobTitle().name();
        this.salary = company.getSalary();
    }

}
