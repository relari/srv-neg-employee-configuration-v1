package pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Contact;

@Getter
@AllArgsConstructor
public class ContactResponse {

    @Schema(
            description = "Representa el correo electronico del empleado",
            name = "email",
            implementation = String.class,
            example = "contact@email.com")
    @JsonProperty("email")
    private String email;

    @Schema(
            description = "Representa el numero telefonico del empleado",
            name = "phoneNumber",
            implementation = String.class,
            example = "987654321")
    @JsonProperty("phoneNumber")
    private String phoneNumber;

    public ContactResponse(Contact contact) {
        this.email = contact.getEmail();
        this.phoneNumber = contact.getPhoneNumber();
    }

}
