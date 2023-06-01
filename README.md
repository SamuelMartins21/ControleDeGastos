# Controle De Gastos 💰💼💳

Este projeto consiste em uma aplicação desenvolvida em Java utilizando o framework Spring Boot e tecnologias relacionadas. A finalidade da aplicação é auxiliar o usuário no controle de suas despesas, permitindo o gerenciamento por categorias e status de pagamento. 

## Tecnologias utilizadas🛠️

- Java
- Spring Boot
- Maven
- Git
- SQL (MySQL)
- JUnit
- Spring Security

## Funcionalidades⚙️

- Operações CRUD (Create, Read, Update, Delete) para o gerenciamento das despesas. Isso permite ao usuário criar, visualizar, atualizar e excluir despesas de acordo com suas necessidades.✏️👀🔄❌

- Utilização do HATEOAS para navegação entre os recursos da API. Isso facilita a interação com a aplicação, fornecendo links para recursos relacionados e simplificando a navegação entre eles. 🔗🌐

- Integração da API com um banco de dados MySQL. Isso permite que as despesas sejam armazenadas de forma persistente e acessíveis em diferentes execuções da aplicação.🗄️🔒

- Utilização do GIT e GitHub como repositórios remoto e local, respectivamente. Essa abordagem de controle de versão permite o rastreamento e gerenciamento eficiente do código fonte, facilitando o trabalho colaborativo e o acompanhamento das alterações realizadas.📁🐙

- Implementação de testes utilizando a metodologia TDD (Test-Driven Development) e o framework JUnit. Essa abordagem de desenvolvimento orientada por testes permite que os testes sejam escritos antes da implementação do código, garantindo a qualidade e a robustez da aplicação.🧪✅🔧

- Implementação do Spring Security para lidar com questões de autenticação e autorização. Isso garante que apenas usuários autorizados possam acessar as funcionalidades da aplicação e protege os dados dos usuários.🔒🔑

## Como executar o projeto ▶️

1. Certifique-se de ter o Java e o Maven instalados em seu ambiente de desenvolvimento. ☕🧪

2. Clone o repositório do GitHub em seu ambiente local

3. Execute a aplicação

A aplicação estará disponível em ``http://localhost:8080/`` Agora você pode fazer chamadas para as operações CRUD utilizando as seguintes rotas:

- Obter todas as despesas:
**GET** ```http://localhost:8080/getallcontroledegastos```.
Essa rota retorna todas as despesas cadastradas no sistema.📋🔍

- Obter uma despesa específica:
**GET** ```http://localhost:8080/GetOneControleDeGasto/{id}```.
Substitua {id} pelo ID da despesa desejada. Essa rota retorna os detalhes da despesa correspondente ao ID informado.🔍

- Excluir uma despesa específica:
**DELETE** ```http://localhost:8080/DeleteOneControleDeGasto/{id}```.
Substitua {id} pelo ID da despesa que deseja excluir. Essa rota remove a despesa correspondente ao ID informado.❌📋 

- Atualizar uma despesa:
**PUT** ```http://localhost:8080/PutControleDeGasto/{id}```.
Substitua {id} pelo ID da despesa que deseja atualizar. Envie os dados atualizados da despesa no corpo da requisição. Essa rota atualiza os dados da despesa correspondente ao ID informado.✏️🔄📋 

- Excluir todas as despesas:
**DELETE** ```http://localhost:8080/deleteAll```.
Essa rota exclui todas as despesas cadastradas no sistema.❌📋📋

Certifique-se de utilizar uma ferramenta adequada, como o Postman, para realizar as requisições HTTP e interagir com as operações CRUD do projeto.
