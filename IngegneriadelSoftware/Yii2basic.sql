-- DROP SCHEMA yii2basic;
CREATE SCHEMA yii2basic;
USE yii2basic;

CREATE TABLE tbl_user (
	id INT AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(32) UNIQUE NOT NULL,
    pass VARCHAR(128) NOT NULL,
    authKey VARCHAR(128),
	accessToken VARCHAR(128),
    categoria CHAR(1)
);

CREATE TABLE caregiver (
	cf CHAR(16) PRIMARY KEY,
	id INT NOT NULL,
    nome VARCHAR(32) not null,
    cognome VARCHAR(32) not null,
    email VARCHAR(32) unique not null,
    FOREIGN KEY(id) REFERENCES tbl_user(id)
);

CREATE TABLE gruppo (
  Id int auto_increment PRIMARY KEY,
  note VARCHAR(32) not null
);

CREATE TABLE paziente (
    cf CHAR(16) PRIMARY KEY,
    cf_care CHAR(16),
    id INT NOT NULL,
    id_gruppo int,
    nome VARCHAR(32) not null,
    cognome VARCHAR(32) not null,
    FOREIGN KEY(id) REFERENCES tbl_user(id),
    FOREIGN KEY(id_gruppo) REFERENCES gruppo(Id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(cf_care) REFERENCES caregiver(cf) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE logopedista (
	cf CHAR(16) PRIMARY KEY,
	id INT NOT NULL,
    nome VARCHAR(32) not null,
    cognome VARCHAR(32) not null,
    email VARCHAR(32) unique not null,
	FOREIGN KEY(id) REFERENCES tbl_user(id)
);

CREATE TABLE terapia (
  Id INT AUTO_INCREMENT PRIMARY KEY,
  cf_logo CHAR(16),
  cf_care CHAR(16),
  cf_paz CHAR(16),
  note VARCHAR(255),
  FOREIGN KEY(cf_logo) REFERENCES logopedista(cf) ON UPDATE CASCADE ON DELETE SET NULL,  
  FOREIGN KEY(cf_care) REFERENCES caregiver(cf) ON UPDATE CASCADE ON DELETE SET NULL,
  FOREIGN KEY(cf_paz) REFERENCES paziente(cf) ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE terapiagruppo (
  Id INT AUTO_INCREMENT PRIMARY KEY,
  cf_logo CHAR(16),
  Id_gruppo INT,
  note VARCHAR(255),
  FOREIGN KEY(cf_logo) REFERENCES logopedista(cf) ON UPDATE CASCADE ON DELETE SET NULL,  
  FOREIGN KEY(Id_gruppo) REFERENCES gruppo(Id) ON UPDATE CASCADE ON DELETE SET NULL
);


CREATE TABLE questionario 
(
	cf_care CHAR(16)  PRIMARY KEY,
    cf_paz CHAR(16),
	d1 CHAR(1) NOT NULL,
	d2 CHAR(1) NOT NULL,
    d3 CHAR(1) NOT NULL,
    d4 BOOL NOT NULL,
	d5 BOOL NOT NULL,
    d6 BOOL NOT NULL,
    body VARCHAR(255),
    FOREIGN KEY(cf_care) REFERENCES caregiver(cf) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(cf_paz) REFERENCES paziente(cf) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE appuntamento (
  Id INT AUTO_INCREMENT PRIMARY KEY,
  cf_logo CHAR(16) NOT NULL,
  dat Date NOT NULL,
  note VARCHAR(32),
  prenotato ENUM ('No','Sì') default 'No',
  FOREIGN KEY(cf_logo) REFERENCES logopedista(cf) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE prenotazione(
Id int AUTO_INCREMENT PRIMARY KEY,
Id_appuntamento INT,
dat date NOT NULL,
cf_logo CHAR(16) NOT NULL,
cf_care CHAR(16) NOT NULL,
FOREIGN KEY(cf_logo) REFERENCES logopedista(cf) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY(cf_care) REFERENCES caregiver(cf) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY(Id_appuntamento) REFERENCES appuntamento(Id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE esercizio(
Id int AUTO_INCREMENT PRIMARY KEY,
Id_terapia int NOT NULL,
indice int,
nome VARCHAR(32),
nome_file VARCHAR(255),
nome_file2 VARCHAR(255),
svolto ENUM ('No','Sì') default 'No',
saltato ENUM ('No','Sì') default 'No',
FOREIGN KEY(Id_terapia) REFERENCES terapia(Id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE eserciziogruppo(
Id int AUTO_INCREMENT PRIMARY KEY,
Id_terapiagruppo int NOT NULL,
nome VARCHAR(32),
indice_medio int,
nome_file VARCHAR(255),
FOREIGN KEY(Id_terapiagruppo) REFERENCES terapiagruppo(Id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE noteserciziogruppo(
Id_es int,
cf_paz CHAR(16),
nome_file VARCHAR(255),
svolto ENUM ('No','Sì') default 'No',
saltato ENUM ('No','Sì') default 'No',
indice int,
FOREIGN KEY(Id_es) REFERENCES eserciziogruppo(Id),
FOREIGN KEY(cf_paz) REFERENCES paziente(cf),
PRIMARY KEY(Id_es, cf_paz)
);

select * from tbl_user;
select * from gruppo;
select * from caregiver;
select * from logopedista;
select * from paziente;
select * from questionario;
select * from terapia;
select * from terapiagruppo;
select * from appuntamento;
select * from prenotazione;
select * from esercizio;
select * from eserciziogruppo;
select * from noteserciziogruppo;