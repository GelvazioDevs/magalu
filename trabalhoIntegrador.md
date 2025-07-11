As principais classes padrão de JPA são:

- `EntityManager`
- `EntityManagerFactory`
- `EntityTransaction`
- `Persistence`
- `Query`
- `TypedQuery`
- `CriteriaBuilder`
- `CriteriaQuery`

Essas classes fazem parte do pacote `javax.persistence`.
A seguir está uma breve explicação de cada classe:

- **EntityManager**: Responsável por gerenciar o ciclo de vida das entidades, realizar operações de persistência, consultas e transações no contexto de persistência.
- **EntityManagerFactory**: Fábrica de instâncias de `EntityManager`. Geralmente é criada uma vez por aplicação e compartilhada.
- **EntityTransaction**: Gerencia as transações no contexto do `EntityManager`, permitindo iniciar, confirmar ou reverter transações.
- **Persistence**: Classe utilitária usada para criar a `EntityManagerFactory` a partir das configurações definidas no arquivo de persistência.
- **Query**: Representa uma consulta genérica à base de dados, podendo retornar diferentes tipos de resultados.
- **TypedQuery**: Similar à `Query`, mas com tipagem segura, garantindo o tipo de retorno dos resultados.
- **CriteriaBuilder**: Utilizada para construir consultas de forma programática e tipada, seguindo o padrão Criteria API.
- **CriteriaQuery**: Representa uma consulta criada com o `CriteriaBuilder`, permitindo a construção dinâmica de consultas.

Conceitos de API Restfull

- **API RESTful**: Uma API RESTful segue os princípios da arquitetura REST (Representational State Transfer), utilizando os métodos HTTP (GET, POST, PUT, DELETE) para manipular recursos representados por URLs.
- **Recurso**: Qualquer entidade ou objeto que pode ser acessado via URI, como usuários, produtos ou pedidos.
- **Endpoint**: Um endereço específico (URL) que representa um recurso ou uma coleção de recursos em uma API.
- **Métodos HTTP**:
    - **GET**: Recupera informações de um recurso.
    - **POST**: Cria um novo recurso.
    - **PUT**: Atualiza um recurso existente.
    - **DELETE**: Remove um recurso.
- **Stateless**: Cada requisição feita à API deve conter todas as informações necessárias para seu processamento, sem depender de estado armazenado no servidor.
- **Representação**: Os dados dos recursos geralmente são transferidos em formatos como JSON ou XML.
- **Status Codes**: As respostas da API utilizam códigos HTTP para indicar o resultado da operação (por exemplo, 200 OK, 201 Created, 404 Not Found, 400 Bad Request).


