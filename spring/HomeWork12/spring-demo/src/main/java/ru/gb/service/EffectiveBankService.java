package ru.gb.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EffectiveBankService implements BankService {
  @Override
  public void goToCentralBank() {
    log.warn("ВЫЗОВ В ЦБ");
  }
}
