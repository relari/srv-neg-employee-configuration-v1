package pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.repository.entity.EmployeeEntity;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.util.TestMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

class EmployeeToEntityMapperTest {

  @Mock
  PasswordEncoder passwordEncoder;

  @InjectMocks
  EmployeeToEntityMapper employeeToEntityMapper;

  @BeforeEach
  public void init() throws Exception {
    MockitoAnnotations.openMocks(this).close();
  }

  @Test
  void mapEmployee() {

    EmployeeEntity employeeEntity = TestMapper.employeeEntity();

    Employee employee = employeeToEntityMapper.mapEmployee(employeeEntity);

    assertEquals(employeeEntity.getFirstName(), employee.getFirstName());

  }

  @Test
  void mapPersonResponse() {

    Mockito.when(passwordEncoder.encode(Mockito.anyString()))
      .thenReturn("$2a$10$VgrbuoTcdzHz1NgP2/0IheTHbNhGm9dxgGOrLdd4SA1l4UWuh8B6i");

    Employee employee = TestMapper.employee();
    EmployeeEntity employeeEntity = employeeToEntityMapper.mapEmployeeEntity(employee);

    assertEquals(employee.getFirstName(), employeeEntity.getFirstName());
  }

}
