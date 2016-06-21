/** 
 * Document   : EventoTest.sql
 * Created on : 21/06/2016 16:01
 * Author     : EvertonQuadros
 * Escopo     : Eventos
 * Descrição  : Sql para teste de sessão.
 * Observações: Não alterar sem prévio aviso. Comentar revisões.
*/

use gabinete;

#para módulo eventos;
drop table if exists perfis;
create table if not exists perfis (id int auto_increment not null,
    login varchar(100),
    senha varchar(50), 
    primary key(id))engine=innodb;

insert into perfis values(null,"administrador","admin123"),
                         (null,"user","user123");