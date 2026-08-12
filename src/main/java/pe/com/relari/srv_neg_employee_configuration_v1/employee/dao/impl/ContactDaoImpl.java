package pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.impl;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.ContactDao;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.repository.ContactRepository;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Contact;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContactDaoImpl implements ContactDao {

    private final ContactRepository contactRepository;
    private final EmployeeToEntityMapper mapper;

    @Override
    public Completable save(Employee employee, Contact contact) {
        return Single.fromCallable(() -> mapper.mapContactEntity(employee, contact))
                .map(contactRepository::save)
                .ignoreElement();
    }
}
