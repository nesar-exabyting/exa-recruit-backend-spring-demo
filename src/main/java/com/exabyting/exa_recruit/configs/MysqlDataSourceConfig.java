package com.exabyting.exa_recruit.configs;

import jakarta.persistence.EntityManagerFactory;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
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

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.exabyting.exa_recruit.repository.mysql",
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        transactionManagerRef = "mysqlTransactionManager"
)
public class MysqlDataSourceConfig {

    @Primary
    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "mysqlJpaProperties")
    @ConfigurationProperties(prefix = "spring.jpa.mysql")
    public JpaProperties mysqlJpaProperties() {
        return new JpaProperties();
    }

    @Primary
    @Bean(name = "mysqlLiquibaseProperties")
    @ConfigurationProperties(prefix = "spring.liquibase.mysql")
    public LiquibaseProperties liquibaseProperties() {
        return new LiquibaseProperties();
    }

    @Primary
    @Bean(name = "mysqlLiquibase")
    public SpringLiquibase liquibase(@Qualifier("mysqlDataSource") DataSource dataSource,
                                     @Qualifier("mysqlLiquibaseProperties") LiquibaseProperties properties) {
        return createLiquibaseBean(dataSource, properties);
    }

    private SpringLiquibase createLiquibaseBean(DataSource dataSource, LiquibaseProperties properties) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog(properties.getChangeLog());
        if (properties.getContexts() != null && !properties.getContexts().isEmpty()) {
            liquibase.setContexts(String.join(",", properties.getContexts()));
        }
        liquibase.setDefaultSchema(properties.getDefaultSchema());
        liquibase.setDropFirst(properties.isDropFirst());
        liquibase.setShouldRun(properties.isEnabled());
        return liquibase;
    }

    @Primary
    @Bean(name = "mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(
            @Qualifier("mysqlDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder,
            @Qualifier("mysqlJpaProperties") JpaProperties jpaProperties) {
        return builder
                .dataSource(dataSource)
                .packages("com.exabyting.exa_recruit.entity.mysql")
                .persistenceUnit("mysqlPU")
                .properties(jpaProperties.getProperties())
                .build();
    }

    @Primary
    @Bean(name = "mysqlTransactionManager")
    public PlatformTransactionManager mysqlTransactionManager(
            @Qualifier("mysqlEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
