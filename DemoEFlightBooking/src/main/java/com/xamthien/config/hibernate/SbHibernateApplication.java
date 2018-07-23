package com.xamthien.config.hibernate;

import java.util.Properties;

import javax.sql.DataSource;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
 
@SpringBootApplication
 
@EnableAutoConfiguration(exclude = { //  
        DataSourceAutoConfiguration.class, //
        DataSourceTransactionManagerAutoConfiguration.class, //
        HibernateJpaAutoConfiguration.class })
 
public class SbHibernateApplication {
	@Autowired
    private Environment env;
     
     
    public static void main(String[] args) {
        SpringApplication.run(SbHibernateApplication.class, args);
    }
     
     
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
 
        // See: application.properties
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
 
        System.out.println("## getDataSource: " + dataSource);
 
        return dataSource;
    }
 
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
        Properties properties = new Properties();
 
        // See: application.properties  
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
        properties.put("current_session_context_class",env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
        properties.put("hibernate.enable_lazy_load_no_trans", env.getProperty("hibernate.enable_lazy_load_no_trans"));
 
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
 
        // Package contain entity classes
        factoryBean.setPackagesToScan(new String[] { "" });
        factoryBean.setDataSource(dataSource);
        factoryBean.setHibernateProperties(properties);
        factoryBean.afterPropertiesSet();
        //
        SessionFactory sf = factoryBean.getObject();
        System.out.println("## getSessionFactory: " + sf);
        return sf;
    }
 
    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
 
        return transactionManager;
    }
    @Bean
    @Description("Thymeleaf template resolver serving HTML 5")
    public ServletContextTemplateResolver templateResolver() {
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
//        templateResolver.setPrefix("/WEB-INF/html/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("LEGACYHTML5");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setCacheable(false);

        return templateResolver;
    }
//
//    @Bean
//    @Description("Thymeleaf template engine with Spring integration")
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//
//        return templateEngine;
//    }
//
    @Bean
    @Description("Thymeleaf view resolver")
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        //viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setContentType("text/html;charset=UTF-8");
        viewResolver.setCharacterEncoding("utf-8");

        return viewResolver;
    }
}
