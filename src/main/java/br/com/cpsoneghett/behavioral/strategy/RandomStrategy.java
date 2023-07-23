package br.com.cpsoneghett.behavioral.strategy;

import br.com.cpsoneghett.creational.singleton.RandomWrapper;

import java.util.List;

public class RandomStrategy implements LoadBalancingStrategy {

    private RandomWrapper random;

    public RandomStrategy() {
        this.random = new RandomWrapper();
    }

    @Override
    public String getNextResource(List<String> resources) {
        if (resources.isEmpty())
            return null;

        int randomIndex = this.random.nextInt(resources.size());
        return resources.get(randomIndex);
    }

    public void setRandom(RandomWrapper random) {
        this.random = random;
    }

}
