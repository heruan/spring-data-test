package it.axians.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(repositoryFactoryBeanClass = MyCustomJpaRepositoryFactoryBean.class)
public class MyCustomJpaConfiguration {
}
