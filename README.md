Backend Java  
Desafio Magazine Luiza (Luizalabs)
Aplicaçao Speing boot java com MongoDB(NOSQL)
Java
Spring Boot(Dev Tools, Mongo, Liveload(starter)
Mongo (NOSql)
Html
CSS

------------------------------Passos------------------------

1- Installar Java 17

2- Installar Mongo

3- instale apache maven (opcional)

4- rode ou execute:  mvn spring-boot:run 

5 - Utilize o email : magazine@example.com 

e senha: luiza    para fazer o login (usuario padrao)

6- Voce pode cadastrar um (cliente) usuario caso quiser

(pcional)  Caso necessario crie um banco no mongo chamado magazine com colecao produtos

na pagina de produtos  voce pode adicionar um produto a Lista de desejos

na lista de desejos http://localhost:8080/lista-desejos/meusdesejos

voce pode clicar em  X para remover um produto

Pode tambem selecionar a forma de Pagamento e concluir 


--------------------------------------------------------------------------------------------------------------------------------------
Mesmo com recussos do Spring Security, Login, Password(senha)

As rotas estao liberadas para teste de Rest

http://localhost:8080/index   (pagina inicial)

http://localhost:8080/lista-desejos/meusdesejos (lista de Desejos Wishlis)

http://localhost:8080/auth/carrinho (compra com sucesso)

http://localhost:8080/auth/login  (login)

http://localhost:8080/auth/register (registro)

---------------------------------------------------------------------------------------------------------------------------------------

---------------------(OPCIONAL SonarCloud) -----------------

1- https://sonarcloud.io  crie uma conta 

2- crie um novo projeto 

3- seleciona o projeto em seu github ou gitlab

4- Configure manual

5- Crie a variavel de ambiente e adicione o sonarcloud ao pom.xml

6-  execute : mvn verify sonar:sonar

Retornara o relatario de dados da aplicaçao
e voce vera que passa em qualidade 







