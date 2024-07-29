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
- A partir do diretório raíz do projeto, executar o build do docker compose

- `docker compose build`

- Após a imagem devidamente criada, subir a aplicação via docker compose

- `docker compose up`

O projeto iniciará na porta 8080 e a documentação das APIs pode ser consultada através do link [swagger-ui](http://localhost:8080/swagger-ui/index.html.)

### Tech Challenge segunda entrega:

Arquitetura de infraestrutura do projeto:

![arquitetura-infra-hexburguer.drawio-2.svg](./public/arquitetura-infra-hexburguer.drawio-2.svg)

### Infraestrutura

Os recursos as ferramentas usadas para essa infraestrutura foram:

Kubernetes local;

Helm.

Foi criado uma chart com `helm create default-chart` no diretório `./infra/helm`;

Cada deploy foi separado por um diretório contendo cada um seu values.yaml que será usado para ler as variáveis de release do chart.

postgres-deploy:

Deployment;

Pv;

Pvc;

Service-ClusterIP;

ConfigMap;

ServiceAccount.

hexburguer-deploy:

Deployment;

HPA;

Service-LoadBalancer;

ServiceAccount.

Para executar os deploy das charts basta você digitar no root do projeto:

Docker Build: `docker build . -t hexburguer-api`

postgres-deploy: `helm install postgres-deploy infra/helm/postgres-deploy/charts/default-chart-0.1.0.tgz -f infra/helm/postgres-deploy/values.yaml`

hexburguer-deploy: `helm install hexburguer-deploy infra/helm/hexburguer-deploy/charts/default-chart-0.1.0.tgz -f infra/helm/hexburguer-deploy/values.yaml`
