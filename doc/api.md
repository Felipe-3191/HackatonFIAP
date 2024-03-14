## Predio API 
### Get /predio/id
```bash
curl -X 'GET' \
  'http://localhost:8080/predio/1' \
  -H 'accept: */*'
```
### Put /item/

```bash
curl -X 'PUT' \
  'http://localhost:8080/items/1' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "novo nome item",
  "valor": 15
}'
```