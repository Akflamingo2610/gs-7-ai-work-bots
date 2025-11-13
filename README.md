# GS-7-AI-Work-Bots

## Informações do Grupo

### Membros do Grupo
- **Membro 1:** [Lucas Thomazette Benvenuto ]
- **RM:** [RM 98048]

- **Membro 2:** [Pedro Loterio dos Santos]
- **RM:** [RM 550909]

## Descrição do Tema Escolhido

**Tema:** Bots e agentes de IA como parceiros no dia a dia de trabalho

Esta API foi desenvolvida para demonstrar a integração de bots e agentes de IA como parceiros no ambiente de trabalho. A solução visa facilitar a automação de tarefas rotineiras, melhorar a produtividade e proporcionar assistência inteligente no dia a dia profissional.

## Resumo da Finalidade da API

Esta API Spring Boot fornece informações sobre o tema do projeto através de um endpoint REST. A API foi desenvolvida seguindo as melhores práticas de desenvolvimento, incluindo documentação Swagger/OpenAPI, dockerização e pipelines de CI/CD automatizados.

### Endpoint Principal
- **GET /info**: Retorna informações sobre o tema, membros do grupo e descrição do projeto em formato JSON.

## Instruções de Execução Local

### Pré-requisitos
- Java 21 ou superior
- Maven 3.6 ou superior
- Docker (opcional, para execução via container)

### Executando a Aplicação

#### Opção 1: Via Maven
```bash
# Navegar até o diretório do projeto
cd gs-7-ai-work-bots

# Compilar e executar
mvn spring-boot:run
```

#### Opção 2: Via JAR
```bash
# Compilar o projeto
mvn clean package

# Executar o JAR gerado
java -jar target/gs-7-ai-work-bots-0.0.1-SNAPSHOT.jar
```

#### Opção 3: Via Docker
```bash
# Baixar a imagem do Docker Hub (já publicada)
docker pull akflamingo2610/gs-7-ai-work-bots:latest

# Executar o container
docker run -p 8081:8081 akflamingo2610/gs-7-ai-work-bots:latest

# Construir a imagem Docker
docker build -t gs-7-ai-work-bots:latest .

# Executar o container
docker run -p 8081:8081 gs-7-ai-work-bots:latest
```

### Acessando a API

Após iniciar a aplicação, a API estará disponível em:
- **URL Base:** http://localhost:8081
- **Endpoint de Informações:** http://localhost:8081/info
- **Swagger UI:** http://localhost:8081/swagger-ui.html
- **API Docs (JSON):** http://localhost:8081/api-docs

### Exemplo de Resposta do Endpoint /info
```json
{
  "tema": "Bots e agentes de IA como parceiros no dia a dia de trabalho",
  "membro1": "Lucas Thomazette Benvenuto",
  "membro2": "Pedro Loterio dos Santos",
  "descricao": "Esta API foi desenvolvida para demonstrar a integração de bots e agentes de IA como parceiros no ambiente de trabalho. A solução visa facilitar a automação de tarefas rotineiras, melhorar a produtividade e proporcionar assistência inteligente no dia a dia profissional."
}
```
## URL da Imagem no Docker Hub

URL: 'https://hub.docker.com/repository/docker/akflamingo2610/gs-7-ai-work-bots/general'

## Descrição dos Workflows CI/CD Implementados

### 1. Workflow de Versioning (versioning.yml)
- **Trigger:** Push para a branch `main`
- **Funcionalidade:** 
  - Gera automaticamente tags de versão no GitHub
  - Extrai a versão do arquivo `pom.xml`
  - Cria uma tag no formato `v{versão}-{timestamp}`
  - Faz push da tag para o repositório
- **Evidência:** Tag criada automaticamente visível na aba "Releases" do GitHub

### 2. Workflow de Continuous Integration - CI (ci.yml)
- **Trigger:** Push para branches `feature/**`, `release` ou `hotfix`
- **Funcionalidade:**
  - Executa o build da aplicação (compilação)
  - Executa os testes unitários
  - Faz o build da imagem Docker (verificação)
  - Valida que a aplicação pode ser empacotada corretamente
- **Evidência:** Execução registrada na aba "Actions" do GitHub

### 3. Workflow de Continuous Delivery - CD (cd.yml)
- **Trigger:** Pull Request para a branch `develop`
- **Funcionalidade:**
  - Faz o build da aplicação
  - Constrói a imagem Docker
  - Faz login no Docker Hub usando secrets
  - Publica automaticamente a imagem no Docker Hub
- **Evidência:** 
  - Execução registrada na aba "Actions" do GitHub
  - Imagem atualizada no Docker Hub

### Configuração Necessária para CD

Para que o workflow de CD funcione corretamente, é necessário configurar os seguintes secrets no GitHub:
1. `DOCKERHUBUSERNAME`: Seu usuário do Docker Hub
2. `DOCKERHUBPASSWORD`: Seu token/senha de acesso do Docker Hub


## Estrutura do Projeto

```
gs-7-ai-work-bots/
├── .github/
│   └── workflows/
│       ├── versioning.yml
│       ├── ci.yml
│       └── cd.yml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/fiap/gs7/gs7aiworkbots/
│   │   │       ├── Gs7AiWorkBotsApplication.java
│   │   │       └── TemaController.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/fiap/gs7/gs7aiworkbots/
│               └── Gs7AiWorkBotsApplicationTests.java
├── Dockerfile
├── pom.xml
└── README.md
```

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.7**
- **Spring Web**
- **SpringDoc OpenAPI (Swagger)**
- **Maven**
- **Docker**

## Porta Padrão

A aplicação utiliza a porta **8081** conforme especificado nos requisitos.

