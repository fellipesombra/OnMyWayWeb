# OnMyWayWeb

### TODO:

- Criar banco de dados (se tiverem sugestões/opiniões sobre a estrutura do banco só falar)
  - 3 Tabelas:
    - contact (id, cellphone_number, email) [PK = id]
    - user (id, contact_id) [PK = combinação de id e contact_id] [FK = contact_id]
    - trip (id, user_id, end_time) [PK = id]
    - path (id, trip_id, location, time) [PK = id]
- Configurar hibernate no projeto
  - Fazer um fluxo de teste simples de inserir/excluir para verificar que está funcionando.
    (um botão em uma pagina que chame uma função que insira algo no banco e outro pra deletar é o suficiente)
- Implementar API do google maps no projeto
  - Fazer aparecer o mapa em uma pagina
  - Fazer aparecer um caminho no mapa (lista de pontos no mapa que ele conecta)
  
