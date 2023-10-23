package dio.desafio.apirestjavarailway.domain.services.impl;

import dio.desafio.apirestjavarailway.domain.model.Transaction;
import dio.desafio.apirestjavarailway.domain.model.User;
import dio.desafio.apirestjavarailway.domain.repository.TransactionRepository;
import dio.desafio.apirestjavarailway.domain.services.TransactionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TransactionServiceImpl implements TransactionService {

    private static final Long UNCHANGEABLE_USER_ID = 1L;

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Transactional(readOnly = true)
    public List<Transaction> findAll() {
        return this.transactionRepository.findAll();
    }

    @Override
    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Transaction create(Transaction transactionToCreate) {
        if( transactionRepository.existsByNumber( transactionToCreate.getNumber() ) ){
            throw new IllegalArgumentException("This Transaction number already exists");
        }

        return transactionRepository.save(transactionToCreate);
    }

    @Override
    public Transaction update(Long aLong, Transaction entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
