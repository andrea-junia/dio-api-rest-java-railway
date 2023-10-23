package dio.desafio.apirestjavarailway.domain.controller;

import dio.desafio.apirestjavarailway.domain.model.Transaction;
import dio.desafio.apirestjavarailway.domain.model.User;
import dio.desafio.apirestjavarailway.domain.services.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin
@RestController
@RequestMapping("/transaction")
@Tag(name = "Transaction Controller", description = "RESTful API for managing itens.")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable Long id){
        var transaction = transactionService.findById(id);
        return ResponseEntity.ok(transaction);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Transaction> create(@RequestBody Transaction transactionToCreate){
        var transactionCreated = transactionService.create(transactionToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(transactionCreated.getId())
                .toUri();
        //return ResponseEntity.created(location).body(transactionCreated);
        return ResponseEntity.created(location).body(transactionCreated);
    }
}
