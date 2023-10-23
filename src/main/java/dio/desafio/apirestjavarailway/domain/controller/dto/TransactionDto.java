package dio.desafio.apirestjavarailway.domain.controller.dto;

import dio.desafio.apirestjavarailway.domain.model.Transaction;

import java.time.LocalDate;

public record TransactionDto(
        Long id,
        String number,
        String cardUser,
        LocalDate transactionDate,
        String transactionType,
        String status
)
{
    public TransactionDto(Transaction model) {
        this(
            model.getId(),
            model.getNumber(),
            model.getCardUser(),
            model.getTransactionDate(),
            model.getTransactionType(),
            model.getStatus()
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
        return model;
    }

}
