package pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "CONTACT")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "empresaId", referencedColumnName = "id")
//    private EmployeeEntity employee;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "phoneNumber", length = 9, nullable = false)
    private String phoneNumber;

}
