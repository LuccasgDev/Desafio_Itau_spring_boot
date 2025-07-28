# Desafio Itaú - Backend API (Spring Boot)

Este projeto foi desenvolvido como solução para o desafio proposto pelo Itaú Unibanco, disponível em: [https://github.com/feltex/desafio-itau-backend](https://github.com/feltex/desafio-itau-backend).

## 📋 Descrição

A proposta do desafio é construir uma API RESTful que recebe transações financeiras e retorna estatísticas baseadas nas transações ocorridas nos **últimos 60 segundos**.

O projeto foi desenvolvido utilizando:

- Java 21
- Spring Boot
- Maven
- Armazenamento em memória (uso de `ConcurrentLinkedDeque`)
- Validação com Bean Validation (`jakarta.validation`)
- Sem uso de banco de dados, conforme especificação do desafio

---

## 🚀 Funcionalidades da API

### 1. Criar Transação
**POST** `/transacao`

**Request JSON:**
```json
{
  "valor": 100.0,
  "dataHora": "2025-07-28T12:30:45.000-03:00"
}
Regras de negócio:

O campo valor deve ser positivo ou zero

A data não pode estar no futuro

Todos os campos são obrigatórios

Dados devem estar em formato ISO 8601

Respostas:

201 Created → Transação válida registrada

422 Unprocessable Entity → Transação com valor inválido ou data futura

400 Bad Request → JSON inválido

2. Deletar Transações
DELETE /transacao

Limpa todas as transações armazenadas na memória.

Resposta:

200 OK → Transações apagadas com sucesso

3. Consultar Estatísticas
GET /estatística

Retorna estatísticas baseadas nas transações dos últimos 60 segundos.

Resposta JSON:

{
  "count": 3,
  "sum": 250.0,
  "avg": 83.33,
  "min": 50.0,
  "max": 100.0
}
Caso não haja transações no período, os valores retornam como 0.

📁 Estrutura de Pastas

src/
├── main/
│   ├── java/desafio/itau/springboot/
│   │   ├── controller/
│   │   ├── DTO/
│   │   ├── model/
│   │   └── service/
│   └── resources/
└── test/
🧪 Testes
(🟡 A incluir... – recomendável adicionar testes unitários e de integração com JUnit para validar os comportamentos esperados.)

⚙️ Como executar o projeto localmente
Clone o repositório:
git clone https://github.com/seu-usuario/Desafio_Itau_spring_boot.git

Navegue até a pasta do projeto:
cd Desafio_Itau_spring_boot

Compile e execute com Maven:
./mvnw spring-boot:run

A API estará disponível em:
http://localhost:8080
