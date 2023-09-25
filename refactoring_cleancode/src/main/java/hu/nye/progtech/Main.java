package hu.nye.progtech;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;


public class Main {
    private static final Currency HUF = Currency.getInstance("HUF");
    private static final Currency USD = Currency.getInstance("USD");
    private static final Currency GBP = Currency.getInstance("GPB");
    public static void main(String[] args) {
        Money huf100 = new Money(100, HUF);
        Money huf1000 = new Money(1000, HUF);
        Money usd5 = new Money(5, USD);
        Money gbp10 = new Money(10, GBP);

        BankService bank = new StaticBank();

        Money m1 = new Money(0.2D, USD);
        Money m2 = new Money(250D, HUF);
        Money m3 = new Money(240D, HUF);
        List<Money> moneyList = new ArrayList<>();
        moneyList.add(m2);
        moneyList.add(m3);
        moneyList.add(m1);
        System.out.println(moneyList);
        moneyList.sort(new MoneyComparator(bank));
        System.out.println(moneyList);
    }
}

