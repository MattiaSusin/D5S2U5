package mattiasusin.D5S2U5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "prenotazioni")
@NoArgsConstructor
@Getter
@Setter
public class Prenotazione {
    @Id
    @GeneratedValue
    private UUID id;

    private String nota;

    @ManyToOne
    @JoinColumn(name = "viaggio_id")
    private Viaggio viaggio;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    // COSTRUTTORI

    public Prenotazione(String nota, Viaggio viaggio, Dipendente dipendente) {
        this.nota = nota;
        this.viaggio = viaggio;
        this.dipendente = dipendente;
    }

    // TO STRING

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", nota='" + nota + '\'' +
                ", viaggio=" + viaggio +
                ", dipendente=" + dipendente +
                '}';
    }
}
