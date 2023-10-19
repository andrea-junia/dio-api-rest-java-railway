# Publicando Sua API REST na Nuvem Usando Spring Boot 3, Java 17 e Railway

Desafio de projeto entrege como atividade final para DIO - Santander Bootcamp 2023 - Backend Java


## Principais Tecnologias
- **Java 17**: Utilizaremos a versão LTS mais recente do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
- **Spring Boot 3**: Trabalharemos com a mais nova versão do Spring Boot, que maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;
- **Spring Data JPA**: Exploraremos como essa ferramenta pode simplificar nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
- **OpenAPI (Swagger)**: Vamos criar uma documentação de API eficaz e fácil de entender usando a OpenAPI (Swagger), perfeitamente alinhada com a alta produtividade que o Spring Boot oferece;
- **Railway**: facilita o deploy e monitoramento de nossas soluções na nuvem, além de oferecer diversos bancos de dados como serviço e pipelines de CI/CD.

## Diagrama de Classes (Domínio da API)

```mermaid
classDiagram
    class User {
        +String nameUser
        +Transaction transatction
        +Item item
        +Doctor doctor
        +Card cardUser
    }
    
    class Card {
        +String number
        +Date validity
    }

    class Transaction {
        +String number
        +String dateTime
        +String type
    }
    class Item {
        +String code
        +int quantity
        +String status
    }
    class Doctor {
        +String code
        +String name
    }

  User "1" *-- "1" Transaction
  User "1" *-- "1" Card
  User "1" *-- "N" Item
  User "1" *-- "1" Doctor
```
