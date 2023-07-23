package br.com.cpsoneghett.behavioral.strategy;

import br.com.cpsoneghett.creational.singleton.RandomWrapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class LoadBalancingStrategyTests {

    @Test
    void testRoundRobinStrategy() {
        LoadBalancer lb = new LoadBalancer(new RoundRobinStrategy());
        lb.addResource("url1");
        lb.addResource("url2");
        lb.addResource("url3");

        assertEquals("url1", lb.next());
        assertEquals("url2", lb.next());
        assertEquals("url3", lb.next());
        assertEquals("url1", lb.next());
    }

    @Test
    void testRandomStrategy() {

        RandomWrapper randomWrapper = Mockito.mock(RandomWrapper.class);
        RandomStrategy randomStrategy = new RandomStrategy();

        randomStrategy.setRandom(randomWrapper);

        LoadBalancer lb = new LoadBalancer(randomStrategy);
        lb.addResource("url1");
        lb.addResource("url2");
        lb.addResource("url3");

        when(randomWrapper.nextInt(lb.getResources().size()))
                .thenReturn(0)
                .thenReturn(1)
                .thenReturn(2);

        assertEquals("url1", lb.next());
        assertEquals("url2", lb.next());
        assertEquals("url3", lb.next());

    }
}
