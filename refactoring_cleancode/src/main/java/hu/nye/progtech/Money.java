package hu.nye.progtech;

import java.util.Currency;

public class Money {
    public double value;
    public Currency currency;

    public Money(double value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    /**
     * CRTL + ALT + M ---> create method
     */
    public Money add(Money moneyToAdd) {
        moneyToAdd = convertMoney(moneyToAdd);
        if (moneyToAdd == null) return null;
        this.value += moneyToAdd.getValue(); // Add value of the parameter to this.val
        return this;
    }

    private Money convertMoney(Money moneyToAdd) {
        if (!this.currency.equals(moneyToAdd.getCurrency())) { // If the two currency does not match
            if (this.getCurrency().equals(Currency.getInstance("USD")) && moneyToAdd.getCurrency().equals(Currency.getInstance("HUF"))) {
                moneyToAdd = new Money(moneyToAdd.value * 0.0034, Currency.getInstance("USD"));
            } else if (this.getCurrency().equals(Currency.getInstance("HUF")) && moneyToAdd.getCurrency().equals(Currency.getInstance("USD"))) {
                moneyToAdd = new Money(moneyToAdd.value * 249.3, Currency.getInstance("HUF"));
            } else {
                return null;
            }
        }
        return moneyToAdd;
    }

    public Integer compareTo(Money moneyToCompare) {
        moneyToCompare = convertMoney(moneyToCompare);
        if (moneyToCompare == null) return null;
        return Double.compare(this.getValue(), moneyToCompare.getValue());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Money{");
        sb.append("value=").append(value);
        sb.append(", currency=").append(currency);
        sb.append('}');
        return sb.toString();
    }
}