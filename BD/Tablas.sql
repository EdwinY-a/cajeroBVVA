DROP DATABASE cajero;
CREATE DATABASE cajero;
USE cajeregistrotransaccionro;

CREATE TABLE banco (
    idBanco         INT AUTO_INCREMENT PRIMARY KEY,
    nombrePersona   VARCHAR(100),
    numeroTarjeta   VARCHAR(16) NOT NULL UNIQUE,
    dinero          INT(60),
    NIP             INT(4) NOT NULL
);
select * from banco;

CREATE TABLE cajero (
    idCajero        INT PRIMARY KEY,
    nombreBanco     VARCHAR(50) NOT NULL DEFAULT ('BBVA'), -- Ajuste de comillas simples y corrección tipográfica
    cantidad        INT(10),  -- Corrección de nombre
    idBanco         INT(10),
    FOREIGN KEY (idBanco) REFERENCES banco(idBanco)
);

select * from cajero;

CREATE TABLE registroTransaccion (
    idTransaccion           INT AUTO_INCREMENT PRIMARY KEY,
    monto                   INT(60) NOT NULL,
    idBanco                 INT(10),
    fechayHoraRegistro      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    codigoRegistro          VARCHAR(100), -- Ajustar según tus necesidades
    FOREIGN KEY (idBanco) REFERENCES banco(idBanco)
);



Select * from registroTransaccion;

-- INSERT INTO registroTransaccion (monto, idBanco, codigoRegistro) VALUES (100, 1, 'ABC123');


CREATE TABLE registroTransaccionExterna (
    idTransaccionExterna 	INT AUTO_INCREMENT PRIMARY KEY,
    monto 					INT(60) NOT NULL,
    idBanco					INT,
	codigoRegistro			VARCHAR(100),
    fechayHoraRegistro 		TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (idBanco) REFERENCES banco(idBanco)
);

select * from registroTransaccionExterna;

INSERT INTO banco (nombrePersona, numeroTarjeta, dinero, NIP) VALUES ('Edwin Yovani', '1234', 1000, 1234);

INSERT INTO banco (nombrePersona, numeroTarjeta, dinero, NIP) VALUES ('Fernanda', '1111', 1500, 5678);
-- INSERT INTO cajero (idCajero,nombreBanco, cantidad, idBanco) VALUES (1,'BBVA', 1000, 1);
-- INSERT INTO cajero (idCajero,nombreBanco, cantidad, idBanco) VALUES (1,'BBVA', 1000, 2);
-- INSERT INTO registroTransaccion (monto, idBanco, codigoRegistro) VALUES (500, 1, 'BBVA0012193015');

UPDATE cajero SET cantidad = 2000 WHERE idCajero = 1;
UPDATE banco SET dinero = 2000 WHERE idBanco = 1;
select * from banco;
select* from cajero;
Select * from v_transaccionExterna;
Select * from v_transaccion; 

