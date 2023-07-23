package br.com.cpsoneghett.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancer {

    private final List<String> resources;
    private final LoadBalancingStrategy strategy;

    public LoadBalancer(LoadBalancingStrategy strategy) {
        this.resources = new ArrayList<>();
        this.strategy = strategy;
    }

    public void addResource(String resource) {
        resources.add(resource);
    }

    public String next() {
        return strategy.getNextResource(resources);
    }

    public List<String> getResources() {
        return resources;
    }
}
