package hu.nye.progtech;

import java.util.Currency;
import java.util.Optional;

public interface BankService {
    Money convertMoney(Money moneyToConvert, Currency toCurrency);


}
