package pe.com.relari.srv_neg_employee_configuration_v1.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import pe.com.relari.commons.util.DateUtil;
import pe.com.relari.commons.util.JsonUtil;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeRequest;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeResponse;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class RequestToEmployeeMapperTest {

  @Test
  void mapEmployee() throws IOException {

    EmployeeRequest employeeRequest = JsonUtil.readJsonFromResource(
            "data/Employee.json", EmployeeRequest.class);

    Employee employee = RequestToEmployeeMapper.mapEmployee(employeeRequest);

    assertEquals(employeeRequest.getFirstName(), employee.getFirstName());
    assertEquals(employeeRequest.getFatherLastName(), employee.getFatherLastName());
    assertEquals(employeeRequest.getMotherLastName(), employee.getMotherLastName());
    assertEquals(employeeRequest.getGender(), employee.getGender().name());
    assertEquals(employeeRequest.getBirthdate(), employee.getBirthdate().toString());
    assertEquals(employeeRequest.getDocument().getType(), employee.getDocument().getType().name());
    assertEquals(employeeRequest.getDocument().getNumber(), employee.getDocument().getNumber());
    assertEquals(employeeRequest.getContactInfo().getEmail(), employee.getContact().getEmail());
    assertEquals(employeeRequest.getContactInfo().getPhoneNumber(), employee.getContact().getPhoneNumber());
    assertEquals(employeeRequest.getCompany().getJobTitle(), employee.getCompany().getJobTitle().name());
    assertEquals(employeeRequest.getCompany().getSalary(), employee.getCompany().getSalary());

  }

  @Test
  void mapEmployeeResponse() throws IOException {

    Employee employee = JsonUtil.readJsonFromResource(
            "data/Employee.json", Employee.class);
    EmployeeResponse employeeResponse = RequestToEmployeeMapper.mapEmployeeResponse(employee);

    assertEquals(employee.getFirstName(), employeeResponse.getFirstName());
    assertEquals(employee.getFatherLastName(), employeeResponse.getFatherLastName());
    assertEquals(employee.getMotherLastName(), employeeResponse.getMotherLastName());
    assertEquals(employee.getGender().name(), employeeResponse.getGender());
    assertEquals(DateUtil.formatDate(employee.getBirthdate()), employeeResponse.getBirthdate());
    assertEquals(employee.getDocument().getType().name(), employeeResponse.getDocument().getType());
    assertEquals(employee.getDocument().getNumber(), employeeResponse.getDocument().getNumber());
    assertEquals(employee.getContact().getEmail(), employeeResponse.getContact().getEmail());
    assertEquals(employee.getContact().getPhoneNumber(), employeeResponse.getContact().getPhoneNumber());
    assertEquals(employee.getCompany().getJobTitle().name(), employeeResponse.getCompany().getJobTitle());
    assertEquals(employee.getCompany().getSalary(), employeeResponse.getCompany().getSalary());
  }

}
