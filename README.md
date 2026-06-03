# 🐕 Automação de Testes de API - Dog API

Este repositório contém a suíte de testes automatizados para validar os endpoints da [Dog API](https://dog.ceo/dog-api/documentation). O objetivo do projeto é garantir o funcionamento correto das integrações voltadas para visualização de raças e imagens de cães.

## 📊 Relatório de Testes em Tempo Real (CI/CD)
Acesse a última execução dos testes automatizados com gráficos dinâmicos e históricos aqui:
👉 **[Allure Report Hospedado no GitHub Pages](https://rennan-soares.github.io/test_dog_api/)**

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 17
* **Framework de Testes:** JUnit 5
* **Framework de Requisições:** RestAssured
* **Relatórios:** Allure Report
* **Orquestração e Interceptação:** AspectJ Weaver
* **CI/CD e Hospedagem:** GitHub Actions & GitHub Pages

## 📋 Endpoints Testados

* `GET /breeds/list/all` - Validação da listagem completa de raças e estrutura de resposta (verificação dinâmica de chaves do JSON).
* `GET /breed/{breed}/images` - Validação do retorno de imagens para raças válidas através de Regex/Contenção, garantindo resiliência contra sub-raças.
* `GET /breed/{breed}/images` (Cenário de Erro) - Validação do tratamento de erro 404 e mensagens para raças inexistentes.
* `GET /breeds/image/random` - Validação do formato e protocolo seguro (HTTPS) de URLs de imagens geradas aleatoriamente.

---

## 🚀 Como Configurar e Executar o Projeto Localmente

Independentemente do seu sistema operacional (Windows, Linux ou macOS), siga os passos abaixo:

### Pré-requisitos
1. Ter o **Java JDK 17** instalado e configurado nas variáveis de ambiente (`JAVA_HOME`).
2. Ter o **Apache Maven** instalado e configurado no `PATH` do sistema.

### Passos para execução:

1. **Clonar o repositório:**
    ```bash
    git clone [https://github.com/Rennan-Soares/test_dog_api.git](https://github.com/Rennan-Soares/test_dog_api.git)
    cd test_dog_api
    ```

2. **Executar os testes automatizados:**
    ```bash
    mvn clean test
    ```
    *Nota: Durante a execução local, os metadados brutos do Allure serão gerados automaticamente na pasta `target/allure-results`.*

3. **Gerar e Visualizar o Relatório Local (Opcional):**
    Caso possua o Allure CLI instalado na sua máquina, você pode abrir o relatório localmente com o comando:
    ```bash
    allure serve target/allure-results
    ```

---

## 🔄 Integração Contínua (CI/CD)

O projeto utiliza o **GitHub Actions** integrado nativamente ao **GitHub Pages**. 

### Como o fluxo funciona:
1. Cada `push` ou `pull request` nas branches `main` ou `master` aciona o Workflow automatizado.
2. O ambiente inicializa um container Linux (Ubuntu), configura o ambiente com o **JDK 17 (Temurin)** e faz o cache do Maven para execuções mais rápidas.
3. O comando `mvn test` roda os cenários. O componente **AspectJ Weaver** intercepta o ciclo de vida do JUnit 5 e gera os relatórios brutos.
4. A esteira compila esses dados estáticos usando o gerador do Allure e faz o deploy automático do site do relatório no ambiente seguro do GitHub Pages.

Isso garante que a documentação técnica e o status de saúde da API estejam sempre atualizados publicamente a cada alteração de código!