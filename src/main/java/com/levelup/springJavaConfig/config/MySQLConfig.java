package com.levelup.springJavaConfig.config;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.levelup" })
public class MySQLConfig {

    private static final Logger LOG = Logger.getLogger(MySQLConfig.class);
    //    @Autowired
//    private Environment env;
//    @Value("${jdbc.driverClassName}")
//    private String jdbcDriver;
//    @Value("${jdbc.url}")
//    private String jdbcURL;
//    @Value("${jdbc.user}")
//    private String jdbcUser;
//    @Value("${jdbc.pass}")
//    private String jdbcPass;
//    @Value("${hibernate.hbm2ddl.auto}")
//    private String hibernateHBM;
//    @Value("${hibernate.dialect}")
//    private String hibernateDialect;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setMappingResources(new String[] {"com.levelup"});
        sessionFactory.setPackagesToScan(new String[] {"com.levelup.springJavaConfig.model"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(Preconditions.checkNotNull(jdbcDriver));
//        dataSource.setUrl(Preconditions.checkNotNull(jdbcURL));
//        dataSource.setUsername(Preconditions.checkNotNull(jdbcUser));
//        dataSource.setPassword(Preconditions.checkNotNull(jdbcPass));
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl(jdbcURL);
//        dataSource.setUsername(jdbcUser);
//        dataSource.setPassword(jdbcPass);
        dataSource.setUrl("jdbc:mysql://localhost:3306/person");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        Properties properties = new Properties();
        properties.put("minPoolSize", "1");
        properties.put("maxPoolSize", "100");
        properties.put("breakAfterAcquireFailure", "false");
        properties.put("acquireRetryAttempts", "3");
        properties.put("idleConnectionTestPeriod", "300");
        properties.put("testConnectionOnCheckout", "true");
        dataSource.setConnectionProperties(properties);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource());
        try {
            return template;
        } finally {
            LOG.info("jdbcTemplate initialized");
        }
    }


    @Bean
    @Autowired
    public HibernateTemplate hibernateTemplate(SessionFactory s) {
        try {
            return new HibernateTemplate(s);
        } finally {
            LOG.info("hibernateTemplate initialized");
        }
    }


//    @Bean
//    @Autowired
//    public HibernateTransactionManager transactionManager(SessionFactory s) {
//        HibernateTransactionManager txManager = new HibernateTransactionManager();
//        txManager.setSessionFactory(s);
//        return txManager;
//    }

    @Bean
    @Autowired
    public DataSourceTransactionManager dataSourceTransactionManager() {
        final DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    @Bean
    public TransactionTemplate transactionTemplate() {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setTransactionManager(dataSourceTransactionManager());
        return transactionTemplate;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    final Properties hibernateProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("jadira.usertype.autoRegisterUserTypes", "true");
        hibernateProperties.setProperty("org.hibernate.flushMode", "auto");
        hibernateProperties.setProperty("hibernate.cache.use_minimal_puts", "true");
//        hibernateProperties.setProperty("hibernate.cache.use_query_cache", "false");
//        hibernateProperties.setProperty("hibernate.cache.hazelcast.use_native_client", "false");
//        hibernateProperties.setProperty("hibernate.cache.use_second_level_cache", "true");
//        hibernateProperties.setProperty("hibernate.cache.provider_class", "com.hazelcast.cache.HazelcastCachingProvider");
//        hibernateProperties.setProperty("hibernate.cache.region.factory_class", "com.hazelcast.hibernate.HazelcastCacheRegionFactory");

        return hibernateProperties;
    }

}
