package com.example.transaction.model;

public class Budget {
    private long id;
    private String name;
    private Category category;
    public Budget(long id, String name, Category category){
        this.id = id;
        this.name = name;
        this.category = category;
    }
    public Budget(String name, Category category){
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }
}
