package pe.com.relari.srv_neg_employee_configuration_v1.controller;

import io.reactivex.rxjava3.core.Observable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeResponse;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.service.EmployeeService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>Class:</b> ListEmployeesController.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Tag(name = "Employee", description = "Employee Controller")
@RestController
@RequestMapping(path = "${application.api.path}")
@RequiredArgsConstructor
class ListEmployeesController {

  private final EmployeeService employeeService;

  @Operation(
          summary = "Listado de Empleados",
          method = "GET",
          responses  = {
                  @ApiResponse(
                          responseCode = "200",
                          description = "Retorna todos los Empleados",
                          content = @Content(
                                  array = @ArraySchema(
                                          schema = @Schema(implementation = EmployeeResponse.class)),
                                  mediaType = MediaType.APPLICATION_JSON_VALUE
                          )
                  )
          })
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Observable<EmployeeResponse> listOfEmployees() {
    return this.employeeService.findAll()
            .map(RequestToEmployeeMapper::mapEmployeeResponse);
  }

}
