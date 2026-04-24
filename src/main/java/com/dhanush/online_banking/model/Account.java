package com.dhanush.online_banking.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String holderName;

    @Column(nullable = false, unique = true)
    private String accountNumber;

    private double balance;
    private String accountType;

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Account() {}

    public Account(String holderName, String accountNumber,
                   double balance, String accountType) {
        this.holderName = holderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    public Long getId() { return id; }
    public String getHolderName() { return holderName; }
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public String getAccountType() { return accountType; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setHolderName(String h) { this.holderName = h; }
    public void setAccountNumber(String n) { this.accountNumber = n; }
    public void setBalance(double balance) { this.balance = balance; }
    public void setAccountType(String t) { this.accountType = t; }
}
