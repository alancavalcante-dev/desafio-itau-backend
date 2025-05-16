
# 📘 Desafio Backend - Itaú Unibanco

Este repositório contém a solução desenvolvida para o **desafio técnico backend** proposto pelo Itaú Unibanco. O sistema foi construído com foco em **boas práticas de design**, **modularidade** e **flexibilidade para futuras evoluções**.

---

## 🔧 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web
- Springdoc OpenAPI
- Lombok
- SLF4J (log)
- JUnit/Testes
- Swagger UI
- Docker
- Exception Handler

---

## 🧠 Organização do Projeto

A estrutura foi separada por responsabilidades claras:

```
src/
└── io.github.alanpcavalcante.desafio_itau_backend/
    ├── common/                    # Tratamento global de exceções
    │   └── ExceptionHandlerGlobal
    ├── config/                    # Configurações gerais do projeto (ex: Swagger)
    │   └── OpenApiConfiguration
    ├── controller/               # Camada de exposição de endpoints REST
    │   ├── StatisticController
    │   └── TransactionController
    ├── domain/                   # Regras de negócio
    │   ├── statistics/
    │   │   ├── StatisticsDTO
    │   │   └── StatisticsService
    │   └── transaction/
    │       └── TransactionService
    ├── exceptions/              # Exceções customizadas
    │   ├── DateTimeGreaterThanCurrent
    │   └── ValueLessThanZero
    ├── infrastructure/          # Simulação de repositório em memória
    │   └── TransactionRepository
    └── DesafioItauBackendApplication.java # Classe principal
```

---

## ✅ Funcionalidades

- 🔄 **Registrar transações** via POST `/transacao`
- 🗑️ **Limpar cache de transações** via DELETE `/transacao`
- 📊 **Consultar estatísticas** das transações dos últimos X segundos via GET `/estatistica`
- 🧹 Validações customizadas:
  - Valor não pode ser negativo
  - Data não pode estar no futuro
  - Todos os campos devem ser preenchidos
- 🖥️ **Observabilidade e métricas** para verificar e monitorar a saúde do sistema
  - Aconselho baixar a entensão JSON Formatter do Google Chrome para navegar nos links

---

## 📁 Exemplo de Request

**POST /transacao**
```json
{
  "value": 100.0,
  "dateTime": "2025-05-16T14:00:00Z"
}
```

**GET /estatistica**
```json
{
  "count": 1,
  "sum": 100.0,
  "avg": 100.0,
  "min": 100.0,
  "max": 100.0
}
```

---

## 💭 Minhas Decisões de Projeto

- 🌱 **Separação por domínios funcionais**: optei por organizar a lógica de `transactions` e `statistics` em pacotes separados, favorecendo a escalabilidade e clareza.
- 🧪 **Validações isoladas**: cada regra de validação é clara e com exceções específicas, facilitando a manutenção.
- ⚙️ **Configuração de tempo parametrizada**: utilizei o `application.yml` para configurar o tempo das estatísticas, deixando a aplicação mais flexível.
- 🧰 **Simulação de repositório**: como o foco não era persistência real, usei um repositório em memória (lista) para armazenar as transações.
- 📈 **Uso de `DoubleSummaryStatistics`**: aproveitei a classe mencionada pelo próprio desafio, é do Java para gerar estatísticas de forma eficiente e legível.

---

## 📄 Swagger / OpenAPI

A documentação da API está disponível via Swagger em:

```
http://localhost:8080/swagger-ui.html
```

---

## ⚙️ Configurações (application.yml)

```yaml
transactions:
  timer:
    seconds: 60     # Tempo em segundos considerado nas estatísticas

logging:
  file:
    name: app.log   # Geração de logs no arquivo app.log

springdoc:
  override-with-generic-response: true
```

---

## 🚫 Tratamento Global de Erros

- Exceções de validação são capturadas pelo `ExceptionHandlerGlobal`.
- Retornos padronizados com os códigos de status adequados:
  - `422` para erros genéricos
  - `400` para erros de valor inválido ou data futura
  - `200` para mostrar conteúdos
  - `201` para mostrar status de criação
---

## 🔧 Monitoramento com Spring Boot Actuator

Este projeto utiliza o Spring Boot Actuator para expor endpoints de gerenciamento e monitoramento da aplicação.

---

## 🚀 Como executar

Se quiser pode rodar normalmente usando Maven:

<i>
"./mvnw clean install" <br>
"./mvnw spring-boot:run"
</i>

<br><br>
Ou, pode utilizar Docker com o Dockerfile já configurado:
<br><br>

<i>
"docker build -t desafio-itau-backend ." <br>
"docker run -p 8080:8080 -p 9090:9090 desafio-itau-backend"
</i>

## URLs
🔗 http://localhost:8080/transacao <br>
🔗 http://localhost:8080/estatistica <br>
🔗 http://localhost:9090/actuator



---

## 📬 Contato

Desenvolvido por **Alan Pereira Cavalcante**

📧 alan.cavalcante.dev@gmail.com <br>
📞 (11) 986815754
