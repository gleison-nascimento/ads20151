drop database gabinete;
create database gabinete;

use gabinete;

drop table setores;
create table setores (
    id int not null,
    nome varchar(200),
    id_setor_pai int,
    primary key (id)
);

drop table usuarios;
create table usuarios (
    cpf varchar(11) not null,
    nome varchar(200) not null,
    telefone varchar(25),
    email varchar(255),
    tipo_usuario int,
    siape int,
    empresa varchar(200),
    carga_horaria int,
    id_setor int,
    primary key (cpf),
    foreign key (id_setor) references setores(id)
);

drop table chamados;
create table chamados
(
  id int not null auto_increment,
  nome_solicitante varchar(200),
  perfil_solicitante varchar(20),
  email_contato varchar(255),
  telefone_contato varchar(25),
  descricao_solicitacao text,
  situacao varchar(15),
  data_abertura datetime,
  anexos varchar(255),
  cpf_recepcionista varchar(11),
  cpf_servidor varchar(11),
  primary key (id),
  foreign key (cpf_recepcionista) references usuarios(cpf),
  foreign key (cpf_servidor) references usuarios(cpf)
);

drop table respostas;
create table respostas
(
  id_chamado int not null,
  id_resposta int not null,
  descricao_resposta text,
  data_resposta datetime,
  rascunho boolean,
  anexos varchar(255),
  cpf_servidor varchar(11),
  primary key (id_chamado, id_resposta),
  foreign key (cpf_servidor) references usuarios(cpf)
);

drop table solicitacao_documentos;
create table solicitacao_documentos
(
  id_solicitacao int not null auto_increment,
  objetivo varchar(255),
  data_solicitacao datetime,
  data_documento datetime,
  conteudo_documento text,
  situacao varchar(20),
  anexos varchar(255),
  cpf_servidor varchar(11),
  primary key (id_solicitacao),
  foreign key (cpf_servidor) references usuarios(cpf)
);

drop table documentos_oficiais;
create table documentos_oficiais
(
  numero int not null,
  ano int not null,
  tipo varchar(10) not null,
  data_emissao date,
  conteudo text,
  anexos varchar(255),
  cpf_emissor varchar(11),
  primary key (numero, ano, tipo),
  foreign key (cpf_emissor) references usuarios(cpf)
);

drop table solicitacao_eventos;
create table solicitacao_eventos
(
  id_solicitacao int not null auto_increment,
  solicitante varchar(255),
  entidade_solicitante varchar(255),
  email_contato varchar(255),
  telefone_contato varchar(255),
  descricao_evento text,
  data_solicitacao datetime,
  data_inicio_evento datetime,
  data_termino_evento datetime,
  situacao varchar(20),
  anexos varchar(255),
  primary key (id_solicitacao)
);

drop table eventos;
create table eventos
(
  id_evento int not null auto_increment,
  id_solicitacao_evento int not null,
  solicitante varchar(255),
  entidade_solicitante varchar(255),
  email_contato varchar(255),
  telefone_contato varchar(255),
  descricao_evento text,
  data_agendamento datetime,
  data_inicio_evento datetime,
  data_termino_evento datetime,
  situacao varchar(20),
  observacoes varchar(255),
  cpf_servidor varchar(11),
  primary key (id_evento),
  foreign key (id_solicitacao_evento) references solicitacao_eventos(id_solicitacao),
  foreign key (cpf_servidor) references usuarios(cpf)
);

drop table espacos;
create table espacos
(
  numero int not null,
  nome varchar(255),
  descricao text,
  lotacao int,
  tipo varchar(15),
  projetor boolean,
  internet boolean,
  quadro boolean,
  especialidade varchar(100),
  equipamentos text,
  primary key (numero)
);

drop table solicitacao_reserva;
create table solicitacao_reserva
(
  id_solicitacao int not null auto_increment,
  solicitante varchar(255),
  entidade_solicitante varchar(255),
  email_contato varchar(255),
  telefone_contato varchar(255),
  objetivo_reserva text,
  data_solicitacao datetime,
  data_inicio_reserva datetime,
  data_termino_reserva datetime,
  situacao varchar(20),
  primary key (id_solicitacao)
);

drop table reservas;
create table reservas
(
  id_reserva int not null auto_increment,
  id_solicitacao_reserva int not null,
  solicitante varchar(255),
  entidade_solicitante varchar(255),
  email_contato varchar(255),
  telefone_contato varchar(255),
  objetivo_reserva text,
  data_reserva datetime,
  data_inicio_reserva datetime,
  data_termino_reserva datetime,
  situacao varchar(20),
  observacoes varchar(255),
  ocorrencias text,
  cpf_servidor varchar(11),
  numero_espaco int,
  primary key (id_reserva),
  foreign key (id_solicitacao_reserva) references solicitacao_reserva(id_solicitacao),
  foreign key (cpf_servidor) references usuarios(cpf),
  foreign key (numero_espaco) references espacos(numero)
);