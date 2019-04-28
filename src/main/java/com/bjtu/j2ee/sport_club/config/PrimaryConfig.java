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
		entityManagerFactoryRef = "primaryEntityManagerFactory",
		transactionManagerRef = "primaryTransactionManager",
		basePackages = {"com.bjtu.j2ee.sport_club.repository"})

public class PrimaryConfig {
	@Autowired
	private HibernateProperties hibernateProperties;
	@Resource
	@Qualifier("primaryDataSource")
	private DataSource primaryDataSource;

	@Primary
	@Bean(name = "primaryEntityManager")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return primaryEntityManagerFactory(builder).getObject().createEntityManager();
	}

	@Resource
	private JpaProperties jpaProperties;

	/**
	 * 设置实体类所在位置
	 */
	@Primary
	@Bean(name = "primaryEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(EntityManagerFactoryBuilder builder) {

		Map<String, Object> properties = hibernateProperties.determineHibernateProperties(
				jpaProperties.getProperties(), new HibernateSettings());
		return builder
				.dataSource(primaryDataSource)
				.packages("com.bjtu.j2ee.sport_club.domain")
				.persistenceUnit("primaryPersistenceUnit")
				.properties(properties)
				.build();
	}

	@Primary
	@Bean(name = "primaryTransactionManager")
	public PlatformTransactionManager primaryTransactionManager(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(primaryEntityManagerFactory(builder).getObject());
	}
}