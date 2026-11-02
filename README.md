# iCompras — microsserviços com Spring Boot (estudo)

> **Projeto de curso.** Código escrito acompanhando o curso *Spring Boot + Kafka: Arquitetura Completa de Microservices*. A arquitetura e o domínio vêm do curso; o repositório registra a minha prática. **Em andamento:** a comunicação entre os serviços ainda é síncrona (OpenFeign) e a etapa com Kafka vem nos próximos módulos.

**Java 21 · Spring Boot 4 · Spring Cloud OpenFeign · PostgreSQL · Docker**

## Serviços

| Serviço | Porta | Responsabilidade | Endpoints |
|---|---|---|---|
| `produtos` | 8081 | Cadastro e consulta de produtos | `POST /produtos`, `GET /produtos/{codigo}` |
| `clientes` | 8082 | Cadastro e consulta de clientes | `POST /clientes`, `GET /clientes/{codigo}` |
| `pedidos` | 8080 | Cria pedidos validando produto e cliente nos outros serviços, e recebe o retorno do pagamento | `POST /pedidos`, `POST /pedidos/pagamentos`, `POST /pedidos/callback-pagamentos` |
| `icompras-servicos` | — | Infraestrutura local: banco (`database/`) e broker Kafka com Kafka UI (`broker/`) | — |

```
cliente HTTP ──► pedidos ──(OpenFeign)──► produtos
                    │
                    └──────(OpenFeign)──► clientes
```

## Como rodar

Pré-requisitos: JDK 21, Maven e Docker.

```bash
# 1. Banco (PostgreSQL na porta 5555; o schema está em database/schema.sql)
docker compose -f icompras-servicos/database/docker-compose.yml up -d

# 2. Broker Kafka + Kafka UI (para os próximos módulos)
docker compose -f icompras-servicos/broker/docker-compose.yml up -d

# 3. Cada serviço, em um terminal
cd produtos && mvn spring-boot:run
cd clientes && mvn spring-boot:run
cd pedidos  && mvn spring-boot:run
```

As credenciais do banco vêm de `DB_USERNAME` e `DB_PASSWORD`. Sem elas, os serviços usam os valores do docker-compose local.

## O que pratiquei aqui

- Separação de um domínio em serviços com banco por contexto
- Comunicação síncrona entre serviços com OpenFeign
- Validação do pedido em uma camada própria (`PedidoValidator`), consultando produto e cliente nos outros serviços
- Callback de pagamento vindo de um serviço externo

## Próximos passos

- Publicar e consumir eventos de pedido no Kafka, trocando chamadas síncronas por mensageria
- Testes de integração com Testcontainers
