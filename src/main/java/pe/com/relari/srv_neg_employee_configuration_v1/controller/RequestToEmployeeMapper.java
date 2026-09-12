package pe.com.relari.srv_neg_employee_configuration_v1.controller;

import static pe.com.relari.commons.constant.Constants.ACTIVE;

import pe.com.relari.commons.util.DateUtil;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api.CompanyResponse;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api.ContactResponse;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api.DocumentResponse;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeRequest;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeResponse;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Company;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Contact;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Document;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.util.GenderCategory;

public class RequestToEmployeeMapper {

  private RequestToEmployeeMapper() {}

  static Employee mapEmployee(EmployeeRequest employeeRequest) {
    return Employee.builder()
            .firstName(employeeRequest.getFirstName())
            .fatherLastName(employeeRequest.getFatherLastName())
            .motherLastName(employeeRequest.getMotherLastName())
            .gender(GenderCategory.valueOf(employeeRequest.getGender()))
            .birthdate(DateUtil.parseLocalDate(employeeRequest.getBirthdate()))
            .document(new Document(employeeRequest.getDocument()))
            .contact(new Contact(employeeRequest.getContactInfo()))
            .company(new Company(employeeRequest.getCompany()))
            .isActive(ACTIVE)
            .build();
  }
  static EmployeeResponse mapEmployeeResponse(Employee employee) {
    return EmployeeResponse.builder()
            .firstName(employee.getFirstName())
            .fatherLastName(employee.getFatherLastName())
            .motherLastName(employee.getMotherLastName())
            .gender(employee.getGender().name())
            .birthdate(DateUtil.formatDate(employee.getBirthdate()))
            .document(new DocumentResponse(employee.getDocument()))
            .contact(new ContactResponse(employee.getContact()))
            .company(new CompanyResponse(employee.getCompany()))
            .build();
  }

}
