package ru.gb.chain;

import java.math.BigInteger;

public class Account {

  private BigInteger amount;
  private boolean vip;

  public BigInteger getAmount() {
    return amount;
  }

  public void setAmount(BigInteger amount) {
    this.amount = amount;
  }

  public boolean isVip() {
    return vip;
  }

  public void setVip(boolean vip) {
    this.vip = vip;
  }
}