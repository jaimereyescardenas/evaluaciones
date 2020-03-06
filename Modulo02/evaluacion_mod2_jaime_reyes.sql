/*1.- Consultas SQL a tablas */

/*a.- Mostrar la cantidad de prestaciones de servicios ejecutados entre el
	  01 de octubre y el 26 de noviembre del 2018. */
	  
	  SELECT idPrestacionServicio, fecha
	  FROM prestación_servicio
	  WHERE fecha BETWEEN '2018-10-01' AND '2018-10-26'
	  ORDER BY fecha;
	  
/*b.- Mostrar la cantidad total de prestaciones realizadas agrupadas por idVehiculo. */
	  
	  SELECT v.idVehiculo, ps.idPrestacionServicio
	  FROM vehiculo v
	  JOIN prestación_servicio ps ON (v.idVehiculo = ps.idVehiculo)
	  GROUP BY idVehiculo
	  ORDER BY idVehiculo;
	  
/*c.- Mostrar los vehículos con la menor cantidad de prestaciones de servicios realizados. */
	  
	  SELECT v.idVehiculo
	  FROM vehiculo v
	  GROUP BY idVehiculo
	  HAVING COUNT(ps.prestación_servicio) = (SELECT MIN(COUNT(ps.prestación_servicio))
											  FROM prestación_servicio ps
											  JOIN v ON (v.idVehiculo = ps.idVehiculo)
											  GROUP BY idVehiculo)
	  ORDER BY idVehiculo;

/*2.- Crear con DDL una tabla empleado */
	  
	  CREATE TABLE empleado
	  (
	  idEmpleado int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	  nombre varchar(20) NOT NULL,
	  apellido varchar(20) NOT NULL,
	  direccion varchar(50) NOT NULL,
	  telefono int NULL,
	  idDepartamento int NOT NULL/*,
	  (Asumiendo que idDepartamento es clave foránea de la tabla departamento)
	  FOREIGN KEY (idDepartamento) REFERENCES departamento.idDepartamento*/
	  );
	  
/*3.- Crear un modelo de base de datos que será usado en un sitio web de un cine */
	  
	  DROP DATABASE IF EXISTS gestion_cine;
	  
	  CREATE DATABASE gestion_cine;
	  
	  USE gestion_cine;
	  
	  CREATE TABLE pais
	  (
	  idPais int NOT NULL AUTO_INCREMENT,
	  nombre_pais varchar(20) NOT NULL,
	  PRIMARY KEY (idPais)
	  );
	  
	  CREATE TABLE director
	  (
	  nombre_dir varchar(30) NOT NULL,
	  pelis_dirigidas int NOT NULL,
	  idPais int NOT NULL,
	  PRIMARY KEY (nombre_dir),
	  FOREIGN KEY (idPais) REFERENCES pais(idPais)
	  );
	  
	  CREATE TABLE pelicula
	  (
	  idPelicula int NOT NULL AUTO_INCREMENT,
	  titulo_comercial varchar(50) NOT NULL,
	  titulo_original varchar(50) NOT NULL,
	  genero_pelicula varchar(20) NOT NULL,
	  idioma_original varchar(20) NOT NULL,
	  subs_espanol char(1) NOT NULL,
	  anio_produccion int(4) NOT NULL,
	  sitio_web_pelicula varchar(50) NULL,
	  duracion_pelicula time NOT NULL,
	  calific_pelicula varchar(20) NOT NULL,
	  fecha_estreno date NOT NULL,
	  resumen_pelicula varchar(150) NULL,
	  nombre_dir varchar(30) NOT NULL,
	  PRIMARY KEY (idPelicula)
	  );
	  
	  CREATE TABLE origen
	  (
	  idPais int NOT NULL,
	  idPelicula int NOT NULL,
	  PRIMARY KEY (idPais, idPelicula),
	  FOREIGN KEY (idPais) REFERENCES pais(idPais),
	  FOREIGN KEY (idPelicula) REFERENCES pelicula(idPelicula)
	  );
	  
	  CREATE TABLE lista_dir
	  (
	  idPelicula int NOT NULL,
	  nombre_dir varchar(30) NOT NULL,
	  PRIMARY KEY (idPelicula, nombre_dir),
	  FOREIGN KEY (idPelicula) REFERENCES pelicula(idPelicula),
	  FOREIGN KEY (nombre_dir) REFERENCES director(nombre_dir)
	  );
	  
	  CREATE TABLE actor
	  (
	  nombre_actor varchar(30) NOT NULL,
	  pelis_realizadas int NOT NULL,
	  idPais int NOT NULL,
	  PRIMARY KEY (nombre_actor),
	  FOREIGN KEY (idPais) REFERENCES pais(idPais)
	  );
	  
	  CREATE TABLE reparto
	  (
	  nombre_actor varchar(30) NOT NULL,
	  idPelicula int NOT NULL,
	  nombre_personaje varchar(30) NOT NULL,
	  PRIMARY KEY (nombre_actor, idPelicula),
	  FOREIGN KEY (nombre_actor) REFERENCES actor(nombre_actor),
	  FOREIGN KEY (idPelicula) REFERENCES pelicula(idPelicula)
	  );
	  
	  CREATE TABLE cine
	  (
	  nombre_cine varchar(25) NOT NULL,
	  ciudad_cine varchar(25) NOT NULL,
	  direccion_cine varchar(50) NOT NULL,
	  telefono_cine int NOT NULL,
	  PRIMARY KEY (nombre_cine)
	  );
	  
	  CREATE TABLE sala
	  (
	  idSala int NOT NULL AUTO_INCREMENT,
	  nombre_sala varchar(20) NOT NULL,
	  cantidad_butacas int NOT NULL,
	  nombre_cine varchar(25) NOT NULL,
	  PRIMARY KEY (idSala),
	  FOREIGN KEY (nombre_cine) REFERENCES cine(nombre_cine)
	  );
	  
	  CREATE TABLE promocion
	  (
	  idPromocion int NOT NULL AUTO_INCREMENT,
	  descripcion_promo varchar(150) NOT NULL,
	  descuento_promo int NOT NULL,
	  PRIMARY KEY (idPromocion)
	  );
	  
	  CREATE TABLE funcion
	  (
	  idFuncion int NOT NULL AUTO_INCREMENT,
	  cartelera date NOT NULL,
	  dia_funcion varchar(9) NOT NULL,
	  hora_funcion time NOT NULL,
	  idSala int NOT NULL,
	  idPelicula int NOT NULL,
	  idPromocion int NOT NULL,
	  PRIMARY KEY (idFuncion),
	  FOREIGN KEY (idSala) REFERENCES sala(idSala),
	  FOREIGN KEY (idPelicula) REFERENCES pelicula(idPelicula),
	  FOREIGN KEY (idPromocion) REFERENCES promocion(idPromocion)
	  );
	  
	  CREATE TABLE opinion
	  (
	  idOpinion int NOT NULL AUTO_INCREMENT,
	  nombre_espect varchar(30) NOT NULL,
	  edad_espect int NULL,
	  fecha_opinion date NOT NULL,
	  calific_opinion varchar(15) NOT NULL,
	  comentario varchar(500) NOT NULL,
	  idPelicula int NOT NULL,
	  PRIMARY KEY (idOpinion),
	  FOREIGN KEY (idPelicula) REFERENCES pelicula(idPelicula)
	  );
	  