package ru.gb.chain;

public class DebitValidationException extends Exception {

  public DebitValidationException() {
  }

  public DebitValidationException(String message) {
    super(message);
  }
}
