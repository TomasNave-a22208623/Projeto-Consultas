# Sistema de Marcação de Consultas Médicas

Projeto da unidade curricular de Computação Distribuída

👨‍💻 Autores: Tomás Nave e André Jesus
📅 Ano letivo: 2024/2025
📚 Curso: Engenharia Informática
🔗 Tecnologias principais: Java, RMI, REST, SOAP, Apache Tomcat, Apache CXF, JDBC, MySQL

## 🔎 Descrição do Projeto

Este projeto foi desenvolvido no âmbito da unidade curricular de Computação Distribuída com o objetivo de aplicar os conceitos fundamentais de sistemas distribuídos através da criação de um sistema de marcação de consultas para clínicas médicas, com suporte para várias especialidades.

O sistema segue uma arquitetura cliente-servidor, dividida em dois componentes principais:

Frontend: Responsável pela interação com os utilizadores — registo, login, e operações sobre consultas. Expõe Web Services REST e SOAP.

Backend: Responsável pela gestão das marcações e lógica de negócio. Comunica com o frontend via Java RMI.

## 🧱 Arquitetura da Solução

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
