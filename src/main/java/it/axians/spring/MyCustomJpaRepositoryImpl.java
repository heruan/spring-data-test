package it.axians.spring;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.PlatformTransactionManager;

public class MyCustomJpaRepositoryImpl<T, I> extends SimpleJpaRepository<T, I> {

    private final PlatformTransactionManager transactionManager;

    public MyCustomJpaRepositoryImpl(
            JpaEntityInformation<T, ?> entityInformation,
            EntityManager entityManager,
            PlatformTransactionManager transactionManager) {
        super(entityInformation, entityManager);
        this.transactionManager = transactionManager;
    }

    // Custom methods which need PlatformTransactionManager

}
