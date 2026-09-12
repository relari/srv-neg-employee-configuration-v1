package pe.com.relari.srv_neg_employee_configuration_v1.controller;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.TestObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pe.com.relari.commons.util.JsonUtil;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeRequest;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeResponse;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.service.EmployeeService;

import java.io.IOException;

import static org.mockito.Mockito.when;

class ListEmployeesControllerTest {

  @Mock
  private EmployeeService employeeService;

  @InjectMocks
  private ListEmployeesController listEmployeesController;

  @BeforeEach
  void init() throws Exception {
    MockitoAnnotations.openMocks(this).close();
  }

  @Test
  void whenFindAllThenReturnListEmployees() throws IOException {

    var employeeRequest = JsonUtil.readJsonFromResource(
            "data/Employee.json", EmployeeRequest.class);

    var employee = RequestToEmployeeMapper.mapEmployee(employeeRequest);

    when(employeeService.findAll())
        .thenReturn(Observable.just(employee));

    TestObserver<EmployeeResponse> testObserver = listEmployeesController.listOfEmployees().test();

//    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors()
        .assertValue(employeeResponse ->
                employeeResponse.getFirstName().equals(employee.getFirstName()))
        .assertValue(employeeResponse ->
                employeeResponse.getFatherLastName().equals(employee.getFatherLastName()))
        .assertValue(employeeResponse ->
                employeeResponse.getMotherLastName().equals(employee.getMotherLastName()))
        .assertValue(employeeResponse ->
                employeeResponse.getGender().equals(employee.getGender().name()));

  }

}

