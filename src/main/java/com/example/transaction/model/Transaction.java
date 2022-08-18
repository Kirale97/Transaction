package com.example.transaction.model;

import java.time.LocalDate;




public class Transaction {
    private long id;
    private String name;
    private String description;
    private double amount;
    private LocalDate date;

    public Transaction(long id, String name, String description, double amount, LocalDate date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public Transaction(String name, String description, double amount, LocalDate date) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.id = -1;
    }
   public String write(){
        return id+"/"+name+"/"+ description+"/" + amount+"/"+date;
   }
   /*Cibo/$150/ho mangiato un gelato hihihih/25-01-2999*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }
}
