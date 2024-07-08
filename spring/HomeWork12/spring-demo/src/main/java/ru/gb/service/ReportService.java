package ru.gb.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReportService {

  private final BankService bankService;

  public void generateReport() {
    log.info("отчет создан");
    bankService.goToCentralBank();
  }

}
