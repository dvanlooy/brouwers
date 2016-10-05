package be.vdab.restservices;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.hateoas.config.EnableEntityLinks;

// enkele imports
@Configuration
@ComponentScan
@EnableSpringDataWebSupport
@EnableEntityLinks
public class RestControllersConfig {
}