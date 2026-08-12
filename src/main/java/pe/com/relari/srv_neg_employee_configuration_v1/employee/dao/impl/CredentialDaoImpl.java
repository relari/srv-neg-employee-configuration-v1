package pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.impl;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.CredentialDao;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.repository.CredentialRepository;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.util.JobTitleCategory;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CredentialDaoImpl implements CredentialDao {

    private final CredentialRepository credentialRepository;
    private final EmployeeToEntityMapper mapper;

    @Override
    public Completable save(Employee employee, JobTitleCategory jobTitleCategory) {
        return Single.fromCallable(() -> mapper.mapCredentialEntity(employee, jobTitleCategory))
                .map(credentialRepository::save)
                .ignoreElement();
    }
}
