package io.github.alanpcavalcante.desafio_itau_backend.domain.transacao;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Getter
@Setter
public class Transacao {

    BigDecimal valor;

    OffsetDateTime dataHora;

}
