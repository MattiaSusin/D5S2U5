package mattiasusin.D5S2U5.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID username){
        super("Il Dipendente con username: " + username + "non è stato trovato");
    }

    public NotFoundException(String dipendenteUsername) {

    }
}
