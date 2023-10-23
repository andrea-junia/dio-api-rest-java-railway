package dio.desafio.apirestjavarailway.domain.controller.dto;
import dio.desafio.apirestjavarailway.domain.model.Doctor;

public record DoctorDto(
        Long id,
        String name) {

    public DoctorDto(Doctor model) {
        this(
                model.getId(),
                model.getName()
        );
    }

    public Doctor toModel() {
        Doctor model = new Doctor();
        model.setId(this.id);
        model.setName(this.name);
        return model;
    }

}