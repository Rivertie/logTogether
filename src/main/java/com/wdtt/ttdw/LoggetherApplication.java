package com.wdtt.ttdw;

import javax.servlet.ServletContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.loader.Loader;
import com.mitchellbosecke.pebble.loader.ServletLoader;
import com.mitchellbosecke.pebble.spring4.PebbleViewResolver;
import com.mitchellbosecke.pebble.spring4.extension.SpringExtension;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {JpaRepositoriesAutoConfiguration.class})
@ComponentScan("com.wdtt.ttdw")
@EntityScan("com.wdtt.entity")
//@EnableJpaRepositories("com.wdtt.repository")
@EnableJpaAuditing
public class LoggetherApplication extends WebMvcConfigurationSupport {

	private ServletContext servletContext;

	public LoggetherApplication(ServletContext servletContext) {
		super();
		this.servletContext = servletContext;
	}
		
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/WEB-INF/**").addResourceLocations("/WEB-INF/");
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
		registry.addResourceHandler("/image/**").addResourceLocations("classpath:/static/image/");
	}
	
// ===================== Pebble Template 설정 =====================
// https://pebbletemplates.io/
	
	@Bean
    public SpringExtension springExtension() {
        return new SpringExtension();
    }
	
	@Bean
    public Loader<?> pebbleLoader(){
        return new ServletLoader(servletContext);
    }
	
	@Bean
	public PebbleEngine pebbleEngine() {
		return new PebbleEngine.Builder()
			.loader(pebbleLoader())
			.extension(this.springExtension())
			.cacheActive(false)
			.build();
	}
	 
	/**
	 * ViewResolver 
	 */
	@Bean
	public PebbleViewResolver pebbleViewResolver() {
		PebbleViewResolver pebbleViewResolver = new PebbleViewResolver();
		pebbleViewResolver.setPebbleEngine(this.pebbleEngine());
		pebbleViewResolver.setOrder(0);
		pebbleViewResolver.setPrefix("/WEB-INF/templates/");
		pebbleViewResolver.setSuffix(".html");
		pebbleViewResolver.setCache(true);
		pebbleViewResolver.setContentType("text/html; charset=UTF-8");
		return pebbleViewResolver;
	}

	public static void main(String[] args) {
		SpringApplication.run(LoggetherApplication.class, args);
	}
	
}
