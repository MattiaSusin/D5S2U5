package mattiasusin.D5S2U5.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mattiasusin.D5S2U5.enums.StatoViaggio;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "dispositivi")
@Getter
@Setter
@NoArgsConstructor
public class Viaggio {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String destinazione;
    private Date data;

    @Enumerated
    private StatoViaggio statoViaggio;

    //COSTRUTTORI
    public Viaggio(StatoViaggio statoViaggio) {
        this.statoViaggio = statoViaggio;
    }

    //TO STRING

    @Override
    public String toString() {
        return "Viaggio{" +
                "id=" + id +
                ", destinazione='" + destinazione + '\'' +
                ", data=" + data +
                ", statoViaggio=" + statoViaggio +
                '}';
    }
}
