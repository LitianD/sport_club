package com.bjtu.j2ee.sport_club.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "secondaryEntityManagerFactory",
		transactionManagerRef = "secondaryTransactionManager",
		basePackages = {"com.bjtu.j2ee.sport_club.repository2"})

public class SecondaryConfig {
	@Autowired
	private HibernateProperties hibernateProperties;
	@Resource
	@Qualifier("secondaryDataSource")
	private DataSource secondaryDataSource;


	@Bean(name = "secondaryEntityManager")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return secondaryEntityManagerFactory(builder).getObject().createEntityManager();
	}

	@Resource
	private JpaProperties jpaProperties;

	/**
	 * 设置实体类所在位置
	 */

	@Bean(name = "secondaryEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(EntityManagerFactoryBuilder builder) {

		Map<String, Object> properties = hibernateProperties.determineHibernateProperties(
				jpaProperties.getProperties(), new HibernateSettings());
		return builder
				.dataSource(secondaryDataSource)
				.packages("com.bjtu.j2ee.sport_club.domain")
				.persistenceUnit("secondaryPersistenceUnit")
				.properties(properties)
				.build();
	}


	@Bean(name = "secondaryTransactionManager")
	public PlatformTransactionManager secondaryTransactionManager(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(secondaryEntityManagerFactory(builder).getObject());
	}
}