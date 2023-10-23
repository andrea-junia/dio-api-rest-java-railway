package dio.desafio.apirestjavarailway.domain.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "tb_doctor")
@AttributeOverride(name = "id", column = @Column(name = "doctorId"))
public class Doctor extends Person{

}
