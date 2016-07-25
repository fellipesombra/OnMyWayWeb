# OnMyWayWeb

Script de criação do banco:

CREATE TABLE USER (
 ID INT (5) NOT NULL AUTO_INCREMENT,
 EMAIL VARCHAR (30) NOT NULL,
 PASSWORD VARCHAR (30) NOT NULL,
 PRIMARY KEY ( ID )
);
CREATE TABLE CONTACT (
 ID INT (5) NOT NULL AUTO_INCREMENT,
 USER_ID INT (5) NOT NULL,
 CELLPHONE_NUMBER VARCHAR (12) NOT NULL,
 EMAIL VARCHAR (30) NOT NULL,
 PRIMARY KEY ( ID )
);
CREATE TABLE TRIP (
 ID INT (5) NOT NULL AUTO_INCREMENT,
 USER_ID INT (5) NULL,
 END_TIME DATETIME NULL,
 PRIMARY KEY ( ID )
);
CREATE TABLE POSITION (
 ID INT (5) NOT NULL AUTO_INCREMENT,
 TRIP_ID INT(5) NULL,
 LATITUDE DOUBLE NOT NULL,
 LONGITUDE DOUBLE NOT NULL,
 DATE_TIME DATETIME NOT NULL,
 PRIMARY KEY ( id )
);

ALTER TABLE `CONTACT` ADD CONSTRAINT `fk_user_id` FOREIGN KEY ( `user_id` ) REFERENCES `USER` ( `id` ) ;
ALTER TABLE `TRIP` ADD CONSTRAINT `fk_user_id` FOREIGN KEY ( `user_id` ) REFERENCES `USER` ( `id` ) ;
ALTER TABLE `POSITION` ADD CONSTRAINT `fk_trip_id` FOREIGN KEY ( `trip_id` ) REFERENCES `TRIP` ( `id` ) ;

### TODO:
- ~~Criar banco de dados (se tiverem sugestões/opiniões sobre a estrutura do banco só falar)~~
  - ~~3 Tabelas:~~
    - ~~contact (id, user_id, cellphone_number, email) [PK = id][FK = user_id]~~
    - ~~user (id, email, senha) [PK = id]~~
    - ~~trip (id, user_id, end_time) [PK = id][FK = user_id]~~
    - ~~path (id, trip_id, latitude, longitude, date_time) [PK = id][FK = trip_id]~~
- ~~Configurar hibernate no projeto~~
  - Fazer um fluxo de teste simples de inserir/excluir para verificar que está funcionando.
    (um botão em uma pagina que chame uma função que insira algo no banco e outro pra deletar é o suficiente)
- ~~Implementar API do google maps no projeto~~
  - ~~Fazer aparecer o mapa em uma pagina~~
  - ~~Fazer aparecer um caminho no mapa (lista de pontos no mapa que ele conecta)~~
  


