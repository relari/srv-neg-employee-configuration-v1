package pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.impl;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.CompanyDao;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.repository.CompanyRepository;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Company;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyDaoImpl implements CompanyDao {

    private final CompanyRepository contactRepository;
    private final EmployeeToEntityMapper mapper;

    @Override
    public Completable save(Employee employee, Company company) {
        return Single.fromCallable(() -> mapper.mapCompanyEntity(employee, company))
                .map(contactRepository::save)
                .ignoreElement();
    }
}
