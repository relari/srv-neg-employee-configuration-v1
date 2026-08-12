//package pe.com.relari.srv_neg_employee_configuration_v1.employee.service.impl;
//
//import io.reactivex.rxjava3.core.Observable;
//import io.reactivex.rxjava3.core.Single;
//import io.reactivex.rxjava3.observers.TestObserver;
//import pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.EmployeeDao;
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
//class EmployeeServiceTest {
//
//  @Mock
//  private EmployeeDao employeeDao;
//
//  @InjectMocks
//  private EmployeeServiceImpl employeeService;
//
//  @BeforeEach
//  void init() throws Exception {
//    MockitoAnnotations.openMocks(this).close();
//  }
//
//  @Test
//  void whenFindAllThenReturnListEmployees() {
//
//    Mockito.when(employeeDao.findAll())
//        .thenReturn(Observable.just(TestMapper.employee()));
//
//    TestObserver<Employee> testObserver = employeeService.findAll().test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertComplete().assertNoErrors();
//
//  }
//
////  @Test
////  void whenSaveEmployeeThenReturnSuccessful() {
////
////    Mockito.when(employeeDao.save(Mockito.any()))
////        .thenReturn(Completable.complete());
////
////    TestObserver<Void> testObserver =
////        employeeService.save(TestMapper.employee()).test();
////
////    testObserver.awaitTerminalEvent();
////
////    testObserver.assertComplete().assertNoErrors();
////
////  }
//
//  @Test
//  void whenFindByIdThenReturnEmployee() {
//
//    var employee = TestMapper.employee();
//
//    Mockito.when(employeeDao.findById(Mockito.anyInt()))
//        .thenReturn(Single.just(employee));
//
//    TestObserver<Employee> testObserver = employeeService.findById(1).test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertComplete().assertNoErrors()
//        .assertValue(employeeDto -> employeeDto.getIdEmployee().equals(employee.getIdEmployee()))
//        .assertValue(employeeDto -> employeeDto.getFirstName().equals(employee.getFirstName()))
//        .assertValue(employeeDto -> employeeDto.getFatherLastName().equals(employee.getFatherLastName()))
//        .assertValue(employeeDto -> employeeDto.getMotherLastName().equals(employee.getMotherLastName()))
//        .assertValue(employeeDto -> employeeDto.getGender().equals(employee.getGender()))
//        .assertValue(employeeDto -> employeeDto.getCompany().getJobTitle().equals(employee.getCompany().getJobTitle()))
//        .assertValue(employeeDto -> employeeDto.getCompany().getSalary().equals(employee.getCompany().getSalary()))
//        .assertValue(employeeDto -> employeeDto.getIsActive().equals(employee.getIsActive()));
//
//  }
//
//  @Test
//  void whenFindByIdThenReturnError() {
//
//    Mockito.when(employeeDao.findById(Mockito.anyInt()))
//        .thenReturn(Single.error(new Throwable()));
//
//    TestObserver<Employee> testObserver = employeeService.findById(1).test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertNotComplete().assertNoValues();
//
//  }
//
////  @Test
////  void whenSaveEmployeeThenReturnError() {
////
////    Mockito.when(employeeDao.save(Mockito.any()))
////        .thenReturn(Completable.error(Throwable::new));
////
////    TestObserver<Void> testObserver = employeeService.save(TestMapper.employee()).test();
////
////    testObserver.awaitTerminalEvent();
////
////    testObserver.assertNotComplete().assertNoValues();
////
////  }
//
//}
