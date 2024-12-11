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
        basePackages = "com.exabyting.exa_recruit.repository.trellodb",
        entityManagerFactoryRef = "trellodbEntityManagerFactory",
        transactionManagerRef = "trellodbTransactionManager"
)
public class TrelloDBConfig {

    @Primary
    @Bean(name = "trellodbDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.trellodb")
    public DataSource trellodbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "trellodbJpaProperties")
    @ConfigurationProperties(prefix = "spring.jpa.trellodb")
    public JpaProperties trellodbJpaProperties() {
        return new JpaProperties();
    }

    @Primary
    @Bean(name = "trellodbLiquibaseProperties")
    @ConfigurationProperties(prefix = "spring.liquibase.trellodb")
    public LiquibaseProperties liquibaseProperties() {
        return new LiquibaseProperties();
    }

    @Primary
    @Bean(name = "trellodbLiquibase")
    public SpringLiquibase liquibase(@Qualifier("trellodbDataSource") DataSource dataSource,
                                     @Qualifier("trellodbLiquibaseProperties") LiquibaseProperties properties) {
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
    @Bean(name = "trellodbEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean trellodbEntityManagerFactory(
            @Qualifier("trellodbDataSource") DataSource dataSource, EntityManagerFactoryBuilder builder,
            @Qualifier("trellodbJpaProperties") JpaProperties jpaProperties) {
        return builder
                .dataSource(dataSource)
                .packages("com.exabyting.exa_recruit.entity.trellodb")
                .persistenceUnit("trellodbPU")
                .properties(jpaProperties.getProperties())
                .build();
    }

    @Primary
    @Bean(name = "trellodbTransactionManager")
    public PlatformTransactionManager trellodbTransactionManager(
            @Qualifier("trellodbEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
