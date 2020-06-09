# java-firebase-crud
Projeto em Java Swing para operações de CRUD (Create, Read, Update e Delete) no banco de dados do Google Firebase.

Para utilizar a sua collection do Firebase:

1) Coloque suas credenciais no arquivo:
```
./credentials.json
```

2) Na classe Conexao, coloque a URL do seu banco Firebase no seguinte atributo:
```
String databaseURL = "https://aps2020especies.firebaseio.com/";
```

3) Utilizando o console do Firebase, crie uma collecion com a seguinte estrutura:
```
    id: String;
    nome: String;
    email: String;
```    

* Para acrescentar novas colunas para o usuário, altere o model:

```/src/main/java/model/UsuarioModel.java```

* Para novas collecions, crie a estrutura no console do Firebase e também um model, no diretório:
```
/src/main/java/model
```
