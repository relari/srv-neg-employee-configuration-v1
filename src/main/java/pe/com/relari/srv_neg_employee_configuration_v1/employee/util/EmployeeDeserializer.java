package pe.com.relari.srv_neg_employee_configuration_v1.employee.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import pe.com.relari.commons.util.DateUtil;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Company;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Contact;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Document;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;

import java.io.IOException;

/**
 * <b>Class:</b> EmployeeDeserializer.
 * Custom JSON deserializer for Employee class that handles complex type conversions
 * (enums, LocalDate, nested objects).
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */
public class EmployeeDeserializer extends JsonDeserializer<Employee> {

  @Override
  public Employee deserialize(JsonParser parser, DeserializationContext context) throws IOException {
    JsonNode node = parser.getCodec().readTree(parser);

    return Employee.builder()
        .firstName(node.get("firstName").asText())
        .fatherLastName(node.get("fatherLastName").asText())
        .motherLastName(node.get("motherLastName").asText())
        .gender(GenderCategory.valueOf(node.get("gender").asText()))
        .birthdate(DateUtil.parseLocalDate(node.get("birthdate").asText()))
        .document(deserializeDocument(node.get("document")))
        .contact(deserializeContact(node.get("contactInfo")))
        .company(deserializeCompany(node.get("company")))
        .build();
  }

  private Document deserializeDocument(JsonNode documentNode) {
    if (documentNode == null || documentNode.isNull()) {
      return null;
    }
    return new Document(
        DocumentTypeCategory.valueOf(documentNode.get("type").asText()),
        documentNode.get("number").asText()
    );
  }

  private Contact deserializeContact(JsonNode contactNode) {
    if (contactNode == null || contactNode.isNull()) {
      return null;
    }
    return new Contact(
        contactNode.get("email").asText(),
        contactNode.get("phoneNumber").asText()
    );
  }

  private Company deserializeCompany(JsonNode companyNode) {
    if (companyNode == null || companyNode.isNull()) {
      return null;
    }
    return new Company(
        JobTitleCategory.valueOf(companyNode.get("jobTitle").asText()),
        companyNode.get("salary").asDouble()
    );
  }
}
