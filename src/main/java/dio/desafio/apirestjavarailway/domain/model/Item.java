package dio.desafio.apirestjavarailway.domain.model;

import jakarta.persistence.*;

@Entity(name = "tb_item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;
}
