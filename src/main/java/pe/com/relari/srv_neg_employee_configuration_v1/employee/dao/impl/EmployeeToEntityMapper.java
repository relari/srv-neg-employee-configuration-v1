package pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.impl;

import lombok.RequiredArgsConstructor;
import pe.com.relari.commons.util.Utility;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Company;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Contact;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Credential;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Document;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.repository.entity.CompanyEntity;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.repository.entity.ContactEntity;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.repository.entity.CredentialEntity;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.repository.entity.EmployeeEntity;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.util.JobTitleCategory;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class EmployeeToEntityMapper {

//  private final PasswordEncoder passwordEncoder;

    /**
     * Mapea la entidad al empleado.
     * @param employeeEntity {@link EmployeeEntity}
     * @return {@link Employee}
     */
  public Employee mapEmployee(EmployeeEntity employeeEntity) {
    return Employee.builder()
            .idEmployee(employeeEntity.getId())
            .firstName(employeeEntity.getFirstName())
            .fatherLastName(employeeEntity.getFatherLastName())
            .motherLastName(employeeEntity.getMotherLastName())
            .gender(employeeEntity.getGender())
            .birthdate(employeeEntity.getBirthdate())
            .document(new Document(
                    employeeEntity.getDocumentType(),
                    employeeEntity.getDocumentNumber()
            ))
            .credential(new Credential(
                    employeeEntity.getUsername(),
                    employeeEntity.getPassword()
            ))
            .company(new Company(
                    employeeEntity.getJobTitle(),
                    employeeEntity.getSalary()
            ))
            .contact(new Contact(
                    employeeEntity.getEmail(),
                    employeeEntity.getPhoneNumber()
            ))
            .creationDate(employeeEntity.getCreationDate())
            .isActive(employeeEntity.getIsActive())
            .build();
  }

    /**
     * Mapea la entidad al empleado.
     * @param employeeEntity {@link EmployeeEntity}
     * @return {@link Employee}
     */
    public Employee mapBuildEmployee(EmployeeEntity employeeEntity) {
        return Employee.builder()
                .idEmployee(employeeEntity.getId())
                .firstName(employeeEntity.getFirstName())
                .fatherLastName(employeeEntity.getFatherLastName())
                .motherLastName(employeeEntity.getMotherLastName())
                .gender(employeeEntity.getGender())
                .birthdate(employeeEntity.getBirthdate())
//                .contact(new Contact(
//                        employeeEntity.getContact()
//                ))
//                .credential(new Credential(
//                        employeeEntity.getCredential()
//                ))
//                .company(new Company(
//                        employeeEntity.getCompany()
//                ))
                .creationDate(employeeEntity.getCreationDate())
                .isActive(employeeEntity.getIsActive())
                .build();
    }

    /**
     * Mapea el empleado a la entidad para crear al usuario.
     * @param employee {@link Employee}
     * @return {@link EmployeeEntity}
     */
  public EmployeeEntity mapEmployeeEntity(Employee employee) {
    var username = Utility.buildUsername(
            employee.getFirstName(),
            employee.getFatherLastName()
    );
    return EmployeeEntity.builder()
            .id(employee.getIdEmployee())
            .firstName(employee.getFirstName())
            .fatherLastName(employee.getFatherLastName())
            .motherLastName(employee.getMotherLastName())
            .gender(employee.getGender())
            .documentType(employee.getDocument().getType())
            .documentNumber(employee.getDocument().getNumber())
            .birthdate(employee.getBirthdate())
            .isActive(employee.getIsActive())
            .creationDate(LocalDateTime.now())

            .email(employee.getContact().getEmail())
            .phoneNumber(employee.getContact().getPhoneNumber())

            .jobTitle(employee.getCompany().getJobTitle())
            .salary(employee.getCompany().getSalary())

            .username(username)
            .password(Utility.buildPassword(username, employee.getGender().name())
            )
//            .password(passwordEncoder.encode(
//                    Utility.buildPassword(username, employee.getGender().name())
//            ))

            .build();
  }

  public ContactEntity mapContactEntity(Employee employee, Contact contact) {
      return ContactEntity.builder()
//              .employee(mapEmployeeEntity(employee))
              .email(contact.getEmail())
              .phoneNumber(contact.getPhoneNumber())
              .build();
  }

  public CredentialEntity mapCredentialEntity(Employee employee, JobTitleCategory jobTitleCategory) {
      var username = Utility.buildUsername(employee.getFirstName(), employee.getFatherLastName());
      return CredentialEntity.builder()
//              .employee(mapEmployeeEntity(employee))
              .username(username)
              .password(
                      Utility.buildPassword(username, jobTitleCategory.name())
              )
//              .password(passwordEncoder.encode(
//                      Utility.buildPassword(username, jobTitleCategory.name())
//              ))
              .build();
  }

  public CompanyEntity mapCompanyEntity(Employee employee, Company company) {
      return CompanyEntity.builder()
//              .employee(mapEmployeeEntity(employee))
              .jobTitle(company.getJobTitle())
              .salary(company.getSalary())
              .build();
  }

}
