package dio.desafio.apirestjavarailway.domain.services.impl;

import dio.desafio.apirestjavarailway.domain.model.Transaction;
import dio.desafio.apirestjavarailway.domain.repository.TransactionRepository;
import dio.desafio.apirestjavarailway.domain.services.TransactionService;
import dio.desafio.apirestjavarailway.domain.services.exception.BusinessException;
import dio.desafio.apirestjavarailway.domain.services.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(readOnly = true)
    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public Transaction create(Transaction transactionToCreate) {

       //ofNullable(transactionToCreate).orElseThrow(() -> new BusinessException("Transaction to create must not be null."));
       // ofNullable(transactionToCreate.getCard()).orElseThrow(() -> new BusinessException("Transaction card must not be null."));

        this.validateChangeableId(transactionToCreate.getId(), "created");
        /*if( transactionRepository.existsByTransaction(transactionToCreate.getNumber() ) ){
            throw new IllegalArgumentException("This Transaction number already exists");
        }*/

        return transactionRepository.save(transactionToCreate);
    }

    @Override
    public Transaction update(Long aLong, Transaction entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    private void validateChangeableId(Long id, String operation) {
        if (UNCHANGEABLE_USER_ID.equals(id)) {
            throw new BusinessException("User with ID %d can not be %s.".formatted(UNCHANGEABLE_USER_ID, operation));
        }
    }
}
