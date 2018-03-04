package it.axians.spring;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.transaction.PlatformTransactionManager;

public class MyCustomJpaRepositoryFactoryBean<R extends JpaRepository<T, I>, T, I>
        extends JpaRepositoryFactoryBean<R, T, I> {

    private PlatformTransactionManager transactionManager;

    public MyCustomJpaRepositoryFactoryBean(Class<? extends R> repositoryInterface,
            PlatformTransactionManager transactionManager) {
        super(repositoryInterface);
        this.transactionManager = transactionManager;
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(
            EntityManager entityManager) {
        return new MyCustomRepositoryFactory<>(entityManager,
                this.transactionManager);
    }

    private static class MyCustomRepositoryFactory<T>
            extends JpaRepositoryFactory {

        private PlatformTransactionManager transactionManager;

        MyCustomRepositoryFactory(EntityManager entityManager,
                PlatformTransactionManager transactionManager) {
            super(entityManager);
            this.transactionManager = transactionManager;
        }

        @Override
        @SuppressWarnings("unchecked")
        protected SimpleJpaRepository<?, ?> getTargetRepository(
                RepositoryInformation information,
                EntityManager entityManager) {

            JpaEntityInformation<T, ?> entityInformation = (JpaEntityInformation<T, ?>) this
                    .getEntityInformation(information.getDomainType());

            return new MyCustomJpaRepositoryImpl<>(entityInformation,
                    entityManager, this.transactionManager);
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return MyCustomJpaRepositoryImpl.class;
        }

    }

}
