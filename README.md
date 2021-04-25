#Inter Java Developer
##Projeto da Digital Innovation: Criando seu gerenciador de super heróis da Marvel e da DC em uma API reativa com Spring Boot

Projeto realizado para estudo de desenvolvimento de API Responsiva com Webflux.

### Customizações: 
* Criados diferentes heróis; 
* Novos testes (listAll e createHero);
* Caminho da API padronizada para boas práticas.


###Caminho da API
```
http://localhost:8080/api/v1/heroes
```

### Instruções Padrões sobre o DynamoDB:

Na pasta em que o jar está baixado: java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb

Para listar as tabelas criadas:  aws dynamodb list-tables --endpoint-url http://localhost:8000