Algoritmo menu_ejercicio_completo_full_stack
	
	Definir op Como Entero
	
	Repetir
		
		Escribir "******************MENU******************"
		Escribir "*1.Secuencial                          *"
		Escribir "*2.Condicional Si-Entonces             *"
		Escribir "*3.Condicional Si-Entonces anidado     *"
		Escribir "*4.Condicional Según                   *"
		Escribir "*5.Repetitiva Mientras                 *"
		Escribir "*6.Repetitiva Repetir                  *"
		Escribir "*7.Repetitiva Para                     *"
		Escribir "*8.Arreglo simple                      *"
		Escribir "*9.Arreglo bidimensional               *"
		Escribir "*10.SALIR                              *"
		Escribir ""
		
		Leer op
		
		Segun op hacer
			
			1:
				
				secuencial()
				Borrar pantalla
				
			2:
				
				cond_if()
				Borrar pantalla
				
			3:
				
				cond_if_anidado()
				Borrar pantalla
				
			4:
				
				cond_case()
				Borrar pantalla
				
			5:
				
				rep_while()
				Borrar pantalla
				
			6:
				
				rep_do_while()
				Borrar pantalla
				
			7:
				
				rep_for()
				Borrar pantalla
				
			8:
				
				arreglo_simple()
				Borrar pantalla
				
			9:
				
				arreglo_bidimensional()
				Borrar pantalla
				
			10:
				
				Escribir "Ha salido exitosamente del menú. Felicidades :D"
				
				
			De otro modo
				
				Escribir "Ha ingresado una opción no válida."
				Esperar tecla
				Borrar pantalla
				
				
		FinSegun
		
	Hasta Que op = 10
	
FinAlgoritmo


Funcion secuencial()
	
	Definir a,b,c como entero
	Definir prom_1 Como Real
	
	prom_1 <- 0
	
	Escribir "***************************************"
	Escribir "Ingrese el primer número: " Sin saltar
	Leer a
	Escribir "Ingrese el segundo número: " Sin saltar
	Leer b
	Escribir "Ingrese el tercer número: " Sin saltar
	Leer c
	
	prom_1 <- (a + b + c) / 3
	
	Escribir "El promedio de los tres números es ", prom_1, "."
	Esperar tecla
	
FinFuncion

Funcion cond_if()
	
	Definir nombre_1 como caracter
	Definir genero_1 como entero
	
	Escribir "*****************************************************"
	Escribir "Ingrese nombre de la persona: " Sin saltar
	Leer nombre_1
	Escribir "Ingrese género de la persona (1 -> Masculino; 2 -> Femenino): " Sin saltar
	Leer genero_1
	
	Si genero_1 = 1 entonces
		
		Escribir nombre_1, " debe ir al baño de hombres."
		
	FinSi
	
	Si genero_1 = 2 entonces
		
		Escribir nombre_1, " debe ir al baño de mujeres."
		
	FinSi
	
	Esperar tecla
	
FinFuncion

Funcion cond_if_anidado()
	
	Definir nombre_2 como caracter
	Definir genero_2,serv como entero
	
	Escribir "******************************************************"
	Escribir "Ingrese nombre de la persona: " Sin saltar
	Leer nombre_2
	Escribir "Ingrese género de la persona (1 -> Masculino; 2 -> Femenino): " Sin saltar
	Leer genero_2
	Escribir "Ingrese tipo de servicio a ocupar (1 -> WC; 2 -> Ducha): " Sin saltar
	Leer serv
	
	Si genero_2 = 1 entonces
		
		Si serv = 1 Entonces
			
			Escribir nombre_2, " debe ir al baño de hombres y su tarifa es de $250."
			
		FinSi
		
		Si serv = 2 Entonces
			
			Escribir nombre_2, " debe ir a las duchas del baño de hombres y su tarifa es de $2500."
			
		FinSi
		
	FinSi
	
	Si genero_2 = 2 entonces
		
		Si serv = 1 Entonces
			
			Escribir nombre_2, " debe ir al baño de mujeres y su tarifa es de $250."
			
		FinSi
		
		Si serv = 2 Entonces
			
			Escribir nombre_2, " debe ir a las duchas del baño de mujeres y su tarifa es de $2500."
			
		FinSi
		
	FinSi
	
	Esperar Tecla
	
FinFuncion

Funcion cond_case()
	
	Definir num como entero
	
	Escribir "***************************************"
	Escribir "Ingrese un número del 1 al 10: " Sin saltar
	Leer num
	
	Segun num hacer
		
		1:
			
			Escribir "El número ingresado es uno."
			
		2:
			
			Escribir "El número ingresado es dos."
			
			
		3:
			
			Escribir "El número ingresado es tres."
			
			
		4:
			
			Escribir "El número ingresado es cuatro."
			
			
		5:
			
			Escribir "El número ingresado es cinco."
			
			
		6:
			
			Escribir "El número ingresado es seis."
			
			
		7:
			
			Escribir "El número ingresado es siete."
			
			
		8:
			
			Escribir "El número ingresado es ocho."
			
			
		9:
			
			Escribir "El número ingresado es nueve."
			
			
		10:
			
			Escribir "El número ingresado es diez."
			
			
		De otro modo
			
			Escribir "No ha ingresado un número entre 1 y 10."
			
	FinSegun
	
	Esperar Tecla
	
FinFuncion

Funcion rep_while()
	
	Definir num_1,suma_1,cont_1 como entero
	Definir prom_2 como real
	
	cont_1 <- 0
	suma_1 <- 0
	prom_2 <- 0
	
	Escribir "***************************************"
	Escribir "Ingrese un número: " Sin Saltar
	Leer num_1
	
	Mientras num_1 <> 0 hacer
		
		suma_1 <- suma_1 + num_1
		cont_1 <- cont_1 + 1
		Escribir "Ingrese un número: " Sin Saltar
		Leer num_1
		
	FinMientras
	
	Si cont_1 > 0 Entonces
		
		prom_2 <- suma_1 / cont_1
		
	FinSi
	
	Escribir "***************************************"
	Escribir "Se ha ingresado un 0."
	
	Si cont_1 = 1 Entonces
		
		Escribir "Se ha ingresado solo un número y es ", prom_2, "."
		
	FinSi
	
	Si cont_1 > 1 Entonces
		
		Escribir "Se han ingresado ", cont_1, " números y su promedio es ", prom_2, "."
		
	FinSi
	
	Esperar Tecla
	
FinFuncion

Funcion rep_do_while()
	
	Definir nombre_7 como caracter
	Definir cont_7 como entero
	
	cont_7 <- 0
	
	Escribir "***************************************"
	
	Repetir
		
		Escribir "Ingrese un nombre: " Sin Saltar
		Leer nombre_7
		
		Si nombre_7 <> "Juan" entonces
			
			cont_7 <- cont_7 + 1
			
		FinSi
		
	Hasta Que nombre_7 = "Juan"
	
	Escribir "Se ha ingresado el nombre Juan."
	
	Si cont_7 = 1 Entonces
		
		Escribir "Se realizó ", cont_7, " intento antes de ingresar el nombre Juan."
		
	FinSi
	
	Si cont_7 > 1 Entonces
		
		Escribir "Se realizaron ", cont_7, " intentos antes de ingresar el nombre Juan."
		
	FinSi
	
	Esperar tecla
	
FinFuncion

Funcion rep_for()
	
	Definir nombres,comp como caracter
	Definir i,j,f,cont_5,suma_cont,reg como entero
	
	Dimension nombres[10],comp[10],cont_5[10]
	
	suma_cont <- 0
	reg <- 0
	
	Para i <- 0 hasta 9 Hacer
		
		cont_5[i] <- 0
		
	FinPara
	
	Escribir "************************************************"
	
	Para i <- 0 hasta 9 hacer
		
		Escribir "Ingrese un nombre" Sin Saltar
		Leer nombres[i]
		
	FinPara
	
	Escribir "************************************************"
	
	Para i <- 0 hasta 9 Hacer
		
		comp[i] <- nombres[i]
		
	FinPara
	
	Para i <- 0 hasta 9 Hacer
		
		f <- 9
		
		Para j <- 0 hasta f Hacer
			
			Si i > j Entonces
				
				Si nombres[i] = comp[j] entonces
					
					cont_5[i] = 1
					cont_5[j] = 0
					f <- j
					
				FinSi
				
			FinSi
			
		FinPara
		
	FinPara
	
	Para i <- 0 hasta 9 Hacer
		
		suma_cont <- suma_cont + cont_5[i]
		
	FinPara
	
	Si suma_cont = 0 Entonces
		
		Escribir "Ninguno de los nombres ingresados se repitió más de una vez."
		
	SiNo
		
		Si suma_cont = 1 Entonces
			
			Escribir "El nombre que se repite más de una vez es " Sin Saltar
			
			Para i <- 0 hasta 9 Hacer
				
				Si cont_5[i] = 1 Entonces
					
					Escribir nombres[i] Sin Saltar
					
				FinSi
				
			FinPara
			
			Escribir "."
			
		FinSi
		
		Si suma_cont > 1 entonces
			
			Escribir "Los nombres que se repiten más de una vez son " Sin Saltar
			
			Para i <- 0 hasta 9 Hacer
				
				Si cont_5[i] = 1 Entonces
					
					reg <- reg + 1
					
					Si reg < suma_cont Entonces
						
						Escribir nombres[i], ", " Sin Saltar
						
					FinSi
					
					Si reg = suma_cont Entonces
						
						Escribir "y ", nombres[i], "."
						
					FinSi
					
				FinSi
				
			FinPara
			
		FinSi
		
		
	FinSi
	
	Esperar tecla

FinFuncion

Funcion arreglo_simple()
	
	Definir alumnos Como Caracter
	Definir n,q como entero
	
	Escribir "************************************************"
	Escribir "Ingrese cantidad de alumnos presentes: " Sin saltar
	Leer n
	
	Si n > 0 Entonces
		
		Dimension alumnos[n]
		
		Escribir "************************************************"
		
		Para q <- 0 hasta n - 1 Hacer
			
			Escribir "Ingrese el nombre del alumno ", q + 1, ": " Sin Saltar
			Leer alumnos[q]
			
		FinPara
		
		Escribir "Los alumnos del curso Full Stack Java presentes hoy son:"
		
		Para q <- 0 hasta n - 1 Hacer
			
			Si (q + 1) mod 5 <> 0 Entonces
				
				Escribir alumnos[q] ", " Sin Saltar
				
			FinSi
			
			Si (q + 1) mod 5 = 0 Entonces
				
				Escribir alumnos[q] ", "
				
			FinSi
			
		FinPara
		
		Esperar tecla
		
	FinSi
	
FinFuncion

Funcion arreglo_bidimensional()
	
	Definir alumnos1,tipo Como Caracter
	Definir h,p,r como entero
	
	Dimension  tipo[4]
	
	tipo[0] <- "nombre"
	tipo[1] <- "apellido"
	tipo[2] <- "fono"
	tipo[3] <- "e-mail"
	
	Escribir "**********************************************************"
	Escribir "Ingrese cantidad de alumnos: " Sin saltar
	Leer h
	
	Si h > 0 Entonces
		
		Dimension alumnos[h,4]
		
		Para p <- 0 hasta h - 1 Hacer
			
			Escribir "**********************************************************"
			Escribir "Ingrese los datos del alumno ", p + 1, ":"
			Escribir "**********************************************************"
			
			Para r <- 0 hasta 3 hacer
				
				Escribir "Ingrese ", tipo[r], ": " Sin Saltar
				Leer alumnos[p,r]
				
			FinPara
			
		FinPara
		
		Escribir "**********************************************************"
		Escribir "Los datos de los alumnos del curso Full Stack Java son: "
		Escribir ""
		
		Para p <- 0 hasta h - 1 Hacer
			
			Escribir "Nombre: ", alumnos[p,0], " ", alumnos[p,1], "  " Sin Saltar
			Escribir "Fono: ", alumnos[p,2], "  " Sin Saltar
			Escribir "E-mail: ", alumnos[p,3]
			
		FinPara
		
		Esperar tecla
		
	FinSi
	
FinFuncion
