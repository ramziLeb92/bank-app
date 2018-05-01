package com.bank.impl;

import com.bank.Account;
import com.bank.Client;
import com.bank.Currency;

public class AccountImpl implements Account {
    private final String id;
    private final Client client;

    private double balance;
    private final Currency currency;

    public AccountImpl(String id,
                       Client client,
                       double initBalance,
                       Currency initCurrency) {
        this.id = id;
        this.client = client;
        this.balance = initBalance;
        this.currency = initCurrency;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Client getClient() {
        return client;
    }

    @Override
    public double getBalanceMoney() {
        return balance;
    }

    @Override
    public Currency getBalanceCurrency() {
        return currency;
    }

    @Override
    public void withdraw(double moneyToWithdraw, Currency withdrawCurrency) {
        if (withdrawCurrency != currency) {
            throw new IllegalStateException("For Account " + id +
                    " you have to withdraw in currency: " + currency);
        }
        if (isWithDrawNegativeResult(moneyToWithdraw))
            throw new IllegalStateException("For Account " + id + " " + "your balance will be negative. You are not authorized");
        balance = balance - moneyToWithdraw;
    }

    boolean isWithDrawNegativeResult(double moneyToWithdraw) {
        return this.balance - moneyToWithdraw < 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountImpl account = (AccountImpl) o;
        return id.equals(account.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Account of " + client.getName() + " with id " + id +" has a current balance of " + balance + " " + currency.name();
    }
}
