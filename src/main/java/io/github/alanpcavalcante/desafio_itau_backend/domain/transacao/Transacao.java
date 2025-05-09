package io.github.alanpcavalcante.desafio_itau_backend.domain.transacao;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@ToString
public class Transacao {

    BigDecimal valor;
    OffsetDateTime dataHora;

}
