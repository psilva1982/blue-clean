package blue.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import blue.service.CadastroEstadoService;

@Configuration
@ComponentScan(basePackageClasses = CadastroEstadoService.class)
public class ServiceConfig {


}
