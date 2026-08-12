package pe.com.relari.srv_neg_employee_configuration_v1.controller;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import pe.com.relari.commons.model.error.ErrorResponse;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeRequest;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.service.EmployeeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "${application.api.path}")
@RequiredArgsConstructor
public class CreateEmployeeController {

    private final EmployeeService employeeService;

    @Operation(
            summary = "Guarda al empleado",
            method = "POST",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Create Successful"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Error to Save",
                            content = @Content(
                                    schema = @Schema(implementation = ErrorResponse.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Completable save(@RequestBody @Valid EmployeeRequest employeeRequest) {
        return Single.fromCallable(() -> RequestToEmployeeMapper.mapEmployee(employeeRequest))
                .flatMapCompletable(employeeService::save);
    }

}
