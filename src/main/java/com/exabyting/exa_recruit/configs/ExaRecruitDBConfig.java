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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.exabyting.exa_recruit.repository.exarecruitdb",
        entityManagerFactoryRef = "exarecruitdbEntityManagerFactory",
        transactionManagerRef = "exarecruitdbTransactionManager"
)
public class ExaRecruitDBConfig {

    @Bean(name = "exarecruitdbDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.exarecruitdb")
    public DataSource exarecruitdbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "exarecruitdbJpaProperties")
    @ConfigurationProperties(prefix = "spring.jpa.exarecruitdb")
    public JpaProperties exarecruitdbJpaProperties() {
        return new JpaProperties();
    }

    @Bean(name = "exarecruitdbLiquibaseProperties")
    @ConfigurationProperties(prefix = "spring.liquibase.exarecruitdb")
    public LiquibaseProperties liquibaseProperties() {
        return new LiquibaseProperties();
    }

    @Bean(name = "exarecruitdbLiquibase")
    public SpringLiquibase liquibase(@Qualifier("exarecruitdbDataSource") DataSource dataSource,
                                     @Qualifier("exarecruitdbLiquibaseProperties") LiquibaseProperties properties) {
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

    @Bean(name = "exarecruitdbEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean exarecruitdbEntityManagerFactory(
            @Qualifier("exarecruitdbDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder,
            @Qualifier("exarecruitdbJpaProperties") JpaProperties jpaProperties) {
        return builder
                .dataSource(dataSource)
                .packages("com.exabyting.exa_recruit.entity.exarecruitdb")
                .persistenceUnit("exarecruitdbPU")
                .properties(jpaProperties.getProperties())
                .build();
    }

    @Bean(name = "exarecruitdbTransactionManager")
    public PlatformTransactionManager exarecruitdbTransactionManager(
            @Qualifier("exarecruitdbEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
