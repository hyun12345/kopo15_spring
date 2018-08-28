package kr.co.uclick.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ignite.cache.hibernate.HibernateRegionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ImportResource(locations = "classpath:applicationContext-ignite.xml")
@ComponentScans({ @ComponentScan({ "kr.co.uclick.service" }) })
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
//오류시 rollback, 성공시 commit 등 스프링이 transaction 자동 처리
@EnableSpringConfigured
@EnableCaching
//캐시 사용 가능하도록 입력(설정)
@EnableJpaRepositories(basePackages = "kr.co.uclick.repository")
public class SpringConfiguration {

	@Bean
	@Primary
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		dataSource.setUrl("jdbc:mariadb://127.0.0.1:3306/kopo15_uclick");
		//mariadb 사용하므로 h2였던 부분을 mariadb로 수정 & 생성한 db에 연결
		dataSource.setUsername("root");
		dataSource.setPassword("dkgus12");
		return dataSource;
	}
	
//	dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//	dataSource.setUrl("jdbc:mysql://localhost:3306/kopo15_uclick?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul");
//	//mariadb 사용하므로 h2였던 부분을 mariadb로 수정 & 생성한 db에 연결
//	dataSource.setUsername("root");
//	dataSource.setPassword("dkgus12");
	
	//mariadb 사용자와 비밀번호 입력

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "kr.co.uclick.entity" });
		sessionFactory.setHibernateProperties(additionalProperties());
		
		return sessionFactory;
	}
	
	@Bean
	@DependsOn("igniteSystem")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "kr.co.uclick.entity" });
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}

	@Bean
	@Primary
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
		//PersistenceExceptionTranslationPostProcessor : repositroy 에러시 처리 어쩌고..
	}

	public Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
		//create-drop 설정시 application 종료시 drop하므로 update로 재설정		
		properties.setProperty(AvailableSettings.FORMAT_SQL, Boolean.TRUE.toString());
		properties.setProperty(AvailableSettings.SHOW_SQL, Boolean.TRUE.toString());
		properties.setProperty(AvailableSettings.DIALECT, MySQL5Dialect.class.getName());

		properties.setProperty(AvailableSettings.STATEMENT_BATCH_SIZE, "1000");

		properties.setProperty(AvailableSettings.USE_SECOND_LEVEL_CACHE, Boolean.TRUE.toString());
		//L2 cache 연동 설정
		properties.setProperty(AvailableSettings.USE_QUERY_CACHE, Boolean.TRUE.toString());
		//Query cache 연동 설정
		properties.setProperty(AvailableSettings.GENERATE_STATISTICS, Boolean.FALSE.toString());
		properties.setProperty(AvailableSettings.CACHE_REGION_FACTORY, HibernateRegionFactory.class.getName());

		properties.setProperty("org.apache.ignite.hibernate.ignite_instance_name", "cafe-grid");
		properties.setProperty("org.apache.ignite.hibernate.default_access_type", "NONSTRICT_READ_WRITE");

		properties.setProperty(AvailableSettings.PHYSICAL_NAMING_STRATEGY,
				CustomPhysicalNamingStrategyStandardImpl.class.getName());
		return properties;
	}

}
