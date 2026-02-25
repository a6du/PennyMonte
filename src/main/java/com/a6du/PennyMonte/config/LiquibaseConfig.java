package com.a6du.PennyMonte.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jpa.autoconfigure.EntityManagerFactoryDependsOnPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import liquibase.integration.spring.SpringLiquibase;

/**
 * Ensures Liquibase runs before JPA by defining an explicit SpringLiquibase bean
 * and making EntityManagerFactory depend on it.
 */
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE + 10)
public class LiquibaseConfig {

    private static final Logger log = LoggerFactory.getLogger(LiquibaseConfig.class);

    @Bean
    public SpringLiquibase liquibase(
            DataSource dataSource,
            @Value("${spring.liquibase.change-log:classpath:db/changelog/db.changelog-master.yaml}") String changeLog,
            @Value("${spring.liquibase.enabled:true}") boolean enabled) {
        log.info("Configuring Liquibase to run database migrations (changeLog={})...", changeLog);
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog(changeLog);
        liquibase.setShouldRun(enabled);
        return liquibase;
    }

    /**
     * Ensures EntityManagerFactory is created after Liquibase has run, so the schema exists.
     */
    @Bean
    public static EntityManagerFactoryDependsOnPostProcessor liquibaseEntityManagerFactoryDependsOnPostProcessor() {
        return new EntityManagerFactoryDependsOnPostProcessor("liquibase");
    }
}
