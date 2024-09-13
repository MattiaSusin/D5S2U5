package mattiasusin.D5S2U5.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewDipendenteDTO(
        @NotEmpty(message = "Non hai inserito il nome")
        @Size(min = 4, max = 15, message = "Il nome deve essere compreso tra 3 e 40 caratteri")
        String name,
        @NotEmpty(message = "Non hai inserito il cognome")
        @Size(min = 4, max = 15, message = "Il cognome deve essere compreso tra 3 e 40 caratteri")
        String cognome,
        @NotEmpty(message = "Non hai inserito l'username")
        @Size(min = 2, max = 10, message = "l'username  deve essere compreso tra 2 e 10 caratteri")
        String username,
        @NotEmpty(message = "Non hai inserito l'email")
        @Email(message = "L'email inserita non è valida")
        String email
) {
}
