package dio.desafio.apirestjavarailway.domain.model;

import jakarta.persistence.*;

@Entity(name = "tb_user")
@AttributeOverride(name = "id", column = @Column(name = "userId"))
public class User extends Person {

}
