package org.ageev.springrestapi.SpringRestApiApplication.controller;

import org.ageev.springrestapi.SpringRestApiApplication.dto.TransactionDto;
import org.ageev.springrestapi.SpringRestApiApplication.service.TransactionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    
    private final TransactionService service;
    
    public TransactionController(TransactionService service) {this.service = service;}
    
    @GetMapping
    public List<TransactionDto> getList() {return service.getAll();}
    
    @GetMapping(params = {"start", "end"})
    public List<TransactionDto> getByPeriod(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate start,
                                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate end) {
        return service.getByPeriod(start, end);
    }
    
    @GetMapping("/incomes")
    public List<TransactionDto> getIncomes() {return service.getIncomes();}
    
    @GetMapping("/expenses")
    public List<TransactionDto> getExpenses() {return service.getExpenses();}
    
    @GetMapping("/{id}")
    public TransactionDto getTransaction(@PathVariable long id) {return service.findById(id);}
    
    @PostMapping
    public void addTransaction(@RequestBody TransactionDto dto) {service.save(dto);}
    
    @PutMapping("/{id}")
    public void updateTransaction(@PathVariable long id, @RequestBody TransactionDto dto) {
        dto.setId(id);
        service.save(dto);
    }
    
    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable long id) {
        service.deleteById(id);
    }
}
