package ru.gb.chain;

import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component("accountUnderArrestValidator")
public class AccountUnderArrestValidator implements DebitValidator {

  @Override
  public void validate(Account account, BigInteger amount) throws DebitValidationException {
    // проверяем, что деньги клиента не арестованы
    throw new DebitValidationException("арестованы деньги");
  }

  @Override
  public boolean isApplicable(Account account) {
    return !account.isVip();
  }
}