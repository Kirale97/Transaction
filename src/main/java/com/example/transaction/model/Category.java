package com.example.transaction.model;

public class Category {
    private long id;
    private String name;
    private Budget budget;

    public Category(long id, String name, Budget budget) {
        this.id = id;
        this.name = name;
        this.budget = budget;
    }
    public Category(String name, Budget budget) {
        this.name = name;
        this.budget = budget;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

}

