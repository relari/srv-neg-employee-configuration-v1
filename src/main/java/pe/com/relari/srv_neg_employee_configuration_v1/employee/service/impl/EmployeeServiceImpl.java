package pe.com.relari.srv_neg_employee_configuration_v1.employee.service.impl;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.EmployeeDao;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.service.EmployeeService;

import org.springframework.stereotype.Service;

/**
 * <b>Class:</b> EmployeeServiceImpl.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Service
@RequiredArgsConstructor
class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeDao employeeDao;

  @Override
  public Observable<Employee> findAll() {
    return employeeDao.findAll();
  }

  @Override
  public Completable save(Employee employee) {
    return employeeDao.save(employee);
  }

  @Override
  public Single<Employee> findById(Integer id) {
    return employeeDao.findById(id);
  }

  @Override
  public Single<Employee> findByUsername(String username) {
    return employeeDao.findByUsername(username);
  }

  @Override
  public Completable deleteByUsername(String username) {
    return employeeDao.findByUsername(username)
            .flatMapCompletable(employee ->
                    employeeDao.deleteById(employee.getIdEmployee())
            );
  }

  @Override
  public Completable deleteById(Integer id) {
    return employeeDao.findById(id)
            .flatMapCompletable(employee ->
                    employeeDao.deleteById(employee.getIdEmployee())
            );
  }

  @Override
  public Completable deleteAll() {
    return employeeDao.deleteAll();
  }

  @Override
  public Completable inactivateById(Integer id) {
    return employeeDao.findById(id)
            .flatMapCompletable(employee -> {
                employee.setIsActive(false);
                return employeeDao.save(employee);
            });
  }

  @Override
  public Completable activateById(Integer id) {
    return employeeDao.findById(id)
            .flatMapCompletable(employee -> {
                employee.setIsActive(true);
                return employeeDao.save(employee);
            });
  }

}
