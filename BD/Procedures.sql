Use cajero;

DROP PROCEDURE IF exists insertarCliente;
DELIMITER $$

CREATE PROCEDURE insertarCliente(                                    
    IN var_monto             INT(100), -- 1
    IN var_idBanco           INT(100),     -- 2
    OUT var_idTransaccion    INT(100),     -- 3
    OUT var_codigoRegistro   VARCHAR(100)  -- 4  
)
BEGIN        
    -- Generar el código con minutos y segundos para mayor precisión
    SET var_codigoRegistro = CONCAT('BBVA00', DAYOFMONTH(CURDATE()), HOUR(CURTIME()), MINUTE(CURTIME()), SECOND(CURTIME()));

    -- Insertar en la tabla 'registroTransaccion'
    INSERT INTO registroTransaccion (monto, idBanco, codigoRegistro) 
    VALUES (var_monto, var_idBanco, var_codigoRegistro);

    -- Obtener el ID recién insertado en 'registroTransaccion'
    SET var_idTransaccion = LAST_INSERT_ID();
END$$

DELIMITER $$

DELIMITER $$

CREATE PROCEDURE insertarClienteExterno(                                    
    IN var_monto             INT(100), -- 1
    IN var_idBanco           INT(100), 
    IN var_codigoRegistro   	VARCHAR(100),-- 2
    OUT idTransaccionExterna    INT(100)     -- 3  -- 4  
)
BEGIN        
    -- Generar el código con minutos y segundos para mayor precisión

    -- Insertar en la tabla 'registroTransaccion'
    INSERT INTO registroTransaccionExterna (monto, idBanco, codigoRegistro) 
    VALUES (var_monto, var_idBanco, var_codigoRegistro);

    -- Obtener el ID recién insertado en 'registroTransaccion'
    SET idTransaccionExterna = LAST_INSERT_ID();
END$$

DELIMITER $$

CREATE PROCEDURE actualizarMontos(
    IN var_dinero          INT,  -- Nuevo monto en la cuenta del banco
    IN var_cantidad        INT,  -- Cantidad a restar
    IN var_idBanco         INT,  -- ID del banco
    IN var_idCajero        INT   -- ID del cajero
)
BEGIN
    DECLARE saldoBanco INT;
    DECLARE saldoCajero INT;
    
    SELECT dinero INTO saldoBanco FROM banco WHERE idBanco = var_idBanco;

    SELECT cantidad INTO saldoCajero FROM cajero WHERE idCajero = var_idCajero;

    SET saldoBanco = saldoBanco - var_cantidad;

    SET saldoCajero = saldoCajero - var_cantidad;

    UPDATE banco SET dinero = saldoBanco WHERE idBanco = var_idBanco;

    UPDATE cajero SET cantidad = saldoCajero WHERE idCajero = var_idCajero;
END $$

DELIMITER ;

DROP PROCEDURE IF exists actualizarMontosInterno;
DELIMITER $$

CREATE PROCEDURE actualizarMontosInterno(
    IN var_dinero          INT,  -- Nuevo monto en la cuenta del banco
    IN var_cantidad        INT,  -- Cantidad a restar
    IN var_idBanco         INT,  -- ID del banco
    IN var_idCajero        INT   -- ID del cajero
)
BEGIN
    DECLARE saldoBanco INT;
    DECLARE saldoCajero INT;
    
    SELECT dinero INTO saldoBanco FROM banco WHERE idBanco = var_idBanco;

    SELECT cantidad INTO saldoCajero FROM cajero WHERE idCajero = var_idCajero;

    SET saldoBanco = saldoBanco - var_cantidad;

    SET saldoCajero = saldoCajero - var_cantidad;


    UPDATE banco SET dinero = saldoBanco WHERE idBanco = 1;
END $$

DELIMITER ;

DROP PROCEDURE IF exists actualizarMontosExterno;
DELIMITER $$


CREATE PROCEDURE actualizarMontosExterno(
    IN var_cantidad          INT,  -- Nuevo monto en la cuenta del banco
    IN var_idCajero         INT  -- ID del banco
)
BEGIN
    DECLARE saldoBanco INT;
    
    SELECT cantidad INTO saldoBanco FROM cajero WHERE idCajero = 1;

    SET saldoBanco = saldoBanco - var_cantidad;

    UPDATE cajero SET cantidad = saldoBanco WHERE idCajero = 1;

END $$

DELIMITER ;


DELIMITER $$
CREATE PROCEDURE insertarTransaccion(
                                    IN var_monto	 		VARCHAR(100),	-- 1
                                    IN var_idBanco 			VARCHAR(16),	-- 2
                                    IN var_codigoRegistro 	VARCHAR(20),	-- 3
                                    OUT	var_idTransaccion   INT(100)        -- 4
				)
BEGIN        
        INSERT INTO registroTransaccion	(
							monto,idBanco,codigoRegistro) 
                    VALUES	(
							var_monto, var_idBanco,var_codigoRegistro
                            );
        SET var_idTransaccion = LAST_INSERT_ID();

    END$$

DELIMITER ;

DELIMITER $$
CREATE PROCEDURE insertarTransaccionExterna(
                                    IN var_monto	 				VARCHAR(100),	-- 1
                                    IN var_idBanco 					VARCHAR(16),	-- 2
                                    IN var_codigoRegistro 			VARCHAR(20),
                                    OUT	var_idTransaccionExterna    INT(100)            	-- 3
				)
BEGIN        
        INSERT INTO registroTransaccionExterna	(
							monto,idBanco,codigoRegistro) 
                    VALUES	(
							var_monto, var_idBanco,var_codigoRegistro
                            );
        SET var_idTransaccionExterna = LAST_INSERT_ID();

    END$$

DELIMITER ;