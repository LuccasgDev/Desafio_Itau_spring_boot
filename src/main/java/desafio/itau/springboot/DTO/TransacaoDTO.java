package desafio.itau.springboot.DTO;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public class TransacaoDTO {
    @NotNull
    private Double valor;

    @NotNull
    private OffsetDateTime dataHora;

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public Double getValor() {
        return valor;
    }
}
