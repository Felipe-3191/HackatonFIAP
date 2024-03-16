# Casos de Teste

Para facilitar os testes, uma massa de dados é inserida a cada execução da aplicação, portanto, é possível realizar buscas, alterações, exclusões sem que seja necessário um cadastro prévio.

Na documentação também há um exemplo de cada API sendo consumida através do cURL.

Focaremos nem alguns casos de testes para exemplificar cada módulo pedido


## Módulo Gestão de Quartos 

### Criar Quarto 
Executar Curl 
```bash

curl -X 'POST' \
  'http://localhost:8080/quartos' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "idPredio": 1,
  "idTipoQuarto": 1,
  "status": "DISPONIVEL",
  "valorDiaria": 240
}'

```
O retorno deve ser 200 OK com um exemplo do quarto criado 

Executar Curl 
```bash
curl -X 'GET' \
  'http://localhost:8080/quartos/35' \
  -H 'accept: */*'
```

O retorno deve ser 

```json
{
  "id": 35,
  "predioId": 1,
  "hotelId": 1,
  "tipoQuarto": {
    "id": 1,
    "nomeTipo": "Standard Simples",
    "capacidadeTotal": 2,
    "quantidadeCamas": "1 x Queen Size",
    "moveis": [
      {
        "id": 1,
        "nome": "1 x Sofá"
      },
      {
        "id": 2,
        "nome": "2 x Poltronas"
      },
      {
        "id": 3,
        "nome": "1 x Frigobar"
      },
      {
        "id": 4,
        "nome": "1 x TV Led 54 pols"
      },
      {
        "id": 5,
        "nome": "1 x Mesa de Escritório"
      },
      {
        "id": 6,
        "nome": "1 x Cadeira de Escritório"
      }
    ]
  },
  "status": "DISPONIVEL",
  "valorDiaria": 240
}
```

## Indisponibilizar Quarto
Consumir o Endpoint 

```bash
curl -X 'PUT' \
  'http://localhost:8080/quartos/indisponibilizar/4' \
  -H 'accept: */*'
```

O resultado é o o quarto com status indisponível a partir desse momento.


---

## Módulo Gestão de Clientes 
### Criar Cliente

Executar Curl 
```
curl -X 'POST' \
  'http://localhost:8080/clientes' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{

  "paisOrigem": "Brasil",
  "cpf": "85908566072",
  "passaporte": "BG665764",
  "nome": "Felipe Santos",
  "dataNascimento": "1991-05-31",
  "enderecoPaisOrigem": "endereço qualquer no brasil",
  "telefone": "412341234",
  "email": "felipe@teste.gmail.com"
}'

```


O Resultado deve ser 
```
{

  "paisOrigem": "Brasil",
  "cpf": "85908566072",
  "passaporte": "BG665764",
  "nome": "Felipe Santos",
  "dataNascimento": "1991-05-31",
  "enderecoPaisOrigem": "endereço qualquer no brasil",
  "telefone": "412341234",
  "email": "felipe@teste.gmail.com"
}
```

### Teste Validação Passaporte 

Executar Curl 
```
{

  "paisOrigem": "Portugal",
  "cpf": "85908566072",
  "nome": "Felipe Santos",
  "dataNascimento": "1991-05-31",
  "enderecoPaisOrigem": "endereço qualquer no brasil",
  "telefone": "412341234",
  "email": "felipe@teste.gmail.com"
}
```


O Resultado deve ser 
```
{
  "message": "Passaporte deve ser informado para estrangeiros"
}
```


---

## Módulo Gestão de Ítens e Serviços

### Criar Item 

Executar Curl
```bash
curl -X 'POST' \
  'http://localhost:8080/items' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "guaraná",
  "valor": 10
}'
```

O Resultado deve ser 
```bash
{
  "id": 6,
  "nome": "guaraná",
  "valor": 10
}

```

### Associar Item ao Hotel para Que ele possa ser ofertado 
Executar Curl 

```bash
curl -X 'POST' \
  'http://localhost:8080/hotel/1/item/6' \
  -H 'accept: */*' \
  -d ''
```
O resultado deve ser (a massa de dados já traz alguns ítens associados aos hotéis, atentar para o item guaraná que foi criado)
```bash

{
  "id": 1,
  "nome": "HOTEL FIAP 1",
  "endereco": {
    "id": 1,
    "logradouro": "rua teste logradouro 1",
    "cep": "23049512",
    "cidade": "Rio de Janeiro",
    "estado": "Rio de Janeiro"
  },
  "itens": [
    {
      "id": 2,
      "nome": "Sucos",
      "valor": 13
    },
    {
      "id": 3,
      "nome": "Cervejas Nacionais",
      "valor": 15
    },
    {
      "id": 6,
      "nome": "guaraná",
      "valor": 10
    },
    {
      "id": 1,
      "nome": "Refrigerantes",
      "valor": 9
    }
  ]
}
```

## Listar Ítens Ofertados pelo Hotel

Executar Curl 

```bash
curl -X 'GET' \
  'http://localhost:8080/hotel/1/itens' \
  -H 'accept: */*'
```
O resultado deve ser 
```json
[
  {
    "id": 1,
    "nome": "Refrigerantes",
    "valor": 9
  },
  {
    "id": 2,
    "nome": "Sucos",
    "valor": 13
  },
  {
    "id": 3,
    "nome": "Cervejas Nacionais",
    "valor": 15
  },
  {
    "id": 6,
    "nome": "guaraná",
    "valor": 10
  }
]
```

Os serviços funcionam de forma igual, bastando substituir nos endereços dos endpoints a palavra "itens" por "servicos"

---
## Gestão de Reserva 
Todos os cruds estão disponíveis na documentação da API conforme citado acima, vamos focar no caso de uso de fazer uma reserva 

### Buscar Recomendação de Quartos 
Endpoint que recebe um período, uma quantidade de pessoas e uma quantidade de recomendações desejadas. Gera o número de recomendações de quartos disponíveis dentro daquele período (é o UseCase desse endpoint que usa o backtracking para achar todas as combinações possíveis e colocamos um limitador recebido por parâmetro para fins de usabilidade)

Executar o Curl

```
curl -X 'POST' \
  'http://localhost:8080/quarto/recomendarQuartos' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "dataInicio": "2024-03-22",
  "dataFim": "2024-04-28",
  "quantidadePessoas": 5,
  "numeroSugestoes": 5
}'

```

O resultado é uma lista de lista de quartos contendo o número suficiente para atender a quantidade de pessoas.

```
[
  [
    {
      "id": 18,
      "tipoQuarto": {
        "id": 6,
        "nomeTipo": "Premium Duplo",
        "capacidadeTotal": 4,
        "quantidadeCamas": "2 x King Size",
        "moveis": null
      },
      "status": "DISPONIVEL",
      "valorDiaria": 650
    },
    {
      "id": 10,
      "tipoQuarto": {
        "id": 5,
        "nomeTipo": "Premium Simples",
        "capacidadeTotal": 1,
        "quantidadeCamas": "1 x King Size",
        "moveis": null
      },
      "status": "DISPONIVEL",
      "valorDiaria": 450
    }
  ],
  [
    {
      "id": 18,
      "tipoQuarto": {
        "id": 6,
        "nomeTipo": "Premium Duplo",
        "capacidadeTotal": 4,
        "quantidadeCamas": "2 x King Size",
        "moveis": null
      },
      "status": "DISPONIVEL",
      "valorDiaria": 650
    },
    {
      "id": 26,
      "tipoQuarto": {
        "id": 5,
        "nomeTipo": "Premium Simples",
        "capacidadeTotal": 1,
        "quantidadeCamas": "1 x King Size",
        "moveis": null
      },
      "status": "DISPONIVEL",
      "valorDiaria": 450
    }
  ],
  [
    {
      "id": 18,
      "tipoQuarto": {
        "id": 6,
        "nomeTipo": "Premium Duplo",
        "capacidadeTotal": 4,
        "quantidadeCamas": "2 x King Size",
        "moveis": null
      },
      "status": "DISPONIVEL",
      "valorDiaria": 650
    },
    {
      "id": 27,
      "tipoQuarto": {
        "id": 5,
        "nomeTipo": "Premium Simples",
        "capacidadeTotal": 1,
        "quantidadeCamas": "1 x King Size",
        "moveis": null
      },
      "status": "DISPONIVEL",
      "valorDiaria": 450
    }
  ],
  [
    {
      "id": 18,
      "tipoQuarto": {
        "id": 6,
        "nomeTipo": "Premium Duplo",
        "capacidadeTotal": 4,
        "quantidadeCamas": "2 x King Size",
        "moveis": null
      },
      "status": "DISPONIVEL",
      "valorDiaria": 650
    },
    {
      "id": 11,
      "tipoQuarto": {
        "id": 5,
        "nomeTipo": "Premium Simples",
        "capacidadeTotal": 1,
        "quantidadeCamas": "1 x King Size",
        "moveis": null
      },
      "status": "DISPONIVEL",
      "valorDiaria": 450
    }
  ],
  [
    {
      "id": 18,
      "tipoQuarto": {
        "id": 6,
        "nomeTipo": "Premium Duplo",
        "capacidadeTotal": 4,
        "quantidadeCamas": "2 x King Size",
        "moveis": null
      },
      "status": "DISPONIVEL",
      "valorDiaria": 650
    },
    {
      "id": 12,
      "tipoQuarto": {
        "id": 5,
        "nomeTipo": "Premium Simples",
        "capacidadeTotal": 1,
        "quantidadeCamas": "1 x King Size",
        "moveis": null
      },
      "status": "DISPONIVEL",
      "valorDiaria": 450
    }
  ]
]
```

### Iniciar Reserva 

Após decidir qual conjunto de quartos disponíveis escolher, o front end mostraria quais serviços e ítens estão disponíveis, após decidir, consumir o seguinte endereço:

```bash
curl -X 'POST' \
  'http://localhost:8080/reservas' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "idCliente": 1,
  "idQuartos": [
    1
  ],
  "dataInicio": "2024-03-16",
  "dataFim": "2024-03-18",
  "servicos": [
    {
      "idServico": 1,
      "quantidade": 2
    }
  ],
  "itens": [
    {
      "idItem": 1,
      "quantidade": 2
    }
  ],
  "quantidadePessoas": 2
}'
```
O Resultado deve ser 

```json
{
  "id": 6,
  "dataInicial": "2024-03-16",
  "dataFinal": "2024-03-18",
  "valorReserva": 200,
  "valorTotal": 548,
  "quantidadePessoas": 2,
  "responsavelReserva": "Felipe Santos",
  "tipoQuarto": [
    "Standard Simples"
  ],
  "servicosConsumidos": [
    {
      "nome": "Café da Manhã"
    }
  ],
  "itensConsumidos": [
    {
      "nome": "Refrigerantes"
    }
  ]
}
```
Por fim, o front deve redirecionar para a última tela de confirmar reserva. Ao clicar em confirmar o seguinte endpoint será consumido

```
curl -X 'POST' \
  'http://localhost:8080/confirmar/6' \
  -H 'accept: */*' \
  -d ''
```

O resultado desse consumo é a reserva efetivada e um email de confirmação sendo enviado para o cliente que a efetuou. Para testar o envio de email, favor consumir o endpoint de cadastro de cliente (pode-se usar o exemplo acima), colocando algum email pessoal no lugar do email que está. Um exemplo do formato do email foi mostrado no vídeo de apresentação também.