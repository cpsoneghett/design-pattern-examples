package br.com.cpsoneghett.behavioral.strategy;

import java.util.List;

public class RoundRobinStrategy implements LoadBalancingStrategy {

    private int currentIndex = 0;

    @Override
    public String getNextResource(List<String> resources) {
        if (resources.isEmpty()) {
            return null;
        }

        String resource = resources.get(currentIndex);
        currentIndex = (currentIndex + 1) % resources.size();
        return resource;
    }
}
