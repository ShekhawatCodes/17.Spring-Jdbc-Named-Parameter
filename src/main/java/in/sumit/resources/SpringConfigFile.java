package in.sumit.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringConfigFile {

	@Bean
	public DriverManagerDataSource myDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/spring_jdbc_db");
		dataSource.setUsername("postgres");
		
		return dataSource;
	}
	
	@Bean
	public NamedParameterJdbcTemplate npJdbcTemplate() {
		return new NamedParameterJdbcTemplate(myDataSource());
	}
}
