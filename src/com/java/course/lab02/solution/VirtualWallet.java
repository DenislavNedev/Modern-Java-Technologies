package com.java.course.lab02.solution;

import com.java.course.lab02.solution.card.Card;
import com.java.course.lab02.solution.payment.PaymentInfo;

import java.util.HashMap;
import java.util.Map;

public class VirtualWallet implements VirtualWalletAPI {
    private Map<String, Card> cards;
    private int totalNumberOfCards;

    VirtualWallet() {
        this.cards = new HashMap<>();
        this.totalNumberOfCards = 0;
    }

    @Override
    public boolean registerCard(Card card) {
        if (!isCardValid(card) || isCardAlreadyRegistered(card) || getTotalNumberOfCards() == 5) {
            return false;
        }
        this.totalNumberOfCards++;
        cards.put(card.getName(), card);
        return true;
    }

    @Override
    public boolean executePayment(Card card, PaymentInfo paymentInfo) {
        if (!isCardValid(card) || !isPaymentInfoValid(paymentInfo)) {
            return false;
        }
        Card currentCard = getCardByName(card.getName());
        if (currentCard == null) {
            return false;
        }
        return currentCard.executePayment(paymentInfo.getCost());
    }

    @Override
    public boolean feed(Card card, double amount) {
        if (!isCardValid(card) || isAmountNegative(amount) || !isCardAlreadyRegistered(card)) {
            return false;
        }
        cards.get(card.getName()).increaseAmount(amount);
        return true;
    }

    @Override
    public Card getCardByName(String name) {
        if (cards.containsKey(name)) {
            return cards.get(name);
        }
        return null;
    }

    @Override
    public int getTotalNumberOfCards() {
        return this.totalNumberOfCards;
    }

    private boolean isCardAlreadyRegistered(Card card) {
        return cards.containsKey(card.getName());
    }

    private boolean isCardValid(Card card) {
        return card != null && card.getName() != null;
    }

    private boolean isAmountNegative(double amount) {
        return amount < 0;
    }

    private boolean isPaymentInfoValid(PaymentInfo paymentInfo) {
        return paymentInfo != null && paymentInfo.getLocation() != null
                && paymentInfo.getReason() != null && !(paymentInfo.getCost() < 0);
    }

}
