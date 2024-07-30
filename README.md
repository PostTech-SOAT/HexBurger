# Hexburguer

Integrantes:

- Gabriel Rabello de Menezes - RM354702
- Giovanna Caroline Adorno - RM356178
- Guilherme Rodriguero de Souza - RM356181
- Leandro Airton Bezerra - RM355426
- Willian Novais Planciunas - RM354475

### HexBurger

O projeto a seguir é um sistema para a hamburgueria HexBurger, que possui como especialidade a confecção de hambúrgueres no formato hexagonal.

O objetivo do projeto é otimizar os processos de cada filial da rede. A primeira entrega consiste na gestão de clientes, produtos e pedidos.

A seguir, temos uma documentação em Event Storming da solução e um passo a passo para executar a aplicação:

### Tech Challenge primeira entrega:

Link para o Miro: [DDD-Miro](https://miro.com/app/board/uXjVKYystBE=/)

Instruções para executar o projeto:

- Clonar o projeto
- A partir do diretório raíz do projeto, executar o build e subir o a aplicação via docker compose
- `docker compose up --build`

O projeto iniciará na porta 8080 e a documentação das APIs pode ser consultada através do link [swagger-ui](http://localhost:8080/swagger-ui/index.html.)

### Tech Challenge segunda entrega:

Vídeo: [2º entrega FIAP-POSTECH 7SOAT](https://youtu.be/8XMpgdVlYJY)
Resultado dos testes: [Resultado](infra/test/reports/)

Arquitetura de infraestrutura do projeto:

![./public/arquitetura-infra-hexburguer.drawio-2.svg](./public/arquitetura-infra-hexburguer.drawio-2.svg)

arquitetura-infra-hexburguer.drawio-2.svg

### Infraestrutura

Os recursos as ferramentas usadas para essa infraestrutura foram:

Kubernetes local;

Helm.

Foi criado uma chart com `helm create default-chart` no diretório `./infra/helm`;

Cada deploy foi separado por um diretório contendo cada um seu values.yaml que será usado para ler as variáveis de release do chart.

**postgres-deploy:** Deployment; Pv; Pvc; Service-ClusterIP; ConfigMap; ServiceAccount.

**hexburguer-deploy:** Deployment; HPA; Service-LoadBalancer; ServiceAccount.

Para executar os deploy das charts basta você digitar no root do projeto:

**postgres-deploy:** `helm install postgres-deploy infra/helm/postgres-deploy/charts/default-chart-0.1.0.tgz -f infra/helm/postgres-deploy/values.yaml`

**hexburguer-deploy:** `helm install hexburguer-deploy infra/helm/hexburguer-deploy/charts/default-chart-0.1.0.tgz -f infra/helm/hexburguer-deploy/values.yaml` 

**hexburguer-metrics:** `kubectl apply -f infra/helm/hexburguer-deploy/metrics.yaml`

O projeto iniciará na porta 8080 e a documentação das APIs pode ser consultada através do link [swagger-ui](http://localhost:8080/swagger-ui/index.html.)

### Desenho da Arquitetura do software (contexto de Cliente):

https://github.com/user-attachments/assets/c89bfad1-17db-4af6-ad4d-fbe6a602bbd8

image

A API pode ser usada na seguinte forma:

1 - Criar Cliente (POST: v1/cliente):

```json
{  "cpf": "12345678901",  "nome": "João da Silva",  "email": "joao@email.com"}
```

2 - Criar um Produto (POST: v1/produto):

```json
{  "nome": "Hex Burger",  "descricao": "Pão e Hambuguer no formato hexagonal",  "valor": 20,  "categoria": "LANCHE"}
```

3 - Cria outro Produto (POST: v1/produto):

```json
{  "nome": "Sorvete",  "descricao": "Sorvete Gelado",  "valor": 7,  "categoria": "SOBREMESA"}
```

4 - Criar um Pedido (POST: v1/pedido):

```json
{  "combos": [    {      "produtos": [        {          "id": "idProduto1"        },        {          "id": "idProduto2"        },      ]    }  ],  "cliente": {  "cpf": "12345678901",  "nome": "João da Silva",  "email": "joao@email.com"  }}
```

5 - Verificar lista de Pedidos ordenadas por Status do Pedido e Data do Pedido: (GET: v1/pedido):

6 - Verificar o Status do Pagamento do Pedido (GET: v1/pedido/status/{id}):