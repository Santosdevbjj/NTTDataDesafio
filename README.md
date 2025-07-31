## Desafio NTT Data

![NTT-Java](https://github.com/user-attachments/assets/f76324e9-34c6-47db-91e5-1e68d739aa9c)

**Bootcamp NTT DATA - Java e IA para Iniciantes.**


**DESCRIÇÃO do projeto:**

O desafio tem como objetivo aplicar e validar os conhecimentos adquiridos ao longo do bootcamp, focando no desenvolvimento de um sistema simples de catálogo de produtos e simulação de pedidos. 

O sistema deve ser composto por dois microsserviços independentes, implementados utilizando Spring Boot e Spring Cloud. 

A comunicação entre os microsserviços será realizada via requisições HTTP, com o uso de um API Gateway e Service Discovery.


**Desafio técnico Microserviços.**

  **Definição de Requisitos:**

Desenvolver um sistema de gestão de pedidos com catálogo de produtos.

Microserviço 1 (Catálogo de produtos)
Permite Cadastrar, Pesquisar, Alterar, Deletar, Listar ,(nome, descrição, preço ...).

Persistência deve ser feita via H2 Database.

Microserviço 2 (Simulação de Pedidos)

Realiza chamada ao Microserviço 1 para buscar os produtos disponíveis.

Permite simular a criação de um pedido com base em uma lista de produtos.

Não necessita persistência.


**Direcionamento Técnico**

**Portas**

**Microserviço 1 - Produtos 8100-8199**

**Microserviço 2 - Pedidos 8200-8299**

**API Gateway 8700-8799**


**Descrição do Desafio:**

O desafio tem como objetivo focar no desenvolvimento de um sistema simples de catálogo de produtos e simulação de pedidos. 

O sistema deve ser composto por dois microsserviços independentes, implementados utilizando Spring Boot e Spring Cloud. 

A comunicação entre os microsserviços será realizada via requisições HTTP, com o uso de um API Gateway e Service Discovery.












