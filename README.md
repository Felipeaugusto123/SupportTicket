# SupportTicket API (v1.0) 🎫

API REST robusta para gerenciamento de chamados técnicos, desenvolvida para simular um ambiente de suporte em TI.  
O sistema gerencia o ciclo de vida de tickets, desde a abertura pelo usuário até a resolução por um técnico especializado.

---

# 🚀 Diferenciais Técnicos

Este projeto demonstra domínio em conceitos avançados de persistência e arquitetura:

### Herança JPA (Single Table)
Implementação de hierarquia de classes onde `TecTI` estende `User`.  
No banco de dados, utiliza-se uma única tabela (`users`) com uma coluna discriminadora (`dtype`), otimizando a performance de consultas polimórficas.

### Relacionamentos Complexos
Gerenciamento de tickets com associações duplas à mesma tabela de origem (um autor e um responsável técnico), utilizando:

- `@ManyToOne`
- `@OneToMany`

Implementados de forma **bidirecional**.

### Validação de Dados
Uso de **Bean Validation** (`@Valid`) e tratamento de **Enums** para garantir que regras de negócio (como prioridades e status) sejam respeitadas antes de chegarem ao banco.

### Paginação
Listagem de tickets utilizando **Spring Data `Pageable`**, garantindo escalabilidade em cenários com grande volume de dados.

---

# 🛠 Tecnologias e Ferramentas

### Backend
- Java 17
- Spring Boot 3
  - Spring Web
  - Spring Data JPA
  - Spring Validation

### Produtividade
- Lombok (uso de `@SuperBuilder` para herança)

### Banco de Dados
- MySQL 8

### Gestão de Dependências
- Maven

---

# 📋 Endpoints Principais

## 👤 Gerenciamento de Usuários (`/users`)

| Método | Endpoint | Descrição |
|------|------|------|
| POST | `/CreateUser` | Cadastra um cliente comum |
| POST | `/CreateTecTI` | Cadastra um técnico (exige campo `position`) |
| GET | `/{id}` | Busca um usuário ou técnico por ID |
| PUT | `/UpdateTecTI/{id}` | Atualiza dados e cargo do técnico |
| DELETE | `?id={id}` | Remove um registro do sistema |

---

## 🎫 Tickets de Suporte (`/api/support-tickets`)

| Método | Endpoint | Descrição |
|------|------|------|
| GET | `/` | Lista todos os tickets (com paginação e ordenação) |
| POST | `/` | Abre um novo chamado vinculando `User` e `TecTI` |
| PUT | `/{id}` | Edita descrição, prioridade ou responsável |
| PUT | `/{id}/close` | Atalho para encerrar o chamado (`Status.CLOSED`) |
