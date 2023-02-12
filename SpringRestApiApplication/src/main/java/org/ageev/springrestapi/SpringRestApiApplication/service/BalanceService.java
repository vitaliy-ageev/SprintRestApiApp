package org.ageev.springrestapi.SpringRestApiApplication.service;

import org.ageev.springrestapi.SpringRestApiApplication.dto.BalanceDto;

import java.time.LocalDate;

public interface BalanceService {
    BalanceDto getBalance();
    
    BalanceDto getBalanceByDate(LocalDate date);
}
