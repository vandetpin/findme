package com.findme.bootstrap;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.findme.bootstrap.rest.RestJsonExceptionResolver;
import com.findme.utils.Formatter;

 
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.findme.controller", "com.findme.domain",
			"com.findme.dao", "com.findme.service" })
@EnableJpaRepositories("com.findme.dao")
@PropertySource("classpath:application.properties")
@Import({ SecurityConfig.class })
@ImportResource("classpath:jms-client-config.xml")
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableAsync
public class MvcConfig extends WebMvcConfigurerAdapter {
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
 
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_HIBERNATE_CONNECTION_POOL_SIZE="connection.pool.size";
    private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO="hibernate.hbm2ddl.auto";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
    
    @Resource
    private Environment env;
 
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(getProperty(PROPERTY_NAME_DATABASE_DRIVER));
        dataSource.setUrl(getProperty(PROPERTY_NAME_DATABASE_URL));
        dataSource.setUsername(getProperty(PROPERTY_NAME_DATABASE_USERNAME));
        dataSource.setPassword(getProperty(PROPERTY_NAME_DATABASE_PASSWORD));
 
        return dataSource;
    }
 
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, 
                                                                Environment env) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(hibernateProperties());
        em.setPackagesToScan(getProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
 
        return em;
    }
 
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, getProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, getProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
        properties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, getProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));
        properties.put(PROPERTY_NAME_HIBERNATE_CONNECTION_POOL_SIZE, getProperty(PROPERTY_NAME_HIBERNATE_CONNECTION_POOL_SIZE));
        
        return properties;
    }
    
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        
        return transactionManager;
    }
    
    // Resolves views selected for rendering by @Controllers to .jsp resources 
	// in the /WEB-INF/views directory
	@Bean
    public InternalResourceViewResolver htmlViewResolver() {
        final InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        
        return bean;
    }
	
	// -------------- Serving Resources ----------------------
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        registry.addResourceHandler("/images/**").addResourceLocations(getProperty("resources.location.absolute"));
    }

    //-- Lets us find resources (.html etc) through the default servlet 
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    // ---------file upload -----------
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver rslv = new CommonsMultipartResolver();
        rslv.setMaxUploadSize(Long.parseLong(getProperty("resources.maxUploadSize")));
        return rslv;
    }
	
	private String getProperty(String arg ) {
		return env.getRequiredProperty(arg);
	}
	
	// -------------- Message Converters ----------------------

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        SkipNullObjectMapper skipNullMapper = new SkipNullObjectMapper();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        skipNullMapper.setDateFormat(formatter);

        skipNullMapper.init();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(skipNullMapper);
        converters.add(converter);

    }
    
    /** Register RestJsonExceptionResolver */
	@Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add(restJsonExceptionResolver());
    }

	@Bean
    public RestJsonExceptionResolver restJsonExceptionResolver() {
	    RestJsonExceptionResolver bean = new RestJsonExceptionResolver();
	    // map any spring and servlet exception class here
	    RestJsonExceptionResolver.registerExceptionWithHTTPCode(org.springframework.beans.TypeMismatchException.class, 400);
        RestJsonExceptionResolver.registerExceptionWithHTTPCode(MissingServletRequestParameterException.class, 400);
        RestJsonExceptionResolver.registerExceptionWithHTTPCode(MethodArgumentNotValidException.class, 400);
        RestJsonExceptionResolver.registerExceptionWithHTTPCode(ServletRequestBindingException.class, 400);
        bean.setOrder(100);
	    return bean;
    }
	
}