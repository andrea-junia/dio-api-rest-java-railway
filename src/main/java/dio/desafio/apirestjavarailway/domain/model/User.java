package dio.desafio.apirestjavarailway.domain.model;

import java.util.List;

import jakarta.persistence.*;

@Entity(name = "tb_user")
public class User extends Person {

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    public Card getCard() {return card;}
    public void setCard(Card card) {this.card = card;}

}
