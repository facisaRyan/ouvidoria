package br.com.facisa.competencia.ouvidoria;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	//@Autowired
	//private UsuarioDetailsService usuarioDetailsService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/autenticacao/**")
			.permitAll()
			.anyRequest().authenticated()
		.and()
		.formLogin((form) -> form
				.loginPage("/autenticacao/login")
				.permitAll()
				.defaultSuccessUrl("/home", true)
			)
			.logout((logout) -> logout.permitAll().logoutSuccessUrl("/autenticacao/login"));
		return http.build();
	}
	
	@Bean
	UserDetailsManager users(DataSource dataSource) {

		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
		
		return users;
	}
}
