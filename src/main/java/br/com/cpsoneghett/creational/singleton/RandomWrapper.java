package br.com.cpsoneghett.creational.singleton;

import java.util.Random;

public class RandomWrapper {

    private final Random random;
    private static RandomWrapper instance;

    public RandomWrapper() {
        this.random = new Random();
    }

    public static RandomWrapper getInstance() {
        if(instance == null) {
            synchronized (RandomWrapper.class) {
                if(instance == null)
                    instance = new RandomWrapper();
            }
        }
        return instance;
    }

    public int nextInt(int bound) {
        return random.nextInt(bound);
    }
}
