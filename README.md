<h1>Inter Java Developer</h1>   
<h2>Projeto da Digital Innovation: Criando seu gerenciador de super heróis da Marvel e da DC em uma API reativa com Spring Boot</h2>

Projeto realizado para estudo de desenvolvimento de API Responsiva com Webflux.

<h3>Customizações:</h3> 
* Criados diferentes heróis; 
* Novos testes (listAll e createHero);
* Caminho da API padronizada para boas práticas.


<h3>Caminho da API</h3>
```
http://localhost:8080/api/v1/heroes
```
<h3>Instruções Padrões sobre o DynamoDB:</h3>

Na pasta em que o jar está baixado: java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb

Para listar as tabelas criadas:  aws dynamodb list-tables --endpoint-url http://localhost:8000