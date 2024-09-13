package mattiasusin.D5S2U5.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewPrenotazioneDTO(
        @NotEmpty(message = "la nota è obbligatoria")
        @Size(min = 5, max = 70, message = "la nota deve essere compresa tra 5 e 70 caratteri")
        String nota
) {
}
