package org.ageev.springrestapi.SpringRestApiApplication.service;

import org.ageev.springrestapi.SpringRestApiApplication.dto.BalanceDto;
import org.ageev.springrestapi.SpringRestApiApplication.dto.TransactionDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BalanceServiceImpl implements BalanceService {
    
    private final TransactionService transactionService;
    
    public BalanceServiceImpl(TransactionService transactionService) {this.transactionService = transactionService;}
    
    @Override
    public BalanceDto getBalance() {
        double sum = transactionService.getAll()
                .stream()
                .mapToDouble(TransactionDto::getFlow)
                .sum();
        return new BalanceDto(LocalDate.now(), sum);
    }
    
    public BalanceDto getBalanceByDate(LocalDate date) {
        double sum = transactionService.getAll()
                .stream()
                .filter(entity -> !entity.getDate().isAfter(date))
                .mapToDouble(TransactionDto::getFlow)
                .sum();
        return new BalanceDto(date, sum);
    }
}
