package hu.nye.progtech;

import java.util.Comparator;

public class MoneyComparator implements Comparator<Money> {

    private BankService bank;

    public MoneyComparator(BankService bank) {
        this.bank = bank;
    }

    @Override
    public int compare(Money money1, Money money2) {
        final Money convertedMoney = bank.convertMoney(money2, money1.getCurrency());
        return money1.compareTo(money2);
    }
}