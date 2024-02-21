Use cajero;
    
    DROP VIEW IF EXISTS v_datos;
CREATE VIEW v_datos AS
    SELECT  
            B.nombrePersona,
            B.numeroTarjeta,
            B.dinero,
            B.NIP,
            C.idBanco,
            C.idCajero,
            C.nombreBanco,
            C.cantidad
    FROM    banco B
    INNER JOIN cajero C ON C.idBanco = B.idBanco;
    select * from v_datos;
    
DROP VIEW IF EXISTS v_transaccion;
CREATE VIEW v_transaccion AS
    SELECT  T.idTransaccion,
            T.monto,
            T.fechayHoraRegistro,
            T.idBanco,
            T.codigoRegistro,
            B.nombrePersona,
            B.numeroTarjeta,
            B.NIP
    FROM    banco B
    INNER JOIN registroTransaccion T ON T.idBanco = B.idBanco;
    
Select * from   v_transaccion; 
    
    DROP VIEW IF EXISTS v_transaccionExterna;
CREATE VIEW v_transaccionExterna AS
    SELECT  T.idTransaccionExterna,
            T.monto,
            T.fechayHoraRegistro,
            T.idBanco,
            T.codigoRegistro
    FROM    banco B
    INNER JOIN registroTransaccionExterna T ON T.idBanco = B.idBanco;
    Select * from v_transaccionExterna;
