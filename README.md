# Baozi Store — API REST

API REST desenvolvida como atividade prática da disciplina de Desenvolvimento Web Back-End, do curso de Análise e Desenvolvimento de Sistemas da UNINTER.

O projeto simula o gerenciamento de uma loja fictícia especializada na produção e comercialização de pãezinhos chineses, conhecidos como Baozi.

## Tecnologias e versões

- **Java:** 25.0.1
- **Spring Boot:** 4.2.0
- **Spring Web:** versão gerenciada pelo Spring Boot.
- **Spring Data JPA:** versão gerenciada pelo Spring Boot.
- **MySQL Server:** 8.0.43
- **MySQL Connector/J:** versão gerenciada pelo Spring Boot.
- **Maven:** utilização do Maven Wrapper incluído no projeto.

## Funcionalidades

A API permite realizar operações de cadastro, consulta, atualização e exclusão (CRUD) de três entidades:

### Cliente
- `id` (Long): identificador do cliente.
- `nome` (String): nome do cliente.
- `clienteDesde` (LocalDate): data de cadastro.

### Produto
- `id` (Long): identificador do produto.
- `nome` (String): nome do produto.
- `preco` (BigDecimal): preço por unidade.
- `estoque` (Boolean): disponibilidade em estoque.

### Pedido
- `id` (Long): identificador do pedido.
- `clienteId` (Long): identificador do cliente relacionado.
- `produtoId` (Long): identificador do produto relacionado.
- `quantidade` (Integer): quantidade de unidades solicitadas.

## Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/clientes` | Cadastrar cliente |
| GET | `/clientes` | Listar clientes |
| GET | `/clientes/{id}` | Consultar cliente por ID |
| PUT | `/clientes/{id}` | Atualizar cliente |
| DELETE | `/clientes/{id}` | Excluir cliente |
| POST | `/produtos` | Cadastrar produto |
| GET | `/produtos` | Listar produtos |
| GET | `/produtos/{id}` | Consultar produto por ID |
| PUT | `/produtos/{id}` | Atualizar produto |
| DELETE | `/produtos/{id}` | Excluir produto |
| POST | `/pedidos` | Cadastrar pedido |
| GET | `/pedidos` | Listar pedidos |
| GET | `/pedidos/{id}` | Consultar pedido por ID |
| PUT | `/pedidos/{id}` | Atualizar pedido |
| DELETE | `/pedidos/{id}` | Excluir pedido |

## Configuração do banco de dados

O projeto utiliza o MySQL para persistência dos dados.

Crie o banco de dados com o seguinte comando:

```sql
CREATE DATABASE baozi_store;
```

Configure as credenciais de acesso no arquivo `src/main/resources/application.properties`.

A senha do banco é obtida por meio da variável de ambiente `DB_PASSWORD`, evitando armazenar credenciais diretamente no código-fonte.

No Windows PowerShell, configure a variável antes de executar a aplicação:

```powershell
$env:DB_PASSWORD="sua_senha"
```

## Como executar o projeto

É necessário ter Java e MySQL instalados e configurados.

Na pasta raiz do projeto, execute:

```powershell
.\mvnw.cmd spring-boot:run
```

Após iniciar a aplicação, os endpoints estarão disponíveis em:

`http://localhost:8080`

## Organização do projeto

```text
src/
└── main/
    ├── java/com/baozi/
    │   ├── controller/
    │   ├── model/
    │   └── repository/
    └── resources/
        └── application.properties
```

## Autor

**Gabriel dos Reis Andrade**

Curso: Análise e Desenvolvimento de Sistemas — UNINTER.

Projeto acadêmico — 2026.