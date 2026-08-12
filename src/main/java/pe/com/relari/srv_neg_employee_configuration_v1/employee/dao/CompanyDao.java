package pe.com.relari.srv_neg_employee_configuration_v1.employee.dao;

import io.reactivex.rxjava3.core.Completable;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Company;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;

public interface CompanyDao {

    Completable save(Employee employee, Company company);

}
