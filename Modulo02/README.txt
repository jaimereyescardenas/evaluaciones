/*Para visualizar mejor este archivo, se recomienda abrirlo en Notepad++*/

1.- Contexto del problema (ejercicio 3)

	Se requiere hacer un modelo de base de datos para un sitio web de un cine que gestione datos de las pel�culas,
	sucursales, salas y funciones que se realizan. Adem�s, se quiere tener informaci�n sobre los directores y
	actores que participan en cada pel�cula, manejar un sistema de promociones por cada funci�n, e implementar un
	sistema de comentarios donde los espectadores puedan dejar sus opiniones sobre las pel�culas.
	
	Detalles de los requerimientos:
	
	De cada pel�cula, se almacena una ficha con su t�tulo de distribuci�n, su t�tulo original, su g�nero,
	el idioma original, si tiene subt�tulos en espa�ol o no, los pa�ses de origen, el a�o de la producci�n,
	la URL del sitio web de la pel�cula, la duraci�n (en horas y minutos), la calificaci�n (Apta todo
	p�blico,+9 a�os, +15 a�os,+18 a�os), fecha de estreno en Santiago, un resumen y un identificador
	de la pel�cula. De cada pel�cula interesa conocer la lista de directores y el reparto, es decir para
	cada actor que trabaja, el nombre de todos los personajes que interpreta.
	
	Adem�s, interesa disponer de informaci�n sobre los directores y actores que trabajan en cada
	pel�cula. De ambos, se conoce su nombre (que lo identifica) y su nacionalidad. Adem�s, se desea
	conocer la cantidad de pel�culas en las que dirigieron o actuaron. Tenga en cuenta que hay
	personas que cumplen los dos roles.
	
	Los cines pueden tener m�s de una sala y cada semana cada uno de los cines env�a la cartelera
	para dicha semana, indicando de detalle de las funciones. Para cada funci�n se conoce el d�a de
	la semana y la hora de comienzo, y obviamente la sala y la pel�cula que exhibe. De cada sala se
	sabe el nombre, un n�mero que la identifica dentro del cine y la cantidad de butacas que posee.
	De cada cine se conoce el nombre que lo identifica, su direcci�n y tel�fono para consultas.
	
	Algunos cines cuentan con promociones., estas promociones dependen de la funci�n. (Ej. De
	lunes a jueves antes de las 18:00 horas, 50% de descuento en la sala X del cine para X pel�cula. La
	funci�n del lunes a las 14:00 para la pel�cula X en la sala X, no se cobra a los escolares con
	uniforme. De cada promoci�n se conoce una descripci�n y el descuento que aplica.
	
	Adem�s del resumen de la pel�cula que se incluye en la ficha interesa mostrar la opini�n de las
	personas que vieron la pel�cula. De cada opini�n se conoce el nombre de la persona que la realiza,
	su edad, le fecha en que registr� su opini�n, la calificaci�n que le dio a la pel�cula (Obra Maestra,
	Muy Buena, Buena, Regular, Mala) y el comentario propiamente dicho. A cada opini�n se le asigna
	un n�mero que la identifica respecto de la pel�cula sobre la cual opina.

2.- Planteamiento de la soluci�n

	Para dar soluci�n a los requerimientos, se puede aplicar un modelo relacional de base de datos que 
	incluya todos los datos solicitados, que refleje todas las relaciones entre los datos, y que reduzca 
	las redundancias sin complicar demasiado la estructura del modelo.
	
	Una posible estructura es la siguiente (Formato: nombreTabla  (campo1: descripcionCampo1, campo2: descripcionCampo2, etc.)):

	pelicula   (idPelicula: identificador �nico de la pel�cula,
				titulo_comercial: t�tulo de distribuci�n de la pel�cula,
				titulo_original: t�tulo original de la pel�cula,
				genero_pelicula: g�nero principal de la pel�cula (acci�n, terror, drama, romance, etc.),
				idioma_original: idioma original de la pel�cula,
				subs_espanol: indicador que muestra si la pel�cula posee subt�tulos en espa�ol,
				anio_produccion: a�o en que se realiz� la pel�cula,
				sitio_web_pelicula: URL del sitio web de la pel�cula,
				duracion_pelicula: duraci�n de la pelicula (en horas y minutos),
				calific_pelicula: calificaci�n de la pel�cula (para mayores de 18, todo espectador, etc.),
				fecha_estreno: fecha de estreno de la pel�cula en Santiago,
				resumen_pelicula: breve resumen de la pel�cula)
				
	pais		(idPais: identificador �nico del pa�s,
				nombre_pais: nombre del pa�s)
				
	origen		(pa�ses de origen: referencia a los pa�ses de origen de cada pel�cula (son varios seg�n el requerimiento),
				pel�culas: referencia a las pel�culas que tienen origen en cada pa�s)
				
	director   (nombre_dir: nombre del director (�nico),
				pelis_dirigidas: cantidad de pel�culas dirigidas por director,
				pa�s: referencia al pa�s al que pertenece el director)
				
	lista_dir	(pel�culas: referencia a las pel�culas dirigidas por director,
				directores: referencia a los directores involucrados en cada pel�cula)
				
	actor      (nombre_actor: nombre del actor (�nico),
				pelis_realizadas: cantidad de pel�culas en las que ha participado el actor,
				pa�s: referencia al pa�s al que pertenece el actor)
				
	reparto		(actores: referencia a los actores que participaron en cada pel�cula,
				pel�culas: referencia a las pel�culas en las que particip� cada actor,
				nombre_personaje: nombre del personaje que cada actor interpret� en cada pel�cula)
				
	cine       (nombre_cine: nombre del cine (�nico),
				ciudad_cine: ciudad en la que est� ubicada el cine,
				direccion_cine: direcci�n en que est� ubicado el cine,
				telefono_cine: tel�fono de contacto del cine)

	sala       (idSala: identificador �nico de la sala,
				nombre_sala: nombre de la sala,
				cantidad_butacas: cantidad de butacas (asientos) que tiene la sala,
				cine: referencia al cine al cual pertenece la sala)
			
	funcion    (idFuncion: identificador �nico de cada funci�n,
				cartelera: fecha de inicio de semana (lunes) de la cartelera a la que pertenece la funci�n,
				dia_funcion: d�a de la semana en que se realiza la funci�n,
				hora_funcion: hora en la que se realiza la funci�n,
				sala: referencia a la sala donde se lleva a cabo la funci�n,
				pel�cula: referencia a la pel�cula que es transmitida en la funci�n,
				promoci�n: referencia a la promoci�n aplicada en la funci�n)
				
	promocion	(idPromocion: identificador �nico de la promoci�n,
				descripcion_promo: breve descripci�n de la promoci�n y sus condiciones,
				descuento_promo: descuento aplicado por la promoci�n)
				
	opinion    (idOpinion: identificador �nico de la opini�n,
				nombre_espect: nombre del autor de la opini�n,
				edad_espect: edad del autor de la opini�n,
				fecha_opinion: fecha en que se realiz� la opini�n,
				calific_opinion: calificaci�n asociada a la opini�n (pel�cula buena, regular, mala, etc.),
				comentario: detalle del comentario realizado por el autor de la opini�n,
				pel�cula: referencia a la pel�cula sobre la cual se realiza la opini�n)
				
				
	Las interrelaciones derivadas del conjunto de tablas son las siguientes:
	
	pelicula-pais			(muchos a muchos, regulada por la tabla intermedia 'origen')
	director-pelicula		(muchos a muchos, regulada por la tabla intermedia 'lista_dir')
	actor-pelicula			(muchos a muchos, regulada por la tabla intermedia 'reparto')
	cine-sala				(uno a muchos)
	sala-funcion			(uno a muchos)
	pelicula-funcion		(uno a muchos)
	promocion-funcion		(uno a muchos)
	pelicula-opinion		(uno a muchos)
	
	Las claves primarias de cada una de las tablas son (Formato: nombreTabla  (clavePrimaria). Si es compuesta, tendr� m�s de un campo):
	
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
	
	Las restricciones de clave for�nea para cada una de las tablas son las siguientes:
	
	origen		(idPais: hace referencia al pa�s de origen de la pel�cula,
				idPelicula: hace referencia a la pel�cula)
				
	director	(idPais: hace referencia al pa�s al cual pertenece el director)
	
	lista_dir	(idPelicula: hace referencia a la pel�cula dirigida por cada director,
				nombre_dir: hace referencia al director involucrado en cada pel�cula)
				
	actor		(idPais: hace referencia al pa�s al cual pertenece el actor)
	
	reparto		(idPelicula: hace referencia a la pel�cula donde participa el actor,
				nombre_actor: hace referencia al actor que participa en la pel�cula)
				
	sala		(nombre_cine: hace referencia al cine al que pertenece la sala)
	
	funcion		(idSala: hace referencia a la sala que se utiliza en la funci�n,
				idPelicula: hace referencia a la pel�cula transmitida en la funcion,
				idPromocion: hace referencia a la promoci�n aplicada en la funci�n)
				
	opinion		(idPelicula: hace referencia a la pel�cula de la cual se emite la opini�n)
	
	