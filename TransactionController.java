package com.fintrack;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "*")
public class TransactionController {
    private final TransactionRepository repository;

    public TransactionController(TransactionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Transaction> all() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction create(@RequestBody Transaction transaction) {
        if (transaction.getTitle() == null || transaction.getTitle().isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Title is required");
        if (transaction.getCategory() == null || transaction.getCategory().isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category is required");
        if (transaction.getType() == null ||
            !(transaction.getType().equalsIgnoreCase("INCOME") || transaction.getType().equalsIgnoreCase("EXPENSE")))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Type must be INCOME or EXPENSE");
        if (transaction.getAmount() <= 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Amount must be greater than zero");
        if (transaction.getTransactionDate() == null)
            transaction.setTransactionDate(LocalDate.now());
        transaction.setType(transaction.getType().toUpperCase());
        return repository.save(transaction);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (!repository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found");
        repository.deleteById(id);
    }
}
