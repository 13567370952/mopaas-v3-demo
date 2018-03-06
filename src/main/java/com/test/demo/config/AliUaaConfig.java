package com.test.demo.config;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryAliUaa",
        transactionManagerRef="transactionManagerAliUaa",
        basePackages= { "com.test.demo.aliuaa.entity.repository" }) //设置Repository所在位置
public class AliUaaConfig {

    @Autowired @Qualifier("aliUaaDataSource")
    private DataSource aliUaaDataSource;

    @Bean(name = "entityManagerRePo")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryRegistry(builder).getObject().createEntityManager();
    }

    @Bean(name = "entityManagerFactoryAliUaa")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryRegistry (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(aliUaaDataSource)
                .properties(getVendorProperties(aliUaaDataSource))
                .packages("com.test.demo.aliuaa.entity") //设置实体类所在位置
                .persistenceUnit("aliyunPersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Bean(name = "transactionManagerAliUaa")
    PlatformTransactionManager transactionManagerRegistry(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryRegistry(builder).getObject());
    }

}