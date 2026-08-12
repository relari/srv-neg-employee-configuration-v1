package pe.com.relari.srv_neg_employee_configuration_v1.employee.service;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;

/**
 * <b>Interface:</b> EmployeeService.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

public interface EmployeeService {

  Observable<Employee> findAll();

  Completable save(Employee employee);

  Single<Employee> findById(Integer id);

  Single<Employee> findByUsername(String username);

  Completable deleteByUsername(String username);

  Completable deleteById(Integer id);

  Completable deleteAll();

  Completable inactivateById(Integer id);

  Completable activateById(Integer id);
}
