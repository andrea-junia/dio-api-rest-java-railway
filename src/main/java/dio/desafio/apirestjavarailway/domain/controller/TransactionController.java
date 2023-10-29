package dio.desafio.apirestjavarailway.domain.controller;

import dio.desafio.apirestjavarailway.domain.controller.dto.TransactionDto;
import dio.desafio.apirestjavarailway.domain.model.Transaction;
import dio.desafio.apirestjavarailway.domain.services.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @PostMapping
    @Operation(summary = "Create a new transaction", description = "Create a new transaction and return the created user's data")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Transaction created successfully"),
    @ApiResponse(responseCode = "422", description = "Invalid transaction data provided")
    })
    public ResponseEntity<TransactionDto> create(@RequestBody TransactionDto transactionDto) {
        var transaction = transactionService.create(transactionDto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(transaction.getId())
                .toUri();
        return ResponseEntity.created(location).body(new TransactionDto(transaction));
    }
}
