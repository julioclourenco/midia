CREATE TABLE midia (
  id bigint NOT NULL AUTO_INCREMENT,
  plataforma VARCHAR(50) NOT NULL,
  titulo VARCHAR(100) NOT NULL,
  estilo VARCHAR(50) NOT NULL,
  nota INT NOT NULL DEFAULT 0,
  registro DATE null,
  PRIMARY KEY (id)
  );