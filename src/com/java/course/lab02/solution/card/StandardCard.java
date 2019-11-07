package com.java.course.lab02.solution.card;

public class StandardCard extends Card {
    public StandardCard(String name) {
        super(name);
    }

    @Override
    public boolean executePayment(double cost) {
        if (!areThereEnoughMoney(cost)) {
            return false;
        }
        decreaseAmount(cost);
        return true;
    }
}