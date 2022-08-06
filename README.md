# intro-padroes-projeto
Projeto DIO com padrões de projeto em SpringBoot

Esse projeto utiliza 3 padrões: Singleton, Strategy e Facade

Ele consiste no cadastro de um cliente e seu respectivo endereço. Para o endereço, fazemos o consumo da API ViaCep para resgatar os dados através do CEP.

Para o projeto, foram utilizadas as seguintes dependências do Maven:

- Spring Web
- Spring Data JPA
- H2 Database
- Open Feign

E foi utilizada a dependência manual do Open API (antigo swagger)

Para utilizar o projeto, ir na classe principal `IntroPadroesProjetoApplication.java` e executar.

Para usar o Open API, abrir o browser e digitar o endereço abaixo:

`http://localhost:8080/swagger-ui.html`

Nessa página estarão os recursos CRUD disponíveis para teste.
