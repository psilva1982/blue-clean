/*
DROP DATABASE IF EXISTS blue_clean;
CREATE DATABASE blue_clean DEFAULT CHARSET=utf8;
USE blue_clean;
*/ 

CREATE TABLE estado (
  codigo bigint(20) NOT NULL,
  nome varchar(50) NOT NULL,
  sigla varchar(2) NOT NULL,
  PRIMARY KEY (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cidade (
  codigo bigint(20) NOT NULL AUTO_INCREMENT,
  nome varchar(50) NOT NULL,
  estado bigint(20) NOT NULL,
  PRIMARY KEY (codigo),
  FOREIGN KEY (estado) REFERENCES estado (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cliente (
  codigo bigint(20) NOT NULL AUTO_INCREMENT,
  nome varchar(80) NOT NULL,
  tipo_pessoa varchar(15) NOT NULL,
  cpf_cnpj varchar(30) NOT NULL,
  telefone varchar(20) DEFAULT NULL,
  email varchar(50) DEFAULT NULL,
  logradouro varchar(50) DEFAULT NULL,
  numero varchar(15) DEFAULT NULL,
  complemento varchar(20) DEFAULT NULL,
  cep varchar(15) DEFAULT NULL,
  cidade bigint(20) DEFAULT NULL,
  PRIMARY KEY (codigo),
  FOREIGN KEY (cidade) REFERENCES cidade (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;