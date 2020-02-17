package Cajero;

import javax.swing.JOptionPane;

public class Principal {
	
	//Número de clientes con los que trabaja el banco
	public static final int NUM_CLIENTES = 10;
	
	//Credenciales de autenticación del Administrador
	public static final String USER = "root";
	public static final String PASS = "root";
	
	public static void main(String[] args) {
		
		/* Indices filas: Clientes (cada uno con su cuenta)
		 * Indices columnas: 0.- Número Cuenta; 1.- Tipo Cuenta; 2.- RUT;
		 * 3.- Nombre; 4.- Apellido; 5.- Clave */
		String[][] cliente = new String[NUM_CLIENTES][6];
		
		/* Indices filas: Cuentas (cada una con su cliente)
		 * Indices columnas: 0.- Número Cuenta; 1.- Saldo Cuenta */
		int[][] cuenta = new int[NUM_CLIENTES][2];
		
		/* Indices filas: Clientes
		 * Indices columnas: Movimientos */
		String[][] movimiento = new String[NUM_CLIENTES][5];
		
		//Se inicializan los arreglos y se crean los clientes iniciales
		inicializar(cliente, movimiento, cuenta);
		Cliente.crearClientesIniciales(cliente, cuenta);
		
		int respuesta1 = 0;
		
		while (respuesta1 != 3) { //MENU INICIAL
			
			respuesta1 = 0;
			respuesta1 = Integer.parseInt(JOptionPane.showInputDialog
						 ("Seleccione el tipo de usuario: "+ "\n" 
						 + "1.- Administrador" + "\n"
						 + "2.- Cliente" + "\n"
						 + "3.- Salir"));
	        
	        switch (respuesta1) {
	        
      		case 1:  //MENU ADMINISTRADOR
      			
      			int respuesta2 = 0;
      			validarAdmin();
      			
      			while (respuesta2 != 4) {
      				
      				respuesta2 = Integer.parseInt(JOptionPane.showInputDialog
      							 ("Seleccione una opción: "+ "\n"
      							  + "1.- Crear cuenta" + "\n" 
      							  + "2.- Crear cliente" + "\n" 
      							  + "3.- Mostrar cliente" + "\n" 
      							  + "4.- Salir"));
      		        
      		        switch (respuesta2) {
      		          
	      		        case 1:
	      		        	
	      		        	Cliente.crearCuenta(cliente, cuenta);
		                    break;
	  		                    
		          		case 2:
		          			
		          			Cliente.crearCliente(cliente);
		                    break;
	  		                    
  		                case 3:
  		            	   
  		            	    int indice =  Integer.parseInt(
  		            			   		 JOptionPane.showInputDialog(
  		            			   		 "Ingrese el índice del cliente"
  		            			   		 + " a mostrar:"  ));
  		            	    Cliente.mostrarCliente(cliente, indice);
  		            	    break;
  		            	    
  		                case 4:
	      		        	
  		                	JOptionPane.showMessageDialog(null, "Sesión finalizada."
  		        					+ " Gracias por usar Cajero Awakelab. ");
		                    break;
  		            	    
  		                default:
  		            	   
  		            	   JOptionPane.showMessageDialog(null, 
  		            			   		"La opción elegida es incorrecta. "
  		            			   		+ "Intente de nuevo.");
	  		            	   
  		           	}
      		        
	        	}
      			
      			break;
      			
      		case 2: //MENU CLIENTE
      			
      			int respuesta3 = 0;
      			int ind_cliente = 0;
      			ind_cliente = validarCliente(cliente);
      			
      			while (respuesta3 != 6) {
      				
      				respuesta3 = Integer.parseInt(JOptionPane.showInputDialog(
      							 "Seleccione una opción: " + "\n"
      							 + "1.- Abonar dinero" + "\n" 
      							 + "2.- Retirar dinero" + "\n"
      							 + "3.- Consultar saldo" + "\n"
      							 + "4.- Cambiar clave" + "\n"
      							 + "5.- Ver últimos movimientos" + "\n" 
      							 + "6.- Salir"));
  			        
  			        switch (respuesta3) {
  			        
  			        	case 1:
  			        		
  			        		Cuenta.abonarDinero(cuenta, movimiento, ind_cliente);
  			        		
  			        		break;
  			        		
      			        case 2:
      			        	
      			        	Cuenta.retirarDinero(cuenta, movimiento, ind_cliente);
  			        
  			        		break;
  			        		
      			        case 3:
      			        	
      			        	Cuenta.consultarSaldo(cuenta, ind_cliente);
      			        	
  			    			break;
  			    			
      			        case 4:
      			        	
      						Cliente.cambiarClave(cliente, movimiento, 
      											 ind_cliente);
      			        	
      			        	break;
      			        	
      			        case 5:
      			        	
      						 Cuenta.consultarUltimosMovimientos(movimiento, 
      								 							ind_cliente);
      			        	
      			        	break;
      			        	
      			        case 6:
    			        	
      			        	JOptionPane.showMessageDialog(null, "Sesión finalizada."
	        						+ " Gracias por usar Cajero Awakelab. ");
   						 
   			        	break;
      			        	
      			      default:
 		            	   
 		            	   JOptionPane.showMessageDialog(null, 
 		            			   		"La opción elegida es incorrecta. "
 		            			   		+ "Intente de nuevo.");
      			        	
  			        }
  			        
      			}
      			
      			break;
      			
      		case 3:
	        	
	        	JOptionPane.showMessageDialog(null, "Gracias por usar "
	        										+ "Cajero Awakelab.");
	        	break;
	        
      			
      		default:
           	   
           	   JOptionPane.showMessageDialog(null, 
           			   		"La opción elegida es incorrecta. "
           			   		+ "Intente de nuevo.");
      			
	        }
	        
        }
		
	}
	
	/* Método que sirve para validar las credenciales de administrador
	 * antes de dar acceso al menú de administrador*/
	public static void validarAdmin() {
		
		boolean valido = false;
		
		while (!valido) {
			
			String usuario = JOptionPane.showInputDialog(null, "Ingrese nombre "
							 		+ "de usuario:", "Ingrese datos de usuario", 
							 		JOptionPane.QUESTION_MESSAGE);
			String clave = JOptionPane.showInputDialog(null, "Ingrese clave:", 
												   "Ingrese datos de usuario", 
												   JOptionPane.QUESTION_MESSAGE);
			
			if (usuario.equals(USER) && clave.equals(PASS)) {
				
				JOptionPane.showMessageDialog(null, "Usuario validado. " 
											  + "Bienvenido.", 
											  "Bienvenido", 
											  JOptionPane.INFORMATION_MESSAGE);
				valido = true;
				
			} else {
				
				JOptionPane.showMessageDialog(null, "Usuario o clave incorrectos. "
											  + "Intente de nuevo.", "Datos " 
											  + "incorrectos",
											  JOptionPane.ERROR_MESSAGE);
				
			}
			
		}
		
	}
	
	/* Método que sirve para validar si el cliente está registrado en la "base 
	 * de datos" del banco y si ingresa correctamente sus datos. También asigna 
	 * el índice correspondiente para que las operaciones que realice el 
	 * cliente queden registradas en el espacio donde se encuentran sus datos. */
	public static int validarCliente(String[][] cliente) {
		
		boolean valido = false;
		int indice = 0;
		
		while (!valido) {
			
			indice = 0;
			String rut = JOptionPane.showInputDialog(null, "Ingrese RUT:", 
													"Ingrese datos de usuario", 
											 		JOptionPane.QUESTION_MESSAGE);
			//Preparación del RUT
			rut = rut.toUpperCase();
			rut = rut.replace(".", "");
			rut = rut.replace("-", "");
			
			String clave = JOptionPane.showInputDialog(null, "Ingrese clave:", 
													"Ingrese datos de usuario", 
											 		JOptionPane.QUESTION_MESSAGE);
			
			//Preparación de la clave si es la clave inicial (el RUT)
			for (int i = 0; i < cliente.length; i++) {
				
				if (rut.equals(cliente[i][2]) && cliente[i][2].equals(cliente[i][5])) {
					
	    			clave = clave.toUpperCase();
	    			clave = clave.replace(".", "");
	    			clave = clave.replace("-", "");
					break;
	    			
				}
				
			}
			
			/* Comprobación de que los datos ingresados coincidan con los
			 * datos de un cliente*/
			for (int i = 0; i < cliente.length; i++) {
				
				if (!(cliente[i][2].equals("")) && rut.equals(cliente[i][2])
											 && clave.equals(cliente[i][5])) {
					
					JOptionPane.showMessageDialog(null, "Usuario validado. " 
												  + "Bienvenido/a, " + cliente[i][3]
												  + ".", "Bienvenido/a",
												  JOptionPane.INFORMATION_MESSAGE);
					valido = true;
					indice = i;
					break;
				
				}
				
			}
			
			if (!valido) {
				
				JOptionPane.showMessageDialog(null, "Usuario o clave incorrectos. "
						  + "Intente de nuevo.", "Datos " 
						  + "incorrectos",
							  JOptionPane.ERROR_MESSAGE);
				
			}
			
		}
		
		return indice;
		
	}
	
	/* Método que "inicializa" los tres arreglos involucrados en el programa.
	 * Lo que hace es rellenar los arreglos con valores por defecto 
	 * ("" para el caso de los String y 0 para el caso del int) */
	public static void inicializar(String[][] cliente, String[][] movimiento, 
								   int[][] cuenta) {
		
		for (int i = 0; i < movimiento.length; i++) {

			for (int j = 0; j < movimiento[0].length; j++) {

				movimiento[i][j] = "";

			}

		}

		for (int i = 0; i < cliente.length; i++) {

			for (int j = 0; j < cliente[0].length; j++) {

				cliente[i][j] = "";

			}

		}
		
		for (int i = 0; i < cuenta.length; i++) {

			for (int j = 0; j < cuenta[0].length; j++) {

				cuenta[i][j] = 0;

			}

		}

	}
	
	/* Método que genera números aleatoriamente dentro de un rango.
	 * Este método se utiliza para generar aleatoriamente los números 
	 * de cuenta nuevos.*/
	public static int generarNumeroAleatorio(int minimo, int maximo){
        
		int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) 
													+ (minimo));
    	return num;
    	
	}
	
}
