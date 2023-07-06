package com.brd.config;

import javax.persistence.Id;
import com.brd.dao.CustomerDao;
import com.brd.dao.CustomerMasterDao;
import com.brd.model.Customer;
import com.brd.model.CustomerMaster;
import org.hibernate.SessionFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;


import javax.sql.DataSource;
import java.util.Locale;
import java.util.Properties;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.brd" )
@EnableAspectJAutoProxy
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public CustomerDao getDao(){
        return new CustomerDao();
    }

    @Bean
    public CustomerMasterDao getMasterDao(){
        return new CustomerMasterDao();
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean mysessionfactory=new LocalSessionFactoryBean();
        mysessionfactory.setDataSource(securityDataSource());
        mysessionfactory.setAnnotatedClasses(Customer.class, CustomerMaster.class);
        Properties hibernateProperties= new Properties();
//        hibernateProperties.setProperty("hibernate.hbm2ddl.auto","create");
        hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
        hibernateProperties.setProperty("hibernate.show_sql","false");
        hibernateProperties.setProperty("flushModeName", "FLUSH_AUTO");

        mysessionfactory.setHibernateProperties(hibernateProperties);
        return mysessionfactory;
    }

    @Bean
    public HibernateTemplate getTemplate(){
        HibernateTemplate template= new HibernateTemplate();
        SessionFactory sessionFactory = getSessionFactory().getObject();
        template.setSessionFactory(sessionFactory);
        return template;
    }


    @Bean
    public HibernateTransactionManager getTransactionManager(){
        HibernateTransactionManager transactionManager= new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }

    @Bean
    public DataSource securityDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@10.1.50.198:1535/nsbt19c");
        dataSource.setUsername("training");
        dataSource.setPassword("training");
        return dataSource;
    }


    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
        resource.setBasename("messages");
        resource.setDefaultEncoding("UTF-8");
        return resource;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor);
    }

    @Bean
    public CookieLocaleResolver localeResolver(){
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(Locale.ENGLISH);
        cookieLocaleResolver.setCookieName("my-locale");
        cookieLocaleResolver.setCookieMaxAge(60);
        return cookieLocaleResolver;
    }


}