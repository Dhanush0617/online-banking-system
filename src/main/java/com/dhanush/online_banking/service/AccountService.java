package com.dhanush.online_banking.service;

import com.dhanush.online_banking.model.Account;
import com.dhanush.online_banking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Create new account
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    // Get all accounts
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Get account by ID
    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
            .orElseThrow(() ->
                new RuntimeException("Account not found: " + id));
    }

    // Deposit money
    public Account deposit(Long id, double amount) {
        Account account = getAccountById(id);
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }

    // Withdraw money
    public Account withdraw(Long id, double amount) {
        Account account = getAccountById(id);
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }

    // Transfer money between two accounts
    public String transfer(Long fromId, Long toId, double amount) {
        withdraw(fromId, amount);
        deposit(toId, amount);
        return "Transfer of Rs." + amount + " successful";
    }

    // Delete account
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}