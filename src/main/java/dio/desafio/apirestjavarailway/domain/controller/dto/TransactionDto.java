package dio.desafio.apirestjavarailway.domain.controller.dto;

import dio.desafio.apirestjavarailway.domain.model.Transaction;

import java.time.LocalDate;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public record TransactionDto(
        Long id,
        String number,
        String cardUser,
        LocalDate transactionDate,
        String transactionType,
        String status,
        List<ItemDto> itens
)

{
    public TransactionDto(Transaction model) {
        this(
            model.getId(),
            model.getNumber(),
            model.getCardUser(),
            model.getTransactionDate(),
            model.getTransactionType(),
            model.getStatus(),
            ofNullable(model.getItens()).orElse(emptyList()).stream().map(ItemDto::new).collect(toList())
        );
    }

    public Transaction toModel() {
        Transaction model = new Transaction();
        model.setId(this.id);
        model.setNumber(this.number);
        model.setCardUser(this.cardUser);
        model.setTransactionDate(this.transactionDate);
        model.setTransactionType(this.transactionType);
        model.setStatus(this.status);
        model.setItens(ofNullable(this.itens).orElse(emptyList()).stream().map(ItemDto::toModel).collect(toList()));
        return model;
    }
}
