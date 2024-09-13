package mattiasusin.D5S2U5.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String username){
        super("Il Dipendente con username: " + username + "non è stato trovato");
    }
}
