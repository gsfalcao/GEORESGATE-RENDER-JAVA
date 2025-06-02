# GeoResgate - Sistema de Alerta para Enchentes

GeoResgate é um sistema de apoio emergencial desenvolvido em Java com Quarkus, integrado ao banco de dados Oracle. O sistema permite o cadastro de usuários e suas residências, bem como o envio de alertas com geolocalização para simular socorro em áreas de risco.

---

## 🛠 Tecnologias Utilizadas

- Java 17  
- Quarkus 3.2.9  
- Oracle SQL Developer  
- API de Localização: [ip-api.com/json](http://ip-api.com/json)  
- Postman (para testes)  
- Python (CLI complementar com `oracledb`)  

---

## 🔧 Como Executar o Projeto Java

1. Abra o projeto no IntelliJ IDEA  
2. Verifique o arquivo `application.properties`:

   ```properties
   quarkus.datasource.username=system
   quarkus.datasource.password=261205
   quarkus.datasource.jdbc.url=jdbc:oracle:thin:@localhost:1521:xe
   ```

3. Execute o projeto com o Maven:

   ```bash
   ./mvnw quarkus:dev
   ```

4. Acesse a API em:  
   [http://localhost:8080](http://localhost:8080)

---

## 📌 Endpoints da API

### 🔹 Usuário
- `GET /usuario`
- `POST /usuario`
- `GET /usuario/{id}`
- `PUT /usuario/{id}`
- `DELETE /usuario/{id}`

### 🔹 Residência
- `GET /residencia`
- `POST /residencia/{idUsuario}`
- `GET /residencia/{id}`
- `PUT /residencia/{id}`
- `DELETE /residencia/{id}`

### 🔹 Alerta
- `GET /alerta`
- `POST /alerta/{idUsuario}` *(localização automática via IP)*
- `GET /alerta/{id}`
- `PUT /alerta/{id}`
- `DELETE /alerta/{id}`

---

## 🧪 Banco de Dados Oracle

- **Usuário:** `system`  
- **Senha:** `261205`  
- **DSN:** `localhost:1521/xe`  

**Tabelas utilizadas:**
- `usuario`
- `residencia`
- `alerta`

---

## 🖥️ Terminal Python (opcional)

O sistema também possui uma interface em Python conectada ao mesmo banco Oracle.

Execute com:

```bash
python georesgate_oracle_terminal.py
```

---

## 👤 Autoria

Projeto acadêmico para a disciplina **Domain Driven Design Using Java – FIAP**

- **Aluno:** _MARIA EDUARDA FERNANDES ROCHA_  
  **RM:** _560657_

- **Aluno:** _VICTOR DE CARVALHO ALVES_  
  **RM:** _560395_ 

- **Aluno:** _GUILHERME SANTOS FALCÃO_  
  **RM:** _560729_