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
   {
      "nameUser": "andrea",
      "transatction": {
        "number": "1234",
        "dateTime": "20231019 17:46:00",
        "type": "001"
      },
      "itens": [
        {
          "code": "10101012",
          "quantity": 1,
          "status": "2"
        }
      ],
      "doctor": {
        "code": "123",
        "name": "dio clinic"
      },
      "cardUser": {
        "number": "1236",
        "validity": "2023-12-31"
      }
   }

  User "1" *-- "1" Transaction
  User "1" *-- "1" Card
  Transaction "1" *-- "N" Item
  Transaction "1" *-- "1" Doctor
```
