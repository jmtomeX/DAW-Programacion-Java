-- Consultas a la BBDD DESVAN. 
-- Se ejecuta sqlplus y se introduce el usuario desvan y la contraseña desvan
-- Con set linesize 100; hacemos que el resultado se vea mejor

--1.Código y nombre de todos los departamentos.
SELECT * FROM empleados;

--2.Número de cuenta y nombre de los empleados cuya retención es mayor o igual que 10.
SELECT cuenta, nombre FROM empleados WHERE retencion >= 10;

--3.Código y nombre de los empleados ordenados ascendentemente por nombre.
SELECT codigo, nombre FROM empleados ORDER BY nombre;

--4.Código y número de cuenta de los empleados cuyo nombre empiece por 'A' o por 'J'.
SELECT codigo, cuenta FROM empleados WHERE nombre LIKE 'A%' OR nombre LIKE 'J%';

--5.Número de empleados que hay en la base de datos.
SELECT COUNT(*) FROM empleados;

--6.Número de hijos, retención máxima, mínima y media de los empleados agrupados por hijos.
SELECT hijos, MAX(retencion), MIN(retencion), AVG(retencion) FROM empleados GROUP BY hijos;

--7.Nombre y función de los empleados que han trabajado en el departamento 1.
SELECT empleados.nombre, trabajan.funcion 
FROM empleados INNER JOIN trabajan 
  ON empleados.codigo = trabajan.cod_emp 
WHERE trabajan.cod_dep = 1;


