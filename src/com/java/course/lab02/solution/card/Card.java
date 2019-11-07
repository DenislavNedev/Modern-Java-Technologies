package com.java.course.lab02.solution.card;

public abstract class Card {

    private String name;
    private double amount;

    public Card(String name) {
        this.name = name;
        this.amount = 0;
    }

    public abstract boolean executePayment(double cost);

    public String getName() {
        return this.name;
    }

    public double getAmount() {
        return this.amount;
    }

    public void increaseAmount(double supply) {
        this.amount += supply;
    }

    protected boolean areThereEnoughMoney(double paymentAmount) {
        if (this.amount < paymentAmount) {
            return false;
        }
        return true;
    }

    protected void decreaseAmount(double cost) {
        this.amount -= cost;
    }
}
