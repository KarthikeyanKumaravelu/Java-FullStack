package com.ladera.claims.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
	entityManagerFactoryRef = "entityManagerFactory",
	basePackages= {"com.ladera.claims.s1.repositories"}
)

public class ClaimConfig {
	
	@Primary
	@Bean(name="dataSource")
	@ConfigurationProperties(prefix="spring.schema1.datasource")
	public DataSource dataSource () {
		return DataSourceBuilder.create().build();
	}
	
	@Primary
	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource")DataSource dataSource) {
		Map<String,Object> property=new HashMap<String,Object>();
		
		//Dialect
		
		property.put("hibernate.hbm2ddl.auto","update");  
//		property.put("hibernate.dialect","org.hibernate.dialect.MYSQL5Dialect");
		
		
		
		return builder.dataSource(dataSource)
		        .properties(property).packages("com.ladera.claims.s1.entities")
				.persistenceUnit("schema1")
				.build();
				
	}
	
	@Primary
	@Bean(name="transactionManager")
	public  PlatformTransactionManager transactionManager (@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
	

}
