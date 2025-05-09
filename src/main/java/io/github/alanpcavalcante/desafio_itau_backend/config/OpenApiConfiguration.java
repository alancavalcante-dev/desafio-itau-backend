package io.github.alanpcavalcante.desafio_itau_backend.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Desafio Itaú Unibanco Backend",
                version = "v1",
                contact = @Contact(
                        name = "Alan Pereira",
                        email = "alan.cavalcante.dev@gmail.com"
                )
        )
)
public class OpenApiConfiguration {
}

