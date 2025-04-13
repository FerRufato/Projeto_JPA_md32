# 🛒 Product Management System

Um sistema simples de gerenciamento de produtos desenvolvido em **Java**, utilizando **Maven**, **Hibernate**, **JUnit** e **PostgreSQL**.

## 📋 Funcionalidades

- Operações CRUD (Create, Read, Update, Delete) para produtos.
- Integração com banco de dados PostgreSQL.
- Utilização de Hibernate (ORM) para persistência de dados.
- Testes unitários com JUnit 5.

## 🛠️ Tecnologias Utilizadas

- **Java 23**
- **Maven** — gerenciamento de dependências e build.
- **Hibernate** — mapeamento objeto-relacional.
- **PostgreSQL** — banco de dados relacional.
- **JUnit 5** — framework para testes.

- 
## ⚙️ Configuração

### 1. Banco de Dados

Certifique-se de que o PostgreSQL esteja instalado e em execução. Crie um banco de dados chamado `loja`.

Atualize as credenciais no arquivo `persistence.xml` (localizado em `src/main/resources/META-INF/`):

```xml
<property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/loja"/>
<property name="jakarta.persistence.jdbc.user" value="postgres"/>
<property name="jakarta.persistence.jdbc.password" value="admin"/>




