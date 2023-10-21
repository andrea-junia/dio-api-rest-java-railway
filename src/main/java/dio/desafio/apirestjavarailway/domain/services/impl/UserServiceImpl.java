package dio.desafio.apirestjavarailway.domain.services.impl;

import dio.desafio.apirestjavarailway.domain.model.User;
import dio.desafio.apirestjavarailway.domain.repository.UserRepository;
import dio.desafio.apirestjavarailway.domain.services.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if( userRepository.existsByCardNumber( userToCreate.getCard().getNumber() ) ){
            throw new IllegalArgumentException("This Card number already exists");
        }
        return userRepository.save(userToCreate);
    }

}
