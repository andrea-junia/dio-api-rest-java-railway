package dio.desafio.apirestjavarailway.domain.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity(name = "tb_card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String number;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate validity;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getNumber() {return number;}

    public void setNumber(String number) {this.number = number;}

    public LocalDate getValidity() {return validity;}

    public void setValidity(LocalDate validity) {this.validity = validity;}

}
