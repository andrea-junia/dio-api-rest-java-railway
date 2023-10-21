package dio.desafio.apirestjavarailway.domain.services;

import dio.desafio.apirestjavarailway.domain.model.User;

public interface UserService{
    User findById(Long id);
    User create(User userToCreate);
}
