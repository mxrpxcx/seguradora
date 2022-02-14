# seguradora
API Seguradora de Carros

Instruções: 

1 A API funciona com o banco de dados MySQL, entre no application.properties e altere o login, senha e ports se necessário. 

2 Será necessário criar uma base de dados com o nome "seguradora_db"

3 Ela roda na porta 8181, é possível alterar a porta também no application.properties

4 Ao executar o projeto, as tabelas serão populadas com alguns dados para teste, se tentar executar novamente irá crashar

4.1 Apague a base de dados "seguradora_db" e crie novamente, então execute novamente o projeto

Problemas conhecidos e ainda não resolvidos:

1 Mostrar exceções personalizadas sobre quando os atributos não são válidos, atualmente só retorna o response sem mensagem personalizada

2 Proibir adicionar/editar apolices com datas disconexas (data final anterior à data inicial etc)

3 Melhorar os inserts de entidades que possuem relacionamentos, por exemplo: atualmente pra inserir uma apólice é necessário fazer uma busca pelo id do cliente,
isso irá causar gargalos caso a aplicação escale futuramente
