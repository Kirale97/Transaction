package com.example.transaction.service;

import com.example.transaction.model.Transaction;
import com.example.transaction.repository.TransactionRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionRestService {
    @Autowired
    private TransactionRestRepository transactionRestRepository;
    public int addTransaction(Transaction transaction){
        return transactionRestRepository.addTransaction(transaction);

    }
    public int deleteTransaction(long id){
        return transactionRestRepository.deleteTransaction(id);
    }

    public List<Transaction> readTransaction(){
        return transactionRestRepository.readTransaction();
    }
    public int modifyTransactionName(long id, String name){
        return transactionRestRepository.modifyTransactionName(id, name);
    }
    public int modifyTransactionDescrption(long id, String description){
        return transactionRestRepository.modifyTransactionName(id, description);
    }
    public int modifyTransactionAmount(long id, double amount ){
        return transactionRestRepository.modifyTransactionAmount(id, amount);
    }
    public int modifyTransactionDate(long id, LocalDate date){
        return transactionRestRepository.modifyTransactionDate(id, date);
    }

}
