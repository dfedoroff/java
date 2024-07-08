package ru.gb.chain;

import java.math.BigInteger;

public interface DebitValidator {

  void validate(Account account, BigInteger amount) throws DebitValidationException;

  boolean isApplicable(Account account);

}
