package pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.repository.entity.ContactEntity;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {
}
