package blue.config.init;

import javax.servlet.ServletContext;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import blue.config.JPAConfig;
import blue.config.ServiceConfig;
import blue.config.ViewScopeConfig;
import blue.controller.EstadoController;

public class SpringAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) {

		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		
		rootContext.register(JPAConfig.class);
		rootContext.register(ServiceConfig.class);
		rootContext.register(ViewScopeConfig.class);
		
		rootContext.scan(EstadoController.class.getPackage().getName());

		container.addListener(new ContextLoaderListener(rootContext));
		container.addListener(new RequestContextListener());
	}

}