package dio.desafio.apirestjavarailway.domain.services.impl;

import dio.desafio.apirestjavarailway.domain.model.Doctor;
import dio.desafio.apirestjavarailway.domain.model.User;
import dio.desafio.apirestjavarailway.domain.repository.DoctorRepository;
import dio.desafio.apirestjavarailway.domain.services.DoctorService;
import dio.desafio.apirestjavarailway.domain.services.exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

import static java.util.Optional.ofNullable;

@Service
public class DoctorServiceImpl implements DoctorService {
    private static final Long UNCHANGEABLE_USER_ID = 1L;

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {

        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> findAll() {

        return doctorRepository.findAll();
    }

    @Override
    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public Doctor create(Doctor doctorToCreate) {
        ofNullable(doctorToCreate).orElseThrow(() -> new BusinessException("Entity Doctor to create must not be null."));
        this.validateChangeableId(doctorToCreate.getId(), "created");
        return this.doctorRepository.save(doctorToCreate);
    }

    @Transactional
    public Doctor update(Long id, Doctor userToUpdate) {
        this.validateChangeableId(id, "updated");
        Doctor dbDoctor = this.findById(id);
        if (!dbDoctor.getId().equals(userToUpdate.getId())) {
            throw new BusinessException("Update IDs must be the same.");
        }

        dbDoctor.setName(userToUpdate.getName());
        return this.doctorRepository.save(dbDoctor);
    }

    @Transactional
    public void delete(Long id) {
        this.validateChangeableId(id, "deleted");
        Doctor dbDoctor = this.findById(id);
        this.doctorRepository.delete(dbDoctor);
    }

    private void validateChangeableId(Long id, String operation) {
        if (UNCHANGEABLE_USER_ID.equals(id)) {
            throw new BusinessException("User with ID %d can not be %s.".formatted(UNCHANGEABLE_USER_ID, operation));
        }
    }

}
