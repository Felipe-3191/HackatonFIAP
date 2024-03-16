# Hackaton
## Projeto do curso de Pós-Graduação da FIAP

## Grupo 50

- [Daniel Santiago](https://github.com/SantiagoDDaniel)
- [Kassiane Silva Mentz](https://github.com/kassimentz)
- [Leandro Paulino Costa](https://github.com/LeandroPC)
- [Luiz Felipe da Silva Santos](https://github.com/Felipe-3191)
- [Vitor Hugo Campos Alves](https://github.com/vitorAlves1992/)

## Hackaton (11/03/2024 até 15/03/2024)

**Objetivos:**

Criar um sistema, que atenda um dos clientes do cenário acima descrito, considerando que o sistema
em questão deve possuir as seguintes funcionalidades:


## Gestão de Quartos

o módulo de Gestão de Quartos, faz a gestão (Inclusão, Atualização, Deleção,Consulta) de todos os quartos por propriedade, ou seja, caso tenhamos mais de uma localidade ou prédio,o módulo consegue diferenciar quais quartos estão em qual prédio de qual localidade. Esse módulo é
responsável por gerir cada característica dos quartos, prédios e localidades

### API Gestão de Quartos
[Gestao Quartos API](https://github.com/Felipe-3191/HackatonFIAP/blob/main/doc/gestaoQuartosAPI.md)


---



## Gestão de Serviços e Opcionais 
O módulo de Gestão de Serviços e Opcionais, faz a gestão (Inclusão,
Atualização, Deleção, Consulta) todos os serviços extras que o Hotel oferece e os opcionais que podem existir.
Estes opcionais são itens ou serviços que podem ser adicionados à reserva, cada um tem seu valor
único podendo ser por pessoa e/ou quarto.
### API Gestão de Serviços e Opcionais
[Gestao Servicos e Opcionais API](https://github.com/Felipe-3191/HackatonFIAP/blob/main/doc/gestaoServicosEOpcionaisAPI.md)

---

## Gestão de Clientes 
O módulo de Gestão de Clientes, faz a gestão (Inclusão, Atualização, Deleção,
Consulta) de dados de clientes, neste módulos teremos os seguintes dados que serão utilizados:
● ID: número único, interno ao banco de dados (obrigatório)
● País de Origem: qual o país de nascimento do cliente (obrigatório)
● CPF: documento de número único no Brasil (obrigatório de Brasileiro)
● Passaporte: documento de número único no País de Origem (obrigatório se estrangeiro)
● Nome Completo (obrigatório)
● Data de Nascimento (obrigatório)
● Endereço no País de Origem (obrigatório)
● Telefone (obrigatório)
● Email (obrigatório)


### API Gestão de Clientes
[Gestao Clientes API](https://github.com/Felipe-3191/HackatonFIAP/blob/main/doc/gestaoDeClientesAPI.md)

## Gestão de Reservas

o módulo de Gestão de reservas é o grande agregador, este módulo acessa fará a gestão das reservas, ou seja, que cliente, quais as datas de entrada e saída, quantas pessoas e quartos e se há disponibilidade.
Este módulo é responsável por gerir os seguintes itens:
● Gerir as Reservas (Inclusão, Atualização, Deleção, Consulta)
● Gerir as datas disponíveis por quartos o Quartos podem ser bloqueados com a reserva de um hóspede ou simplesmente ser bloqueado no módulo, tornando-o indisponível para reservas (reserva do
administrador)
● Gestão dos Serviços e Opcionais inclusos na Reserva
● Calcular o valor total da conta do cliente
● Envio de E-mails de confirmação

### API Gestão de Reservas
[Gestao de Reservas API](https://github.com/Felipe-3191/HackatonFIAP/blob/main/doc/gestaoDeReservasAPI.md)



---

## Entregáveis:
1. Repositório público no Github que contenha todo o código da solução.
https://github.com/Felipe-3191/HackatonFIAP

2. Vídeo de 4 minutos com uma apresentação do Sistema, contendo:
a. Arquitetura adotada
b. Demonstração da Solução (demonstrar os casos de uso e os endpoints)
c. Fazer o upload no Youtube em um canal não listado, e colocar o link da documentação
[Link do Vídeo Youtube](https://www.youtube.com/watch?v=xqR5UUradx0)

3. Documentação em PDF contendo:
a. Diagrama mostrando a Arquitetura do Sistema
[Arquitetura do Sistema](https://github.com/Felipe-3191/HackatonFIAP/blob/main/doc/arquitetura.md)

b. Documentação dos casos de Teste, e seus resultados, bem como exemplos para que os Mentores e Mentoras possam replicar.
[Documentação Casos de Testes](https://github.com/Felipe-3191/HackatonFIAP/blob/main/doc/documentacaoCasosTestes.md)

c. Documentação do(s) bancos de dados utilizados, mostrando os diagramas e estruturas utilizadas.
  [Documentação BD](https://github.com/Felipe-3191/HackatonFIAP/blob/main/doc/documentacaoBD.md)

d. Link para o Github do Projeto
[Hackaton Github](https://github.com/Felipe-3191/HackatonFIAP)
e. Link para o Vídeo do Projeto
[Link do Vídeo Youtube](https://www.youtube.com/watch?v=xqR5UUradx0)

1. Pontos obrigatórios do Projeto:
a. Todo o projeto deverá ser entregue dockerizado, ou seja, vocês devem entregar o os arquivos de configuração do Docker e a imagem. Os professores devem ser capazes de simplesmente executar o docker-compose up e o Container da aplicação subir com a aplicação pronta para uso.
b. Utilização de Swagger para as documentação das APIs
c. Criar todo o código utilizando as melhores práticas de Qualidade de Software e Clean Architecture.
d. Deixar um Curl para cada endpoint na documentação do projeto
e. Na documentação deve conter um print com a cobertura de testes do projeto
![](./doc/coberturaTestes.jpeg)
55% de cobertura de testes