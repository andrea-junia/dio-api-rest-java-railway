package dio.desafio.apirestjavarailway.domain.repository;

import dio.desafio.apirestjavarailway.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByCardNumber(String number);
}
