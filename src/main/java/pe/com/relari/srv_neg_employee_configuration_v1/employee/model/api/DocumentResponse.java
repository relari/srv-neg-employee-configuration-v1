
package pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Document;

@Getter
@AllArgsConstructor
public class DocumentResponse {

    @Schema(
            description = "Representa el tipo de documento del empleado",
            name = "type",
            implementation = String.class,
            example = "DNI")
    @JsonProperty("type")
    private String type;

    @Schema(
            description = "Representa el numero de documento del empleado",
            name = "number",
            implementation = String.class,
            example = "12345678")
    @JsonProperty("number")
    private String number;

    public DocumentResponse(Document document) {
        this.type = document.getType().name();
        this.number = document.getNumber();
    }

}
