package pe.com.relari.srv_neg_employee_configuration_v1.controller;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.observers.TestObserver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.com.relari.commons.util.JsonUtil;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeRequest;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.service.EmployeeService;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateEmployeeControllerTest {

  @Mock
  private EmployeeService employeeService;

  @InjectMocks
  private CreateEmployeeController createEmployeeController;

  @Test
  void whenSaveEmployeeThenReturnSuccessful() throws IOException {
    when(employeeService.save(any()))
        .thenReturn(Completable.complete());

    var employeeRequest = JsonUtil.readJsonFromResource(
            "data/Employee.json", EmployeeRequest.class);

    TestObserver<Void> testObserver =
            createEmployeeController.save(employeeRequest).test();

//    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();

  }

}