-- Consultas a la BBDD EJEMPLO.
-- Se ejecuta sqlplus y se introduce el usuario hr y la contraseña hr
-- Con set linesize 100; hacemos que el resultado se vea mejor
-- Debemos ejecutar commit para confirmar los cambios y que éstos sean permanentes

--1.Insertar un nuevo país.
INSERT INTO countries (country_id, country_name,region_id) VALUES ('ES', 'España', 1);
commit;

--2.Actualiza el id de un país
UPDATE countries SET country_id = 'SP' WHERE country_id = 'ES';
commit;

--3.Borrar país.
DELETE FROM countries WHERE country_id = 'SP';
commit;
