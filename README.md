# Desafio NTT DATA – Sistema de Microserviços em Java

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


xxxxxxxxxxxccxxxxxccccxxxxxxxxxxxxxxx







## 📌 Visão Geral

Este projeto consiste em **quatro microserviços Spring Boot** desenvolvidos com orientação a objetos (OOP) e usando *Spring Cloud*:

- **discovery-server**: servidor Eureka para registro e descoberta de serviços (porta **8761**)
- **produto-service**: catálogo de produtos com CRUD (porta **8101**, banco em H2)
- **pedido-service**: simulação de pedidos consumindo o catálogo (porta **8201**)
- **api-gateway**: roteamento de chamadas, autenticação Basic Auth e integração com Eureka (porta **8701**)

A comunicação entre os serviços ocorre via HTTP, utilizando *Eureka* e *Spring Cloud Gateway* para discovery e roteamento.

---

## 🧩 Estrutura do Repositório (monorepo)

desafio-nttdata/ ├── discovery-server/ │   └── src/main/java/...           (código Eureka Server) │   └── src/main/resources/ │       └── application.yml ├── produto-service/ │   ├── src/main/java/...           (domain, repository, service, controller) │   └── src/main/resources/ │       └── application.yml ├── pedido-service/ │   ├── src/main/java/...           (DTOs, controller, CLI runner) │   └── src/main/resources/ │       └── application.yml ├── api-gateway/ │   ├── src/main/java/...           (configuração Gateway e segurança) │   └── src/main/resources/ │       └── application.yml ├── README.md └── .gitignore

- Cada microserviço possui seu próprio `pom.xml` dentro da pasta correspondente.
- É possível incluir um `pom.xml` pai na raiz para build multicontínuo (opcional).

---

## ✅ Funcionalidades Implementadas

### discovery-server
- Registro centralizado dos serviços via Eureka
- Visualização da dashboard em `http://localhost:8761`

### produto-service
- **Produto.java**: entidade do catálogo com atributos `id`, `nome`, `descrição` e `preço`
- **ProdutoRepository**: interface JPA para persistência no banco H2
- **ProdutoService**: camada de negócio para operações CRUD com `Produto`
- **ProdutoController**: endpoints REST:
  - `POST /produtos` – criar
  - `GET /produtos` – listar todos
  - `GET /produtos/{id}` – buscar por ID
  - `PUT /produtos/{id}` – atualizar
  - `DELETE /produtos/{id}` – remover

### pedido-service
- **PedidoRequest.java**: DTO contendo `List<Long> produtoIds`
- **PedidoResponse.java**: DTO de resposta com `List<Produto>` e `BigDecimal total`
- **PedidoController**:
  - `POST /pedidos/simular`: recebe `PedidoRequest`, consulta o serviço de produtos via `RestTemplate`, calcula total e retorna `PedidoResponse`
- **PedidoCliRunner**: implementação de menu no terminal para interação simples:
  - Listar produtos cadastrados
  - Simular pedido informando IDs dos produtos

### api-gateway
- Configurado via *Spring Cloud Gateway* com descoberta automática de rotas com base nos serviços registrados no Eureka
- **SecurityConfig.java**: autenticação Basic Auth com usuário `user` e senha `password`
- Rotas mapeadas:
  - `/produtos/**` → produto-service
  - `/pedidos/**` → pedido-service

---

## ⚙️ Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/desafio-nttdata.git
   cd desafio-nttdata

2. Compile e empacote (caso tenha pom.xml pai):

mvn clean install


3. Execute cada módulo em terminais separados:

cd discovery-server && mvn spring-boot:run
cd produto-service && mvn spring-boot:run
cd pedido-service && mvn spring-boot:run
cd api-gateway && mvn spring-boot:run


4. Acesse via API Gateway (com Basic Auth):

Endpoints catálogo: http://localhost:8701/produtos

Simulação de pedido: http://localhost:8701/pedidos/simular



5. Menu CLI no pedido-service: com terminal aberto no serviço, você pode listar produtos e simular pedidos interativamente.




---

📘 Detalhes Técnicos & OOP

Separação de responsabilidades:

domain/entity: definição das classes modelo como Produto

repository: persistência com JPA/H2

service: regras de negócio e lógica de CRUD

controller: interface REST para os usuários / clientes


Integração entre serviços:

pedido-service usa RestTemplate com @LoadBalanced para chamadas HTTP via Eureka Discovery


Autenticação:

Basic Auth no API Gateway, protegendo todos os endpoints expostos externamente


Persistência:

produto-service utiliza banco H2 em memória para facilitar testes sem dependência externa


Menu interativo CLI:

Facilita a simulação de uso real sem necessidade de cliente HTTP (Postman)




---

📂 Estrutura de Pastas (detalhada)

Diretório	Conteúdo

discovery-server/	Eureka Server
produto-service/	CRUD de produtos com H2
pedido-service/	Simulação de pedidos + CLI interativo
api-gateway/	Roteamento e segurança via Spring Cloud
.gitignore	Ignora target/, IDE, arquivos temporários
README.md	Documentação explicativa do projeto



---

🚀 Próximos Passos (extras recomendados)

Implementar testes unitários e de integração (JUnit + Mockito)

Adotar Spring Cloud Config Server para configuração centralizada

Substituir Basic Auth por OAuth2 / JWT

Dockerização com Docker e docker-compose

Adição de logs centralizados (Zipkin, Sleuth, ELK)



---

🙋 Autor

Seu Nome

Mentor GitHub: seu-usuario











