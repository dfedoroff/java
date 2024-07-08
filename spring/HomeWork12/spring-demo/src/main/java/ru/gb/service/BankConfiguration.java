package ru.gb.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankConfiguration {

  @Bean
  @ConditionalOnProperty("application.bank.url")
  BankService bankService() {
    return new EffectiveBankService();
  }

  @Bean
  @ConditionalOnMissingBean
  BankService stubBankService() {
    return new StubBankService();
  }

}
