package mattiasusin.D5S2U5.payloads;

import java.time.LocalDateTime;

public record ErrorsResponseDTO(String message, LocalDateTime time) {
}
