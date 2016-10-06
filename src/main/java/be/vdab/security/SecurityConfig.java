package be.vdab.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final String ADMINISTRATOR = "administrator";
	private static final String USER = "user";
	private final DataSource dataSource;

	public SecurityConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login").and().logout().logoutSuccessUrl("/").and().authorizeRequests()
				.antMatchers("/brouwers/toevoegen").hasAuthority(ADMINISTRATOR)
				.antMatchers("/brouwers", "/brouwers/beginnaam", "/brouwers/opalfabet")
				.hasAnyAuthority(ADMINISTRATOR, USER);
		http.httpBasic();
	}
}