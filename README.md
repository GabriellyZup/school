 # school
Exercício pratico de Postgresql e Crud

 # Projeto Escola

        Este projeto é uma aplicação Spring Boot que gerencia informações de alunos em um banco de dados PostgreSQL chamado 'escola'. Ele foi desenvolvido para atender a uma regra de negócios específica, incluindo a criação de um banco de dados, manipulação de tabelas e a implementação de endpoints REST para operações CRUD.

## Introdução

        O objetivo deste projeto é fornecer uma API REST para gerenciar alunos, permitindo operações como criação, leitura, atualização e exclusão (CRUD). A aplicação utiliza o framework Spring Boot e se conecta a um banco de dados PostgreSQL.

## Instalação

### Dependências

        Certifique-se de ter as seguintes ferramentas instaladas:

        - [Java 17+](https://www.oracle.com/java/technologies/javase-downloads.html)
        - [Maven](https://maven.apache.org/)
        - [PostgreSQL](https://www.postgresql.org/)
        - [Spring Boot](https://spring.io/projects/spring-boot)

### Configuração do Banco de Dados

 1. Acesse o terminal do PostgreSQL e execute os seguintes comandos para criar o banco de dados e a tabela:

```sql
-- Criação do banco de dados
    CREATE DATABASE school;

    -- Conexão com o banco de dados
    \c school;

    -- Criação da tabela aluno
        CREATE TABLE aluno (
            id SERIAL PRIMARY KEY,
            nome VARCHAR(255) NOT NULL,
            idade INT NOT NULL
        );

 -- Inserção de dados na tabela
        INSERT INTO aluno (nome, idade) VALUES ('João', 20), ('Maria', 22), ('Pedro', 19);
```

2. Configure as credenciais do banco de dados no arquivo `application.yml`:

   ```yaml
        spring:
          datasource:
            url: jdbc:postgresql://localhost:5432/escola
            username: postgres
            password: postgres
            driver-class-name: org.postgresql.Driver
          jpa:
            hibernate:
              ddl-auto: update
            show-sql: true
            properties:
              hibernate:
                format_sql: true
   ```

   ### Comandos para Executar o Projeto

   1. Clone o repositório:

        ```bash
        git clone git@github.com:GabriellyZup/school.git
        cd school
        ```

  2. Compile e execute o projeto:

        ```bash
        mvn spring-boot:run
        ```

     ## Uso

     ### Endpoints Disponíveis

        - **GET /alunos**: Retorna a lista de todos os alunos.
        - **GET /alunos/{id}**: Retorna os detalhes de um aluno específico.
        - **POST /alunos**: Cria um novo aluno.
        - **PUT /alunos/{id}**: Atualiza as informações de um aluno existente.
        - **DELETE /alunos/{id}**: Remove um aluno.

     ### Exemplo de Requisição

        **POST /alunos**

        ```json
        {
          "nome": "Ana",
          "idade": 25
        }
        ```

        **Resposta**

        ```json
        {
          "id": 4,
          "nome": "Ana",
          "idade": 25
        }
        ```

     ## Validação

     ### Exemplo de JSON para Testes

        **POST /alunos**

        ```json
        {
          "nome": "Carlos",
          "idade": 30
        }
        ```

        **PUT /alunos/1**

        ```json
        {
          "nome": "Carlos Silva",
          "idade": 31
        }
        ```





