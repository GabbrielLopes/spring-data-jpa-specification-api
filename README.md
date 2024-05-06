# spring-data-jpa-specification-api

Esse modelo se chama "JPA Specification" o legal é que é executada uma query dinâmica em tempo de execução.
Nesse modelo, é comum usarmos o método POST para fazer a consulta, pois enviamos os filtros via Request Body...

## 🚀 Começando

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento e teste.

### 📋 Pré-requisitos

De que coisas você precisa para instalar o software e como instalá-lo?

```
Docker - para subir o banco
IDE de sua preferência - para rodar o projeto
```

### 🔧 Instalação

Uma série de exemplos passo-a-passo que informam o que você deve executar para ter um ambiente de desenvolvimento em execução.

Primeiramente clone o projeto.

```
Suba o banco com o docker, docker-compose up -d (imagem com banco mysql)
Dê uma carga de dados com o arquivo MOCK_DATA.csv que está na raiz do projeto pelo seu SGBD
```

Em seguida

```
Suba a aplicação e já poderemos testar

curl --location 'localhost:8080/v1/company/specification' \
--header 'Content-Type: application/json' \
--data '{
    "searchRequestDTO": [
        {
            "columnName": "nomeGuerra",
            "value": "facebook inc.",
            "operator": "IGUAL"
        },
        {
            "columnName": "telefone",
            "value": "41235875573",
            "operator": "IGUAL"
        }
    ]
}'
```

## 🛠️ Construído com

* [SpringBoot](https://start.spring.io/)
* [Maven](https://maven.apache.org/)
* [SpringDataJpa](https://spring.io/projects/spring-data-jpa)
* [Lombok](https://projectlombok.org/)
* [MySQL](https://www.mysql.com/)
