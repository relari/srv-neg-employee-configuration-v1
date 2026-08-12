package pe.com.relari.srv_neg_employee_configuration_v1.employee.dao;

import io.reactivex.rxjava3.core.Completable;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Contact;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;

public interface ContactDao {

    Completable save(Employee employee, Contact contact);

}
