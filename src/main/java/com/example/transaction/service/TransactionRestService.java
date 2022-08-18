package com.example.transaction.service;

import com.example.transaction.repository.TransactionRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionRestService {
    @Autowired
    private TransactionRestRepository transactionRestRepository;
}
