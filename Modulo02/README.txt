/*Para visualizar mejor este archivo, se recomienda abrirlo en Notepad++*/

1.- Contexto del problema (ejercicio 3)

	Se requiere hacer un modelo de base de datos para un sitio web de un cine que gestione datos de las películas,
	sucursales, salas y funciones que se realizan. Además, se quiere tener información sobre los directores y
	actores que participan en cada película, manejar un sistema de promociones por cada función, e implementar un
	sistema de comentarios donde los espectadores puedan dejar sus opiniones sobre las películas.
	
	Detalles de los requerimientos:
	
	De cada película, se almacena una ficha con su título de distribución, su título original, su género,
	el idioma original, si tiene subtítulos en español o no, los países de origen, el año de la producción,
	la URL del sitio web de la película, la duración (en horas y minutos), la calificación (Apta todo
	público,+9 años, +15 años,+18 años), fecha de estreno en Santiago, un resumen y un identificador
	de la película. De cada película interesa conocer la lista de directores y el reparto, es decir para
	cada actor que trabaja, el nombre de todos los personajes que interpreta.
	
	Además, interesa disponer de información sobre los directores y actores que trabajan en cada
	película. De ambos, se conoce su nombre (que lo identifica) y su nacionalidad. Además, se desea
	conocer la cantidad de películas en las que dirigieron o actuaron. Tenga en cuenta que hay
	personas que cumplen los dos roles.
	
	Los cines pueden tener más de una sala y cada semana cada uno de los cines envía la cartelera
	para dicha semana, indicando de detalle de las funciones. Para cada función se conoce el día de
	la semana y la hora de comienzo, y obviamente la sala y la película que exhibe. De cada sala se
	sabe el nombre, un número que la identifica dentro del cine y la cantidad de butacas que posee.
	De cada cine se conoce el nombre que lo identifica, su dirección y teléfono para consultas.
	
	Algunos cines cuentan con promociones., estas promociones dependen de la función. (Ej. De
	lunes a jueves antes de las 18:00 horas, 50% de descuento en la sala X del cine para X película. La
	función del lunes a las 14:00 para la película X en la sala X, no se cobra a los escolares con
	uniforme. De cada promoción se conoce una descripción y el descuento que aplica.
	
	Además del resumen de la película que se incluye en la ficha interesa mostrar la opinión de las
	personas que vieron la película. De cada opinión se conoce el nombre de la persona que la realiza,
	su edad, le fecha en que registró su opinión, la calificación que le dio a la película (Obra Maestra,
	Muy Buena, Buena, Regular, Mala) y el comentario propiamente dicho. A cada opinión se le asigna
	un número que la identifica respecto de la película sobre la cual opina.

2.- Planteamiento de la solución

	Para dar solución a los requerimientos, se puede aplicar un modelo relacional de base de datos que 
	incluya todos los datos solicitados, que refleje todas las relaciones entre los datos, y que reduzca 
	las redundancias sin complicar demasiado la estructura del modelo.
	
	Una posible estructura es la siguiente (Formato: nombreTabla  (campo1: descripcionCampo1, campo2: descripcionCampo2, etc.)):

	pelicula   (idPelicula: identificador único de la película,
				titulo_comercial: título de distribución de la película,
				titulo_original: título original de la película,
				genero_pelicula: género principal de la película (acción, terror, drama, romance, etc.),
				idioma_original: idioma original de la película,
				subs_espanol: indicador que muestra si la película posee subtítulos en español,
				anio_produccion: año en que se realizó la película,
				sitio_web_pelicula: URL del sitio web de la película,
				duracion_pelicula: duración de la pelicula (en horas y minutos),
				calific_pelicula: calificación de la película (para mayores de 18, todo espectador, etc.),
				fecha_estreno: fecha de estreno de la película en Santiago,
				resumen_pelicula: breve resumen de la película)
				
	pais		(idPais: identificador único del país,
				nombre_pais: nombre del país)
				
	origen		(países de origen: referencia a los países de origen de cada película (son varios según el requerimiento),
				películas: referencia a las películas que tienen origen en cada país)
				
	director   (nombre_dir: nombre del director (único),
				pelis_dirigidas: cantidad de películas dirigidas por director,
				país: referencia al país al que pertenece el director)
				
	lista_dir	(películas: referencia a las películas dirigidas por director,
				directores: referencia a los directores involucrados en cada película)
				
	actor      (nombre_actor: nombre del actor (único),
				pelis_realizadas: cantidad de películas en las que ha participado el actor,
				país: referencia al país al que pertenece el actor)
				
	reparto		(actores: referencia a los actores que participaron en cada película,
				películas: referencia a las películas en las que participó cada actor,
				nombre_personaje: nombre del personaje que cada actor interpretó en cada película)
				
	cine       (nombre_cine: nombre del cine (único),
				ciudad_cine: ciudad en la que está ubicada el cine,
				direccion_cine: dirección en que está ubicado el cine,
				telefono_cine: teléfono de contacto del cine)

	sala       (idSala: identificador único de la sala,
				nombre_sala: nombre de la sala,
				cantidad_butacas: cantidad de butacas (asientos) que tiene la sala,
				cine: referencia al cine al cual pertenece la sala)
			
	funcion    (idFuncion: identificador único de cada función,
				cartelera: fecha de inicio de semana (lunes) de la cartelera a la que pertenece la función,
				dia_funcion: día de la semana en que se realiza la función,
				hora_funcion: hora en la que se realiza la función,
				sala: referencia a la sala donde se lleva a cabo la función,
				película: referencia a la película que es transmitida en la función,
				promoción: referencia a la promoción aplicada en la función)
				
	promocion	(idPromocion: identificador único de la promoción,
				descripcion_promo: breve descripción de la promoción y sus condiciones,
				descuento_promo: descuento aplicado por la promoción)
				
	opinion    (idOpinion: identificador único de la opinión,
				nombre_espect: nombre del autor de la opinión,
				edad_espect: edad del autor de la opinión,
				fecha_opinion: fecha en que se realizó la opinión,
				calific_opinion: calificación asociada a la opinión (película buena, regular, mala, etc.),
				comentario: detalle del comentario realizado por el autor de la opinión,
				película: referencia a la película sobre la cual se realiza la opinión)
				
				
	Las interrelaciones derivadas del conjunto de tablas son las siguientes:
	
	pelicula-pais			(muchos a muchos, regulada por la tabla intermedia 'origen')
	director-pelicula		(muchos a muchos, regulada por la tabla intermedia 'lista_dir')
	actor-pelicula			(muchos a muchos, regulada por la tabla intermedia 'reparto')
	cine-sala				(uno a muchos)
	sala-funcion			(uno a muchos)
	pelicula-funcion		(uno a muchos)
	promocion-funcion		(uno a muchos)
	pelicula-opinion		(uno a muchos)
	
	Las claves primarias de cada una de las tablas son (Formato: nombreTabla  (clavePrimaria). Si es compuesta, tendrá más de un campo):
	
	pelicula	(idPelicula)
	pais		(idPais)
	origen		(idPelicula, idPais)
	director	(nombre_dir)
	lista_dir	(idPelicula, nombre_dir)
	actor		(nombre_actor)
	reparto		(idPelicula, nombre_actor)
	cine		(nombre_cine)
	sala		(idSala)
	funcion		(idFuncion)
	promocion	(idPromocion)
	opinion		(idOpinion)
	
	Las restricciones de clave foránea para cada una de las tablas son las siguientes:
	
	origen		(idPais: hace referencia al país de origen de la película,
				idPelicula: hace referencia a la película)
				
	director	(idPais: hace referencia al país al cual pertenece el director)
	
	lista_dir	(idPelicula: hace referencia a la película dirigida por cada director,
				nombre_dir: hace referencia al director involucrado en cada película)
				
	actor		(idPais: hace referencia al país al cual pertenece el actor)
	
	reparto		(idPelicula: hace referencia a la película donde participa el actor,
				nombre_actor: hace referencia al actor que participa en la película)
				
	sala		(nombre_cine: hace referencia al cine al que pertenece la sala)
	
	funcion		(idSala: hace referencia a la sala que se utiliza en la función,
				idPelicula: hace referencia a la película transmitida en la funcion,
				idPromocion: hace referencia a la promoción aplicada en la función)
				
	opinion		(idPelicula: hace referencia a la película de la cual se emite la opinión)
	
	