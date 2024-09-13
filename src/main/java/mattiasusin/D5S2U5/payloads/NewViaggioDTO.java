package mattiasusin.D5S2U5.payloads;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewViaggioDTO(
    @NotEmpty(message = "Inserisci la destinazione in modo corretto")
    @Size(min = 4, max = 50, message = "la destinazione deve essere compreso tra 2 e 50 caratteri")
    String destinazione,
    @NotEmpty(message = "inserisci la data giusta")
    @Size(min = 4, max = 35, message = "la data deve essere compreso tra 3 e 40 caratteri")
    String data,
    @NotEmpty(message = "Lo stato viaggio può essere in programma o completato")
    @Size(min = 2, max = 30, message = "stato deve essere compreso tra 2 e 10 caratteri")
    String statoViaggio
    ){

}

