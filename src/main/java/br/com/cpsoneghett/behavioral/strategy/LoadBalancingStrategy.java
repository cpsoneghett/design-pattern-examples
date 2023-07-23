package br.com.cpsoneghett.behavioral.strategy;

import java.util.List;

public interface LoadBalancingStrategy {

    String getNextResource(List<String> resources);
}
