package it.axians.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(repositoryFactoryBeanClass = MyCustomJpaRepositoryFactoryBean.class)
public class MyCustomJpaConfiguration {
}
