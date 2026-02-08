package pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.repository.entity.EmployeeEntity;

import java.util.Optional;

/**
 * <b>Interface:</b> EmployeeRepository.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    Optional<EmployeeEntity> findByUsername(String username);

}
