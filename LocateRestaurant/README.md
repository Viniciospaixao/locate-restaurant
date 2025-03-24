LocateRestaurant - Plataforma de Busca e Reserva de Restaurantes
Este é o projeto LocateRestaurant , uma plataforma para busca e reserva de restaurantes. Ele foi desenvolvido usando Spring Boot e Docker , e inclui integração come Docker, e inclui integração com Swagger para documentação das APIs .para documentação das APIs.

Tecnologias Utilizadas
Spring Boot 3.x

Java 17

Spring Data JPA (para persistência)

H2 Database (banco de dados em memória para testes)

Swagger (Springdoc OpenAPI) para documentação das APIs

Docker para conteinerização da aplicação

Pré-requisitos
Docker : Verifique se o Docker está instalado e funcionando corretamente em sua máquina.

Maven (para construção do .jar, caso não utilize o Docker para construir a imagem)

Como Rodar o Projeto com Docker
1. Clonar o repositório
Primeiro, clone o repositório para sua máquina local:

bater

Copiar

Editar
git clone <URL_DO_REPOSITORIO>
cd LocateRestaurant
2. Gere o arquivo .jar(caso não tenha sido gerado ainda)
Antes de rodar o Docker, é necessário garantir que o arquivo .jarfoi gerado. Para isso, execute o Maven:

bater

Copiar

Editar
mvn clean install
3. Construir uma Imagem Docker
Com o arquivo .jargerado, você pode agora construir uma imagem Docker. No diretório raiz do seu projeto, execute:

bater

Copiar

Editar
docker-compose build
4. Rodar o Docker Compose
Após a construção da imagem, você pode iniciar o container com o seguinte comando:

bater

Copiar

Editar
docker-compose up
O Docker irá construir e iniciar os contêineres necessários para rodar a aplicação.

5. Acessando a Aplicação
Após o Docker ter atualizado o aplicativo, você pode acessar uma API e a UI Swagger nas seguintes URLs:

Interface do usuário do Swagger : http://localhost:8080/swagger-ui/index.html

API : Uma API estará disponível na porta 8080.

6. Para os Containers
Para parar os containers em execução, utilize o comando:

bater

Copiar

Editar
docker-compose down
Estrutura do Projeto
O projeto é organizado nas seguintes camadas:

controller : Responsável pela exposição dos endpoints da API.

serviço : Contém a lógica de negócios da aplicação.

repositório : Interage com o banco de dados, utilizando Spring Data JPA.

editora : (Se aplicável) Para envio de eventos ou integrações com outros serviços.

Como Contribuir
Faça um fork deste repositório.

Crie um branch para seu feature ( git checkout -b feature/nova-feature).

Faça as alterações e confirme suas modificações.

Suba as alterações para seu repositório ( git push origin feature/nova-feature).

Abra um Pull Request explicando suas alterações.

Licença
Este projeto está sob licença MIT. Veja o arquivo LICENSE para mais detalhes.

Dicas:
Se você quiser rodar o projeto sem o Docker, basta executar o comando mvn spring-boot:rundiretamente no diretório do projeto.

O Swagger estará sempre disponível para testes e visualização das APIs.
