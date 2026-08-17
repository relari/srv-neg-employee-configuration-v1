package pe.com.relari.srv_neg_employee_configuration_v1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pe.com.relari.fwk.spring.reactive.handler.error.config.ErrorConfig;
import pe.com.relari.fwk.spring.reactive.handler.error.handler.GlobalExceptionHandler;

/**
 * <b>Class:</b> ErrorHandlerConfig.
 * Enables the global error handler from the reactive framework library
 * with compatibility for WebFlux validation exceptions.
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Configuration
@ComponentScan(basePackageClasses = {GlobalExceptionHandler.class, ErrorConfig.class})
public class ErrorHandlerConfig {

}
