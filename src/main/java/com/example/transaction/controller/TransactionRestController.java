package com.example.transaction.controller;

import com.example.transaction.model.Transaction;
import com.example.transaction.service.TransactionRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class TransactionRestController {
    @Autowired
    private TransactionRestService transactionRestService;
@PostMapping("/addTransaction")
    public int addTransaction(@RequestBody Transaction transaction){
    return transactionRestService.addTransaction(transaction);
}
@GetMapping("/deleteTransaction/{id}")
    public int deleteTransaction(@PathVariable("id") long id){
    return transactionRestService.deleteTransaction(id);
}

@GetMapping("/readTransaction")
    public List<Transaction> readTransaction(){
    return transactionRestService.readTransaction();
}

@GetMapping("/modifyTransactionName/{id}/{name}")
    public int modifyTransactionName(@PathVariable("id") long id, @PathVariable ("name") String name){
    return modifyTransactionName(id, name);
}

    @GetMapping("/modifyTransactionDescription/{id}/{description}")
    public int modifyTransactionDescription(@PathVariable("id") long id, @PathVariable ("description") String description){
        return modifyTransactionDescription(id, description);
    }
    @GetMapping("/modifyTransactionAmount/{id}/{amount}")
    public int modifyTransactionAmount(@PathVariable("id") long id, @PathVariable ("amount") double amount){
        return modifyTransactionAmount(id, amount);
    }
    @GetMapping("/modifyTransactionDate/{id}/{date}")
    public int modifyTransactionDate(@PathVariable("id") long id, @PathVariable ("date")LocalDate date){
        return modifyTransactionDate(id, date);
    }

}
