//package pe.com.relari.srv_neg_employee_configuration_v1.employee.util;
//
//import pe.com.relari.commons.util.DateUtil;
//import pe.com.relari.commons.util.Utility;
//import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeRequest;
//import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Company;
//import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Contact;
//import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Credential;
//import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Document;
//import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
//import pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.repository.entity.EmployeeEntity;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.time.LocalDateTime;
//import java.io.IOException;
//
///**
// * <b>Class:</b> TestMapper.
// * Utility class to create test data from Employee.json.
// * @author Renzo Lavado Rivas.
// * @version 1.0.0
// */
//public class TestMapper {
//
//  private static final Integer EMPLOYEE_ID = 1;
//  private static final String PASSWORD = "$2a$10$VgrbuoTcdzHz1NgP2/0IheTHbNhGm9dxgGOrLdd4SA1l4UWuh8B6i";
//  private static final Boolean IS_ACTIVE = true;
//  private static final LocalDateTime dateCreated = LocalDateTime.now();
//  private static final ObjectMapper objectMapper = new ObjectMapper();
//
//  private TestMapper() {}
//
//  public static EmployeeRequest employeeRequest() {
//    return TestJsonConverter.readDataFromFileJson(
//            TestConstant.employeeJson, EmployeeRequest.class
//    );
//  }
//
//  /**
//   * Deserializes JSON directly to Employee using custom EmployeeDeserializer.
//   * @return Employee instance deserialized from JSON file
//   */
//  public static Employee employeeFromJson() {
//    try {
//      String jsonContent = TestJsonConverter.readJsonContent(TestConstant.employeeJson);
//      return objectMapper.readValue(jsonContent, Employee.class);
//    } catch (IOException e) {
//      throw new RuntimeException("Error deserializing Employee from JSON", e);
//    }
//  }
//
//  public static Employee employee() {
//    var request = employeeRequest();
//    return Employee.builder()
//        .idEmployee(EMPLOYEE_ID)
//        .firstName(request.getFirstName())
//        .fatherLastName(request.getFatherLastName())
//        .motherLastName(request.getMotherLastName())
//        .gender(GenderCategory.valueOf(request.getGender()))
//        .birthdate(DateUtil.parseLocalDate(request.getBirthdate()))
//        .document(new Document(request.getDocument()))
//        .contact(new Contact(request.getContactInfo()))
//        .credential(new Credential(
//                Utility.buildUsername(request.getFirstName(), request.getFatherLastName()),
//                PASSWORD
//        ))
//        .company(new Company(request.getCompany()))
//        .isActive(IS_ACTIVE)
//        .creationDate(dateCreated)
//        .build();
//  }
//
//  public static EmployeeEntity employeeEntity() {
//    var employee = employee();
//    return EmployeeEntity.builder()
//        .id(employee.getIdEmployee())
//        .firstName(employee.getFirstName())
//        .fatherLastName(employee.getFatherLastName())
//        .motherLastName(employee.getMotherLastName())
//        .gender(employee.getGender())
//        .birthdate(employee.getBirthdate())
//        .documentType(employee.getDocument().getType())
//        .documentNumber(employee.getDocument().getNumber())
//
//        .email(employee.getContact().getEmail())
//        .phoneNumber(employee.getContact().getPhoneNumber())
//
//        .username(Utility.buildUsername(
//                employee.getFirstName(), employee.getFatherLastName()
//        ))
//        .password(PASSWORD)
//
//        .jobTitle(employee.getCompany().getJobTitle())
//        .salary(employee.getCompany().getSalary())
//
//        .creationDate(dateCreated)
//        .isActive(employee.getIsActive())
//        .build();
//  }
//}
//
