# Desafio Magazine Luiza (Luizalabs)

## Aplicação Spring Boot com MongoDB (NoSQL)

### Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **MongoDB**
- **Apache Maven (opcional)**
- **HTML**
- **CSS**

---

## Passos para Configuração

### 1. Instalação do Java 17

Certifique-se de que o Java 17 esteja instalado em seu sistema. Você pode baixar o Java [aqui](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).

### 2. Instalação do MongoDB

Baixe e instale o MongoDB a partir do site oficial: [MongoDB Download Center](https://www.mongodb.com/try/download/community).

### 3. Instalação do Apache Maven (opcional)

Se você não possui o Apache Maven instalado, pode baixar a versão mais recente [aqui](https://maven.apache.org/download.cgi).

### 4. Executar a Aplicação

Após configurar o ambiente, execute o seguinte comando no terminal:

```bash
mvn spring-boot:run
```

### 5. Credenciais de Login

Utilize as seguintes credenciais para fazer login na aplicação:

- **Email:** `magazine@example.com`
- **Senha:** `luiza`

### 6. Cadastro de Cliente (Opcional)

Você pode cadastrar um novo cliente caso deseje. Para isso, utilize a rota de registro.

---

## Estrutura do Banco de Dados

Caso necessário, crie um banco no MongoDB chamado **magazine** com a coleção **produtos**.

---

## Rotas Disponíveis

| Rota                                          | Descrição                        |
|-----------------------------------------------|----------------------------------|
| `http://localhost:8080/index`                | Página inicial                   |
| `http://localhost:8080/lista-desejos/meusdesejos` | Lista de Desejos (Wishlist)     |
| `http://localhost:8080/auth/carrinho`       | Compra com sucesso               |
| `http://localhost:8080/auth/login`           | Login                            |
| `http://localhost:8080/auth/register`        | Registro                         |

---

## Funcionalidades

- **Adicionar Produto à Lista de Desejos:** Na página de produtos, você pode adicionar produtos à sua lista de desejos.
- **Remover Produto da Lista de Desejos:** Na lista de desejos, clique em "X" para remover um produto.
- **Selecionar Forma de Pagamento:** Você pode escolher a forma de pagamento e concluir a compra.

### Segurança

A aplicação utiliza recursos do Spring Security para gerenciar o login e a senha, mas as rotas estão liberadas para testes de API REST.

---

## (Opcional) SonarCloud

1. Acesse [SonarCloud](https://sonarcloud.io) e crie uma conta.
2. Crie um novo projeto.
3. Selecione o projeto em seu GitHub ou GitLab.
4. Configure manualmente.
5. Crie a variável de ambiente e adicione o SonarCloud ao `pom.xml`.
6. Execute o seguinte comando:

```bash
mvn verify sonar:sonar
```

Isso retornará um relatório de dados da aplicação, onde você poderá verificar a qualidade do código.

---

## Considerações Finais

Sinta-se à vontade para explorar o código e fazer melhorias conforme necessário. Este projeto é uma ótima oportunidade para aprender sobre Spring Boot e MongoDB, além de desenvolver habilidades em segurança e gerenciamento de dependências.
