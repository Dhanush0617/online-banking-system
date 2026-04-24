package com.dhanush.online_banking.controller;

import com.dhanush.online_banking.model.Account;
import com.dhanush.online_banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // POST http://localhost:8081/api/accounts
    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    // GET http://localhost:8081/api/accounts
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    // GET http://localhost:8081/api/accounts/1
    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    // PUT http://localhost:8081/api/accounts/1/deposit
    @PutMapping("/{id}/deposit")
    public Account deposit(@PathVariable Long id,
                           @RequestBody Map<String, Double> body) {
        return accountService.deposit(id, body.get("amount"));
    }

    // PUT http://localhost:8081/api/accounts/1/withdraw
    @PutMapping("/{id}/withdraw")
    public Account withdraw(@PathVariable Long id,
                            @RequestBody Map<String, Double> body) {
        return accountService.withdraw(id, body.get("amount"));
    }

    // POST http://localhost:8081/api/accounts/transfer
    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(
            @RequestBody Map<String, Object> body) {
        Long fromId = Long.valueOf(body.get("fromId").toString());
        Long toId   = Long.valueOf(body.get("toId").toString());
        double amt  = Double.parseDouble(body.get("amount").toString());
        return ResponseEntity.ok(
            accountService.transfer(fromId, toId, amt));
    }

    // DELETE http://localhost:8081/api/accounts/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
}