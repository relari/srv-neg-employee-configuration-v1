package pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import pe.com.relari.commons.constant.Regex;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest {

    @Schema(
            description = "Representa el correo electronico del empleado",
            name = "email",
            implementation = String.class,
            example = "contact@email.com",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @Email
    @NotNull
    @NotBlank
    private String email;

    @Schema(
            description = "Representa el numero telefonico del empleado",
            name = "phoneNumber",
            implementation = String.class,
            pattern = Regex.REGEXP_PHONE_NUMBER,
            example = "987654321",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull
    @NotBlank
    @Pattern(regexp = Regex.REGEXP_PHONE_NUMBER)
    private String phoneNumber;

}
