package pe.com.relari.srv_neg_employee_configuration_v1.controller;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.observers.TestObserver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.com.relari.commons.util.JsonUtil;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeResponse;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.service.EmployeeService;

import java.io.IOException;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindEmployeeControllerTest {

  @Mock
  private EmployeeService employeeService;

  @InjectMocks
  private FindEmployeeController findEmployeeController;

  @Test
  void whenFindByIdThenReturnEmployee() throws IOException {

    Employee employee = JsonUtil.readJsonFromResource("data/Employee.json", Employee.class);

    when(employeeService.findByUsername(anyString()))
            .thenReturn(Single.just(employee));

    TestObserver<EmployeeResponse> testObserver =
            findEmployeeController.findEmployeeByUsername("renzo.lavado").test();

//    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors()
        .assertValue(employeeResponse ->
                employeeResponse.getFirstName().equals(employee.getFirstName()))
        .assertValue(employeeResponse ->
                employeeResponse.getFatherLastName().equals(employee.getFatherLastName()))
        .assertValue(employeeResponse ->
                employeeResponse.getMotherLastName().equals(employee.getMotherLastName()));

  }

}