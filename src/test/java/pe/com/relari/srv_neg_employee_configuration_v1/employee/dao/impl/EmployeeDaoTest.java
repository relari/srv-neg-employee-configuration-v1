//package pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.impl;
//
//import io.reactivex.rxjava3.observers.TestObserver;
//import pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.repository.EmployeeRepository;
//import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
//import pe.com.relari.srv_neg_employee_configuration_v1.employee.util.TestMapper;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Collections;
//import java.util.Optional;
//import java.util.concurrent.TimeUnit;
//
//class EmployeeDaoTest {
//
//  @Mock
//  private EmployeeToEntityMapper employeeToEntityMapper;
//
//
//
//  @Mock
//  private EmployeeRepository employeeRepository;
//
//  @InjectMocks
//  private EmployeeDaoImpl employeeDao;
//
//  @BeforeEach
//  void init() throws Exception {
//    MockitoAnnotations.openMocks(this).close();
//  }
//
//  @Test
//  void whenFindAllThenReturnListEmployees() {
//
//    Mockito.when(employeeRepository.findAll())
//        .thenReturn(Collections.singletonList(TestMapper.employeeEntity()));
//
//    Mockito.when(employeeToEntityMapper.mapEmployee(Mockito.any()))
//            .thenReturn(TestMapper.employee());
//
//    TestObserver<Employee> testObserver = employeeDao.findAll().test();
//
//    testObserver.awaitDone(5, TimeUnit.SECONDS);
//
//    testObserver.assertComplete().assertNoErrors();
//
//  }
//
//  @Test
//  void whenFindByIdThenReturnEmployee() {
//
//    Mockito.when(employeeRepository.findById(Mockito.anyInt()))
//        .thenReturn(Optional.of(TestMapper.employeeEntity()));
//
//    Mockito.when(employeeToEntityMapper.mapEmployee(Mockito.any()))
//            .thenReturn(TestMapper.employee());
//
//    TestObserver<Employee> testObserver = employeeDao.findById(1).test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertComplete().assertNoErrors();
//
//  }
//
////  @Test
////  void whenSaveEmployeeThenReturnEmployee() {
////
////    Mockito.when(employeeRepository.save(Mockito.any()))
////        .thenReturn(TestMapper.employeeEntity());
////
////    TestObserver<Void> testObserver = employeeDao.save(TestMapper.employee()).test();
////
////    testObserver.awaitTerminalEvent();
////
////    testObserver.assertComplete().assertNoErrors();
////
////  }
//
//  @Test
//  void whenFindByIdThenReturnEmpty() {
//
//    Mockito.when(employeeRepository.findById(Mockito.anyInt()))
//            .thenReturn(Optional.empty());
//
//    Mockito.when(employeeToEntityMapper.mapEmployee(Mockito.any()))
//            .thenReturn(null);
//
//    TestObserver<Employee> testObserver = employeeDao.findById(1).test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertNotComplete().assertNoValues();
//
//  }
//
//  @Test
//  void whenSaveEmployeeThenReturnError() {
//
//    Mockito.when(employeeToEntityMapper.mapEmployee(Mockito.any()))
//            .thenReturn(TestMapper.employee());
//
//    Mockito.when(employeeRepository.save(Mockito.any()))
//            .thenReturn(new Throwable());
//
//    TestObserver<Void> testObserver = employeeDao.save(TestMapper.employee()).test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertNotComplete().assertNoValues();
//
//  }
//
////  private RuntimeException employeeException() {
////    return errorFactory.buildException(ErrorCategory.EMPLOYEE_NOT_SAVE, null);
////  }
//
//}
