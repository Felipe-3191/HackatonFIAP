## Predio API
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/predio/{id}</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/predio/1' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #fff3e0; padding: 5px; border-radius: 5px; border: 2px solid #ff9800;">
  <button style="background-color: #ff9800; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">PUT</button>
  <span style="margin-left: 5px; color: #000000;">/predio/{id}</span>
</div>

```bash
curl -X 'PUT' \
  'http://localhost:8080/predio/1' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "FIAP HOTEL 1"
}'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/predio</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/predio' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/predio/nome/{nome}</span>
</div>


```bash
curl -X 'GET' \
  'http://localhost:8080/predio/nome/HOTEL%20FIAP%202' \
  -H 'accept: */*'
```

## Item API
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/item/{id}</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/items/1' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #fff3e0; padding: 5px; border-radius: 5px; border: 2px solid #ff9800;">
  <button style="background-color: #ff9800; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">PUT</button>
  <span style="margin-left: 5px; color: #000000;">/item/{id}</span>
</div>

```bash
curl -X 'PUT' \
  'http://localhost:8080/items/1' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "cerveja",
  "valor": 5.00
}'
```
<div style="display: flex; align-items: center; background-color: #ffe6e6; padding: 5px; border-radius: 5px; border: 2px solid #ff0000;">
  <button style="background-color: #ff0000; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">DELETE</button>
  <span style="margin-left: 5px; color: #000000;">/item/{id}</span></div>

```bash
curl -X 'DELETE' \
  'http://localhost:8080/items/1' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/item</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/items' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #e5f5e5; padding: 5px; border-radius: 5px; border: 2px solid #339933;">
  <button style="background-color: #339933; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">POST</button>
  <span style="margin-left: 5px; color: #000000;">/item</span></div>

```bash
curl -X 'POST' \
  'http://localhost:8080/items' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Coca cola",
  "valor": 6.50
}'
```
## Hotel API
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/{id}</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/hotel/1' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #fff3e0; padding: 5px; border-radius: 5px; border: 2px solid #ff9800;">
  <button style="background-color: #ff9800; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">PUT</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/{id}</span>
</div>

```bash
curl -X 'PUT' \
  'http://localhost:8080/hotel/{id}?id=1' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "HOTEL Teste",
  "endereco": {
    "id": 1,
    "logradouro": "rua teste logradouro 1",
    "cep": "23049512",
    "cidade": "Rio de Janeiro",
    "estado": "Rio de Janeiro"
  }
}'
```
<div style="display: flex; align-items: center; background-color: #ffe6e6; padding: 5px; border-radius: 5px; border: 2px solid #ff0000;">
  <button style="background-color: #ff0000; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">DELETE</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/{id}</span></div>

```bash
curl -X 'DELETE' \
  'http://localhost:8080/hotel/1' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/hotel</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/hotel' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #e5f5e5; padding: 5px; border-radius: 5px; border: 2px solid #339933;">
  <button style="background-color: #339933; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">POST</button>
  <span style="margin-left: 5px; color: #000000;">/hotel</span></div>

```bash
curl -X 'POST' \
  'http://localhost:8080/hotel' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '  {
    "id": 55,
    "nome": "HOTEL Teste",
    "endereco": {
      "id": 1,
      "logradouro": "rua teste logradouro 1",
      "cep": "23049512",
      "cidade": "Rio de Janeiro",
      "estado": "Rio de Janeiro"
    }
}
```
<div style="display: flex; align-items: center; background-color: #e5f5e5; padding: 5px; border-radius: 5px; border: 2px solid #339933;">
  <button style="background-color: #339933; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">POST</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/{idHotel}/item/{idItem}</span></div>

```bash
curl -X 'POST' \
  'http://localhost:8080/hotel/1/item/1' \
  -H 'accept: */*' \
  -d ''
```
<div style="display: flex; align-items: center; background-color: #ffe6e6; padding: 5px; border-radius: 5px; border: 2px solid #ff0000;">
  <button style="background-color: #ff0000; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">DELETE</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/{idHotel}/item/{idItem}</span></div>

```bash
curl -X 'DELETE' \
  'http://localhost:8080/hotel/1/item/2' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #e5f5e5; padding: 5px; border-radius: 5px; border: 2px solid #339933;">
  <button style="background-color: #339933; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">POST</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/{idHotel}/adicionarservico/{idServico}</span></div>

```bash
curl -X 'POST' \
  'http://localhost:8080/hotel/1/adicionarservico/1' \
  -H 'accept: */*' \
  -d ''
```
<div style="display: flex; align-items: center; background-color: #e5f5e5; padding: 5px; border-radius: 5px; border: 2px solid #339933;">
  <button style="background-color: #339933; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">POST</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/{hotelId}/predio</span></div>

```bash
curl -X 'POST' \
  'http://localhost:8080/hotel/1/predio' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "string"
}'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/nome/{nome}</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/hotel/nome/HOTEL%20FIAP%202' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/logradouro/{logradouro}</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/hotel/logradouro/rua%20teste%20logradouro%204' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/cep/{cep}</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/hotel/cep/41095421' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #ffe6e6; padding: 5px; border-radius: 5px; border: 2px solid #ff0000;">
  <button style="background-color: #ff0000; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">DELETE</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/{idHotel}/servico/{idServico}</span></div>

```bash
curl -X 'DELETE' \
  'http://localhost:8080/hotel/1/servico/3' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #ffe6e6; padding: 5px; border-radius: 5px; border: 2px solid #ff0000;">
  <button style="background-color: #ff0000; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">DELETE</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/{idHotel}/predio/{idPredio}</span></div>

```bash
curl -X 'DELETE' \
  'http://localhost:8080/hotel/3/predio/4' \
  -H 'accept: */*'
```

## Quarto API

<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/quartos/{id}</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/quartos/1' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #fff3e0; padding: 5px; border-radius: 5px; border: 2px solid #ff9800;">
  <button style="background-color: #ff9800; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">PUT</button>
  <span style="margin-left: 5px; color: #000000;">/quartos/{id}</span>
</div>

```bash
curl -X 'PUT' \
  'http://localhost:8080/quartos/1' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "id": 1,
  "predioId": 1,
  "hotelId": 1,
  "tipoQuarto": {
    "id": 1,
    "nomeTipo": "Standard Simples",
    "capacidadeTotal": 4,
    "quantidadeCamas": "2 x Queen Size",
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
  "valorDiaria": 200
}'
```
<div style="display: flex; align-items: center; background-color: #ffe6e6; padding: 5px; border-radius: 5px; border: 2px solid #ff0000;">
  <button style="background-color: #ff0000; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">DELETE</button>
  <span style="margin-left: 5px; color: #000000;">/quartos/{id}</span></div>

```bash
curl -X 'DELETE' \
  'http://localhost:8080/quartos/1' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #e5f5e5; padding: 5px; border-radius: 5px; border: 2px solid #339933;">
  <button style="background-color: #339933; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">POST</button>
  <span style="margin-left: 5px; color: #000000;">/quartos</span></div>

```bash
curl -X 'POST' \
  'http://localhost:8080/hotel/1/predio' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "string"
}'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/quartos/tipo/{tipo}</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/quartos/tipo/{tipo}' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/quartos/quantidadeHospedes/{quantidadeHospedes}</span></div>

```bash
curl -X 'GET' \
  'http://localhost:8080/quartos/quantidadeHospedes/2' \
  -H 'accept: */*'
```
## Servico API

<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/servicos/{id}</span></div>

```bash
curl -X 'GET' \
  'http://localhost:8080/servicos/1' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #fff3e0; padding: 5px; border-radius: 5px; border: 2px solid #ff9800;">
  <button style="background-color: #ff9800; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">PUT</button>
  <span style="margin-left: 5px; color: #000000;">/servicos/{id}</span>
</div>

```bash
curl -X 'PUT' \
  'http://localhost:8080/servicos/1' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Café da Manhã",
  "valor": 105
}'
```
<div style="display: flex; align-items: center; background-color: #ffe6e6; padding: 5px; border-radius: 5px; border: 2px solid #ff0000;">
  <button style="background-color: #ff0000; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">DELETE</button>
  <span style="margin-left: 5px; color: #000000;">/servicos/{id}</span></div>

```bash
curl -X 'DELETE' \
  'http://localhost:8080/servicos/1' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/servicos</span></div>

```bash
curl -X 'GET' \
  'http://localhost:8080/servicos' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #e5f5e5; padding: 5px; border-radius: 5px; border: 2px solid #339933;">
  <button style="background-color: #339933; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">POST</button>
  <span style="margin-left: 5px; color: #000000;">/servicos</span></div>

```bash
curl -X 'POST' \
  'http://localhost:8080/servicos' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "kit festa",
  "valor": 235
}'
```
## Cliente API

<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/clientes/{id}</span></div>

```bash
curl -X 'GET' \
  'http://localhost:8080/clientes/1' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #fff3e0; padding: 5px; border-radius: 5px; border: 2px solid #ff9800;">
  <button style="background-color: #ff9800; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">PUT</button>
  <span style="margin-left: 5px; color: #000000;">/clientes/{id}</span>
</div>

```bash
curl -X 'PUT' \
  'http://localhost:8080/clientes/1' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "paisOrigem": "Brasil",
  "cpf": "85908566071",
  "passaporte": "BG665764",
  "nome": "Felipe Santos",
  "dataNascimento": "1991-05-31",
  "enderecoPaisOrigem": "endereço 2 no brasil",
  "telefone": "412341234",
  "email": "leandro@teste.gmail.com"
}'
```
<div style="display: flex; align-items: center; background-color: #ffe6e6; padding: 5px; border-radius: 5px; border: 2px solid #ff0000;">
  <button style="background-color: #ff0000; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">DELETE</button>
  <span style="margin-left: 5px; color: #000000;">/clientes/{id}</span></div>

```bash
curl -X 'DELETE' \
  'http://localhost:8080/clientes/1' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/clientes</span></div>

```bash
curl -X 'GET' \
  'http://localhost:8080/clientes' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #e5f5e5; padding: 5px; border-radius: 5px; border: 2px solid #339933;">
  <button style="background-color: #339933; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">POST</button>
  <span style="margin-left: 5px; color: #000000;">/clientes</span></div>

```bash
curl -X 'POST' \
  'http://localhost:8080/clientes' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d ' {
    "paisOrigem": "Rússia",
    "cpf": "25930651094",
    "passaporte": "UK414192",
    "nome": "Leandro Costa",
    "dataNascimento": "1994-12-19",
    "enderecoPaisOrigem": "endereço qualquer na Rússia",
    "telefone": "996983755",
    "email": "leandro@teste.gmail.com"
  }'
```

<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/clientes/cpf/{cpf}</span></div>

```bash
curl -X 'GET' \
  'http://localhost:8080/clientes/cpf/91447994035' \
  -H 'accept: */*'
```