# 🐕 Automação de Testes de API - Dog API

Este repositório contém a suíte de testes automatizados para validar os endpoints da [Dog API](https://dog.ceo/dog-api/documentation). O objetivo do projeto é garantir o funcionamento correto das integrações voltadas para visualização de raças e imagens de cães.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 17
* **Framework de Testes:** JUnit 5
* **Framework de Requisições:** RestAssured
* **Relatórios:** Allure Report
* **CI/CD:** GitHub Actions

## 📋 Endpoints Testados

* `GET /breeds/list/all` - Validação da listagem completa de raças e estrutura de resposta.
* `GET /breed/{breed}/images` - Validação do retorno de imagens para raças válidas e tratamento de erro para inválidas.
* `GET /breeds/image/random` - Validação do retorno de uma imagem aleatória no formato de URL.

---

## 🚀 Como Configurar e Executar o Projeto

Independentemente do seu sistema operacional (Windows, Linux ou macOS), siga os passos abaixo:

### Pré-requisitos
1.  Ter o **JDK 17** instalado e configurado nas variáveis de ambiente.
2.  Ter o **Maven** instalado (ou utilizar o wrapper `./mvnw` se disponível).

### Passos para execução:

1.  **Clonar o repositório:**
    ```bash
    git clone https://github.com/Rennan-Soares/test_dog_api.git
    cd test_dog_api
    ```

2.  **Executar os testes automatizados:**
    ```bash
    mvn clean test
    ```

3.  **Gerar e Visualizar o Relatório de Testes (Allure Report):**
    Caso possua o Allure CLI instalado na máquina, execute:
    ```bash
    allure serve target/allure-results
    ```
    *Nota: Os logs detalhados de Request e Response também são exibidos diretamente no console do terminal durante a execução via comando `mvn test`.*

---

## 🔄 Integração Contínua (CI/CD)

O projeto conta com o **GitHub Actions** configurado. Cada `push` ou `pull request` na branch principal dispara a execução automática da suíte de testes em um ambiente Ubuntu isolado, garantindo a integridade contínua da aplicação.