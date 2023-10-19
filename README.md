# Publicando Sua API REST na Nuvem Usando Spring Boot 3, Java 17 e Railway

Desafio de projeto entrege como atividade final para DIO - Santander Bootcamp 2023 - Backend Java


## Principais Tecnologias
- **Java 17**: Utilizaremos a versão LTS mais recente do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
- **Spring Boot 3**: Trabalharemos com a mais nova versão do Spring Boot, que maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;
- **Spring Data JPA**: Exploraremos como essa ferramenta pode simplificar nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
- **OpenAPI (Swagger)**: Vamos criar uma documentação de API eficaz e fácil de entender usando a OpenAPI (Swagger), perfeitamente alinhada com a alta produtividade que o Spring Boot oferece;
- **Railway**: facilita o deploy e monitoramento de nossas soluções na nuvem, além de oferecer diversos bancos de dados como serviço e pipelines de CI/CD.

## Diagrama de Classes (Domínio da API)

- **Este diagrama representa as classes User, Transaction, Item, Doctor e Card com seus respectivos atributos. 
- **A classe User tem associações com todas as outras classes. 
- **Note que agora a classe User tem uma lista de Item, representando o array de itens no JSON.

```mermaid
classDiagram
    class User {
        +String nameUser
        +Transaction transatction
        +List<Item> itens
        +Doctor doctor
        +Card cardUser
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
    class Card {
        +String number
        +Date validity
    }

  User "1" *-- "1" Transaction
  User "1" *-- "1" Card
  Transaction "1" *-- "N" Item
  Transaction "1" *-- "1" Doctor
```
