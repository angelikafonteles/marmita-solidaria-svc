package com.angelikafonteles.marmitasolidariasvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class MarmitaSolidariaSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarmitaSolidariaSvcApplication.class, args);
	}

	@Configuration
	@EnableWebMvc
	public class WebConfig extends WebMvcConfigurerAdapter {

		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**").allowedMethods("GET", "POST", "OPTIONS", "PUT", "PATCH", "DELETE");
		}
	}

}
