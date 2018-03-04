package it.axians.spring.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import it.axians.spring.MyCustomJpaConfiguration;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = MyCustomJpaConfiguration.class)
public class MyEntityRepositoryTest {

    @Test
    public void sampleTest() {
        assertTrue(true);
    }

}
