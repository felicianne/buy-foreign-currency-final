## Grupo
   - Renara Secchim
   - Camila Cerqueira
   - Luciana Mendes
   - Felicianne Nogueira
   - Carol Thiengo 

# buy-foreign-currency
Este projeto Java tem o objetivo de permitir que os usuários realizem ordens de compra de moedas estrangeiras de forma eficiente e conveniente, consumindo a API externa https://docs.awesomeapi.com.br/api-de-moedas para obter as taxas de câmbio. O sistema será composto por um back-end Java que lida com a lógica de negócios, integração com a API externa e armazenamento de dados.

## Funcionalidades
- 🪙 Consumir a Api externa https://economia.awesomeapi.com.br/USD-BRL
- 🔒 Cadastro, leitura, atualização e exclusão usuários.
- 🚀 Realização de order de compra de moeda.
- 📦 Cálculo do valor total com base na quantidade desejada e na taxa de câmbio
  atual.
- 🪙 Seleção da moeda estrangeira desejada (USD ou EUR).

## Pré-requisitos
Antes de iniciar, certifique-se de ter as seguintes dependências instaladas:

- Java Development Kit (JDK) - Versão 17 ou superior.
- Maven

## Configuração
Clone o repositório:

```bash
git clone https://github.com/Ar3secchim/buy-foreign-currency

cd buy-foreign-currency
```

## 1. Create (Criar)
O CRUD começa com a operação de criação, que envolve registro de novos.
Para criar uma ordem precisa está registrado.

Exemplo de Criação (Create) - Criando um usuário:

###  POST createUSer

``http://localhost:8080/user``

#### Request Body
```json
  {
    "nome": "nameUser",
    "cpf": "12345678965",
    "dataDeNascimento": 1997,
    "estadoCivil": "casado",
    "sexo": "F",
    "senha": "********"
  }
```

#### Response body
```json
  {
    "id": 1,
    "nome": "nameUser",
    "cpf": "12345678965"
  }
```

###  POST createOrder
Precisa de um usuário criado assim poderá criar uma order

``http://localhost:8081/order``

#### Body resquest para moeda "USD" (dolár)
```json
  {
     "cpfUser":"12345678985",
     "typeCurrency": "USD",
     "valueForeignCurrency": 3500
  }
```

#### Response
```json
  {
    "id": 1,
    "idUser": 1,
    "cpfUser": "12345678985",
    "requestDate": "2023-10-28T09:31:54.1988733",
    "typeCurrency": "USD",
    "valueForeignCurrency": "3,500.00",
    "quotationValue": "5.02",
    "valueTotalOperation": "17,552.50",
    "withdrawalAgencyNumber": "4448"
  }
```

#### Body resquest para moeda "EUR" (euro)
```json
  {
     "cpfUser":"12345678985",
     "typeCurrency": "USD",
     "valueForeignCurrency": 3500,
     "withdrawalAgencyNumber":"5555"
  }
```

#### Response
```json
  {
    "id": 2,
    "idUser": 1,
    "cpfUser": "02083631226",
    "requestDate": "2023-10-28T09:33:28.9075152",
    "typeCurrency": "EUR",
    "valueForeignCurrency": "3,500.00",
    "quotationValue": "5.29",
    "valueTotalOperation": "18,530.75",
    "withdrawalAgencyNumber": "5555"
  }
```

## Tecnologias Utilizadas
- 💻 Linguagem de Programação: Java 17
- 💻 Framework: Spring Boot
- 💻 Banco de dados: H2 Dialect

## Maiores Desafios

- Fazer requisição para uma API externa
- Manipular dados de uma resposta de requisição para API externa
- Aplicação de design SOLID 
