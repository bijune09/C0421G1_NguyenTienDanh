package com.codegym.model.bean;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Book {
    @Id
    private int id;
    private String name;
    private String content;
    private int amount;

    @OneToMany(mappedBy = "book")
    private Set<BorrowCode> borrowCode;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Set<BorrowCode> getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(Set<BorrowCode> borrowCode) {
        this.borrowCode = borrowCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
