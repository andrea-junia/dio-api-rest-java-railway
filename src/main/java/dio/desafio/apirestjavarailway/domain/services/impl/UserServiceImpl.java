package dio.desafio.apirestjavarailway.domain.services.impl;

import dio.desafio.apirestjavarailway.domain.model.User;
import dio.desafio.apirestjavarailway.domain.repository.UserRepository;
import dio.desafio.apirestjavarailway.domain.services.UserService;
import dio.desafio.apirestjavarailway.domain.services.exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.List;
import static java.util.Optional.ofNullable;

@Service
public class UserServiceImpl implements UserService {

    private static final Long UNCHANGEABLE_USER_ID = 1L;

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public User create(User userToCreate) {
        ofNullable(userToCreate).orElseThrow(() -> new BusinessException("User to create must not be null."));
        ofNullable(userToCreate.getCard()).orElseThrow(() -> new BusinessException("User account must not be null."));
        ofNullable(userToCreate.getCard()).orElseThrow(() -> new BusinessException("User card must not be null."));

        this.validateChangeableId(userToCreate.getId(), "created");
        if (userRepository.existsByCardNumber(userToCreate.getCard().getNumber())) {
            throw new BusinessException("This account number already exists.");
        }
        if (userRepository.existsByCardNumber(userToCreate.getCard().getNumber())) {
            throw new BusinessException("This card number already exists.");
        }
        return this.userRepository.save(userToCreate);
    }

    @Transactional
    public User update(Long id, User userToUpdate) {
        this.validateChangeableId(id, "updated");
        User dbUser = this.findById(id);
        if (!dbUser.getId().equals(userToUpdate.getId())) {
            throw new BusinessException("Update IDs must be the same.");
        }

        dbUser.setName(userToUpdate.getName());
        dbUser.setCard(userToUpdate.getCard());
        dbUser.setCard(userToUpdate.getCard());
        return this.userRepository.save(dbUser);
    }

    @Transactional
    public void delete(Long id) {
        this.validateChangeableId(id, "deleted");
        User dbUser = this.findById(id);
        this.userRepository.delete(dbUser);
    }

    private void validateChangeableId(Long id, String operation) {
        if (UNCHANGEABLE_USER_ID.equals(id)) {
            throw new BusinessException("User with ID %d can not be %s.".formatted(UNCHANGEABLE_USER_ID, operation));
        }
    }


    /*@Override
    public User create(User userToCreate) {
        if( userRepository.existsByCardNumber( userToCreate.getCard().getNumber() ) ){
            throw new IllegalArgumentException("This Card number already exists");
        }

        return userRepository.save(userToCreate);
    }*/

}
