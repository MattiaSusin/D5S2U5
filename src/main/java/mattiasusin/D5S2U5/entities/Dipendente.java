package mattiasusin.D5S2U5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "dipendenti")
@Getter
@Setter
@NoArgsConstructor
public class Dipendente{

    @Id
    private UUID username;

    private String nome;
    private String cognome;
    private String email;
    private String imgProfilo;

    //COSTRUTTORI

    public Dipendente(String name, String cognome, String email, UUID username) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.imgProfilo = imgProfilo;
    }


    //TO STRING
    @Override
    public String toString() {
        return "Dipendente{" +
                "username='" + username + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", imgProfilo='" + imgProfilo + '\'' +
                '}';
    }
}
