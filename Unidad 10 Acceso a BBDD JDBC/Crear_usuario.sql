-- Primero hay que conectarse como un usuario con privilegios
-- En el caso mio será el usuario system o root con la contraseña root

-- connect system;

CREATE USER <NOMBRE_DEL_USUARIO> IDENTIFIED BY <PASSWORD_DEL_USUARIO>;

GRANT ALL PRIVILEGES TO <NOMBRE_DEL_USUARIO>;

GRANT EXECUTE ANY PROCEDURE TO <NOMBRE_DEL_USUARIO>;
GRANT UNLIMITED TABLESPACE TO <NOMBRE_DEL_USUARIO>;