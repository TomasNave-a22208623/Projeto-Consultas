# Sistema de Marcação de Consultas Médicas

Projeto da unidade curricular de Computação Distribuída

👨‍💻 Autores: Tomás Nave e André Jesus

📅 Ano letivo: 2024/2025

📚 Curso: Engenharia Informática

🔗 Tecnologias principais: Java, RMI, REST, SOAP, Apache Tomcat, Apache CXF, JDBC, MySQL

<img width="886" height="293" alt="image" src="https://github.com/user-attachments/assets/460c7f27-04f9-43b2-b06c-9ceea4d5a3ef" />

## 🔎 Descrição do Projeto

Este projeto foi desenvolvido no contexto da unidade curricular de Computação Distribuída, com o objetivo de aprofundar a compreensão e a aplicação prática dos conceitos fundamentais associados a sistemas distribuídos. O foco principal consistiu em construir uma solução funcional e modular para a gestão de marcações de consultas médicas, considerando as necessidades de interoperabilidade, escalabilidade e robustez típicas de um sistema distribuído moderno.

O sistema foi concebido para permitir que os utilizadores finais possam realizar ações como registar-se na plataforma, autenticar-se, marcar, cancelar, listar e remarcar consultas em diferentes clínicas, cada uma com as suas especialidades. O projeto foi implementado em Java e segue uma arquitetura cliente-servidor distribuída, composta por duas grandes camadas: frontend e backend, que comunicam entre si através de Java RMI (Remote Method Invocation), um mecanismo que permite a execução de métodos remotos de forma transparente.

### 🖥️ Frontend
O frontend é responsável por toda a interação com os utilizadores finais. Foi desenvolvido num ambiente Windows, recorrendo à IDE Eclipse, e tem como funções principais:
- Gestão de utilizadores: registo, login, e autenticação.
- Exposição de Web Services: disponibiliza dois tipos de interfaces para consumo de serviços — REST e SOAP, ambos implementados sobre o servidor Apache Tomcat, com o suporte da biblioteca Apache CXF.
- Ligação à base de dados MySQL: guarda toda a informação relacionada com os utilizadores da plataforma (registos, sessões, permissões).
- Encaminhamento de pedidos ao backend: atua como intermediário entre os clientes e a lógica de negócio, redirecionando pedidos via RMI ao backend.

A existência simultânea de serviços REST e SOAP proporciona flexibilidade e permite simular cenários de integração com diferentes tipos de clientes ou aplicações, refletindo a diversidade de tecnologias usada no mundo real.

### 🛠️ Backend
O backend, implementado numa máquina virtual Linux, é o núcleo lógico da aplicação. Foi desenvolvido com VS Code e serve exclusivamente para gerir as operações sobre as marcações de consultas. As principais responsabilidades deste componente incluem:
- Persistência e gestão de marcações: operações CRUD sobre as reservas de consultas médicas.
- Ligação à sua própria base de dados MySQL, onde são armazenadas todas as informações relativas às marcações.
- Fornecimento de métodos RMI ao frontend, que atua como cliente remoto destes métodos.

Esta separação clara entre frontend e backend permite escalar os componentes de forma independente, e também simula uma realidade empresarial onde diferentes partes do sistema estão distribuídas por diferentes servidores ou mesmo localizações geográficas.

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

## ⚙️ Funcionalidades
- Registo e autenticação de utilizadores
- Marcação, cancelamento, listagem e remarcação de consultas
- Serviços acessíveis via REST ou SOAP
- Separação de responsabilidades entre frontend (interação com o utilizador) e backend (gestão de lógica e dados)
- Suporte a diferentes ambientes operativos (Windows e Linux)
