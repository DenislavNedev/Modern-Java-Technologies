package com.java.course.lab02.solution.card;

public class GoldenCard extends Card {
    private static final double BONUS = 0.15;

    public GoldenCard(String name) {
        super(name);
    }

    @Override
    public boolean executePayment(double cost) {
        if (!areThereEnoughMoney(cost)) {
            return false;
        }
        decreaseAmount(cost);
        increaseAmount(cost * BONUS);
        return true;
    }
}