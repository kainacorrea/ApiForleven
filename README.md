# API Rest Forleven

## Status do Projeto

Em Desenvolvimento...

## Descrição

O objetivo desta API REST é gerenciar um cadastro de estudantes, permitindo operações de consulta, criação, atualização e exclusão de registros (CRUD). O projeto visa oferecer uma base sólida para o gerenciamento de estudantes que pode ser consumida por um desenvolvedor front-end.

## Funcionalidades

- **CRUD de Estudantes**: Consultar, criar, atualizar e deletar registros de estudantes.
- **Cadastro de Telefones**: Possibilidade de associar múltiplos números de telefone a um estudante.

## Regras de Negócio

- Campos obrigatórios: `nome`, `sobrenome`, `matrícula`.
- Todos os campos devem conter mais de 3 caracteres.
- A `matrícula` deve ser única no banco de dados.

## Tecnologias Utilizadas

- **Linguagem**: Java
- **Frameworks**: Spring Boot, Spring Data JPA, Spring Web
- **Banco de Dados**: MySQL
- **Outras Dependências**: Lombok, Spring Boot Starter Validation

## Time de Desenvolvedores

- Kainã Correa
