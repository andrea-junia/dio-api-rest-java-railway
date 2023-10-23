package dio.desafio.apirestjavarailway.domain.repository;

import dio.desafio.apirestjavarailway.domain.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}