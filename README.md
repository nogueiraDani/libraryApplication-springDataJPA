# Library App

Bem-vindo ao Library App! Este é um projeto pessoal desenvolvido em Java utilizando o Spring Boot. O objetivo deste projeto é gerenciar uma biblioteca, permitindo o cadastro de livros, autores e empréstimos.

## Funcionalidades

- Cadastro de livros
- Cadastro de autores
- Cadastro de clientes
- Gerenciamento de empréstimos
- Consulta de livros disponíveis
- Histórico de empréstimos

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.1
- Spring Data JPA
- Spring Security
- PostgreSQL
- Lombok
- Swagger/OpenAPI
- AWS
- Angular
- Vercel

## Pré-requisitos

- Java 21
- Maven
- PostgreSQL

## Configuração do Banco de Dados

Certifique-se de que o PostgreSQL está instalado e em execução. Crie um banco de dados chamado `library_app` e configure o usuário e a senha no arquivo `application.properties`.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/library_app
spring.datasource.username=postgres
spring.datasource.password=sua_senha

## Executando a Aplicação

1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/library_app.git
   ```
2. Navegue até o diretório do projeto:
   ```sh
   cd library_app
   ```
3. Compile e execute a aplicação:
   ```sh
   ./mvnw spring-boot:run
   ```

A aplicação estará disponível em `http://localhost:8080`.

## Testes

Para executar os testes, utilize o comando:
```sh
./mvnw test
```

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença

Este projeto está licenciado sob a Licença Apache 2.0. Veja o arquivo LICENSE para mais detalhes.

---

Feito com 💜 por [Daniela Nogueira Rampim](https://github.com/nogueiraDani)
