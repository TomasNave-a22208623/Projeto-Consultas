# Sistema de Marcação de Consultas Médicas

Projeto da unidade curricular de Computação Distribuída

👨‍💻 Autores: Tomás Nave e André Jesus

📅 Ano letivo: 2024/2025

📚 Curso: Engenharia Informática

🔗 Tecnologias principais: Java, RMI, REST, SOAP, Apache Tomcat, Apache CXF, JDBC, MySQL

<img width="886" height="293" alt="image" src="https://github.com/user-attachments/assets/460c7f27-04f9-43b2-b06c-9ceea4d5a3ef" />

## 🔎 Descrição do Projeto

Este projeto foi desenvolvido no âmbito da unidade curricular de Computação Distribuída com o objetivo de aplicar os conceitos fundamentais de sistemas distribuídos através da criação de um sistema de marcação de consultas para clínicas médicas, com suporte para várias especialidades.

O sistema segue uma arquitetura cliente-servidor, dividida em dois componentes principais:

- Frontend: Responsável pela interação com os utilizadores — registo, login, e operações sobre consultas. Expõe Web Services REST e SOAP.
- Backend: Responsável pela gestão das marcações e lógica de negócio. Comunica com o frontend via Java RMI.

## 🧱 Arquitetura da Solução

<img width="983" height="702" alt="image" src="https://github.com/user-attachments/assets/b0deb3bc-0d1e-4347-a0dd-77c5c875066d" />

### 📌 Componentes
#### Frontend

- Ambiente: Windows
- Tecnologias: Java, Apache Tomcat, Apache CXF, JDBC
- Funcionalidades: Registo e login de utilizadores, Web Services (REST e SOAP), ligação à base de dados MySQL dos utilizadores.

### Backend

- Ambiente: Máquina virtual Linux
- Tecnologias: Java, JDBC
- Funcionalidades: Gestão de marcações de consultas, ligação à base de dados MySQL das marcações.

### 🔁 Comunicação
- Frontend <-> Backend: Comunicação através de Java RMI.
- Clientes:
  - Cliente REST: Consome os serviços REST do frontend.
  - Cliente SOAP: Consome os serviços SOAP do frontend.

### 🗃️ Base de Dados
Utilização de MySQL para persistência de dados (utilizadores e consultas).

Acesso via JDBC para execução de queries SQL (CRUD).

Bases de dados geridas com Azure Data Studio.

### ⚙️ Funcionalidades
- Registo e autenticação de utilizadores
- Marcação, cancelamento, listagem e remarcação de consultas
- Serviços acessíveis via REST ou SOAP
- Separação de responsabilidades entre frontend (interação com o utilizador) e backend (gestão de lógica e dados)
- Suporte a diferentes ambientes operativos (Windows e Linux)
