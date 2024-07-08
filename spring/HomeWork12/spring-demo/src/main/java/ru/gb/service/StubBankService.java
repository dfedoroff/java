package ru.gb.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StubBankService implements BankService {
  @Override
  public void goToCentralBank() {
    log.info("вызов в ЦБ произошел");
  }
}
