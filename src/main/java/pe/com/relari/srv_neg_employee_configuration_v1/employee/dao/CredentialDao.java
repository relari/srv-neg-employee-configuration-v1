package pe.com.relari.srv_neg_employee_configuration_v1.employee.dao;

import io.reactivex.rxjava3.core.Completable;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.util.JobTitleCategory;

public interface CredentialDao {

    Completable save(Employee employee, JobTitleCategory jobTitleCategory);

}
