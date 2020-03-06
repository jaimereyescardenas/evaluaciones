package Cajero;

import javax.swing.JOptionPane;

public class Cliente {
	
	/* M�todo que crea los cinco primeros clientes (los que tiene por defecto
	 * el sistema al inicio del programa)*/
	public static void crearClientesIniciales(String[][] cliente, int[][] cuenta) {
		
		//Cliente 0
		cliente[0][0] = "555637298";
		cliente[0][1] = "Corriente";
		cliente[0][2] = "145637295";
		cliente[0][3] = "Pablo";
		cliente[0][4] = "Sanhueza";
		cliente[0][5] = "hola123";
		
		//Cliente 1
		cliente[1][0] = "777328934";
		cliente[1][1] = "Vista";
		cliente[1][2] = "134871458";
		cliente[1][3] = "Catalina";
		cliente[1][4] = "P�rez";
		cliente[1][5] = "asd9837";
				
		//Cliente 2
		cliente[2][0] = "555484012";
		cliente[2][1] = "Corriente";
		cliente[2][2] = "186573552";
		cliente[2][3] = "Ingrid";
		cliente[2][4] = "Espinoza";
		cliente[2][5] = "qB47aD32";
		
		//Cliente 3
		cliente[3][0] = "666834637";
		cliente[3][1] = "Ahorro";
		cliente[3][2] = "225673810";
		cliente[3][3] = "Ignacio";
		cliente[3][4] = "Beltr�n";
		cliente[3][5] = "1111111113";
		
		//Cliente 4
		cliente[4][0] = "777347201";
		cliente[4][1] = "Vista";
		cliente[4][2] = "183749986";
		cliente[4][3] = "Joaqu�n";
		cliente[4][4] = "Pe�anieto";
		cliente[4][5] = "aloalo321";
		
		//Copiar los n�meros de cuenta al arreglo de cuentas
		for (int i = 0 ; i < 5; i++) {
			
			copiarNumeroCuenta(cliente, cuenta, i);
			
		}
		
	}
	
	/* M�todo que crea una cuenta nueva en el sistema, cuyo n�mero depender� 
	 * del tipo de cuenta que seleccione el usuario. */
	public static void crearCuenta(String[][] cliente, int[][] cuenta) {
		
		int ind_cuenta = 0;
		int no_disponible = 0;
		//Verificaci�n y asignaci�n de un espacio libre entre las cuentas
		for (int i = 0; i < cliente.length; i++) {
			
			if (cliente[i][0].equals("")) {
				
				ind_cuenta = i;
				break;
				
			} else {
				
				no_disponible++;
				
			}
			
		}
		
		//Si no hay espacio disponible, se mostrar� un mensaje
		if (no_disponible == cliente.length) { 
			
			JOptionPane.showMessageDialog(null, "Se ha alcanzado el espacio "
												+ "m�ximo de cuentas. \n"
												+ "No se pueden seguir "
												+ "creando m�s cuentas.");
			
		//En caso contrario, se continuar� con el registro de cuenta
		} else {
			
			int tipo = 0;
			String[] tipo_cuenta = {"Corriente", "Ahorro", "Vista"};
			boolean valido = false;
			
			do {
				
				tipo = Integer.parseInt(JOptionPane.showInputDialog(
												 "Seleccione tipo de cuenta: \n"
												 + "1.- Cta. Corriente \n" 
												 + "2.- Cta. Ahorro \n"
												 + "3.- Cta. Vista"));
										
				if (tipo > 0 && tipo < 4) {
					
					cliente[ind_cuenta][1] = tipo_cuenta[tipo - 1];
					valido = true;
					
				} else {
					
					JOptionPane.showMessageDialog(null, "Usted no seleccion� una "
													 + "opci�n v�lida. \nPor favor,"
													 + " intente nuevamente.");
					
				}
				
			} while (!valido);
			
			//Se utiliza el m�todo para generar n�meros de cuenta aleatorios
			String numCuenta = crearNumeroCuenta(cliente, tipo, ind_cuenta);
			
			JOptionPane.showMessageDialog(null, "N�mero de cuenta " + numCuenta
												+ " creado con �xito.");
			
		}
		
	}
	
	/* M�todo que agrega informaci�n relativa al cliente (RUT, nombre y clave)
	 * a una cuenta previamente creada y sin un cliente asignado.*/
	public static void crearCliente(String[][] cliente){
		
		int cta = 0;
		boolean valido = false;
		//Verificaci�n de que la cuenta est� disponible
		do {
			
			cta = Integer.parseInt(JOptionPane.showInputDialog(
									"Seleccione una cuenta de las disponibles: \n"
									+ Cuenta.mostrarCuentasVacantes(cliente)));
			
			if (cliente[cta][0].equals("") || !(cliente[cta][2].equals(""))){
				
				JOptionPane.showMessageDialog(null, "La cuenta ingresada no "
													+ "est� disponible. "
													+ "Por favor, intente de nuevo.");
				
			} else {
				
				valido = true;
				
			}
			
		} while (!valido);
		
	    String rut = "";
	   //Verificaci�n de que el RUT ingresado sea uno v�lido
        do {
    	   
    	    rut=JOptionPane.showInputDialog("Ingrese RUT");
           
            if(validarRut(rut)) {
            	
    			rut = rut.toUpperCase();
    			rut = rut.replace(".", "");
    			rut = rut.replace("-", "");
         	    cliente[cta][2] = rut;
        	   
            } else {
        	   
        	    JOptionPane.showMessageDialog(null, "Rut inv�lido, por favor"
        	    									+ " intente nuevamente.");
        	   
            }
    	   
        } while (!(validarRut(rut)));
       //Asignaci�n de los dem�s datos (nombre, apellido y clave inicial)
        cliente[cta][3] = JOptionPane.showInputDialog("Ingrese el nombre: ");
        cliente[cta][4] = JOptionPane.showInputDialog("Ingrese el apellido: ");
       //La clave inicial es igual al RUT del cliente
        cliente[cta][5] = cliente[cta][2];
        
        JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.");
	}
	
	/* M�todo que muestra los datos de un cliente en particular 
	 * (n�mero de cuenta, tipo de cuenta, RUT, nombre y apellido). 
	 * Por motivos de seguridad, este m�todo no muestra las claves. */
	public static void mostrarCliente( String[][] cliente, int ind_cliente ) {
		
		if (cliente[ind_cliente][2].equals("")) {
			
			JOptionPane.showMessageDialog(null, "El �ndice seleccionado "
											+ "no contiene datos de cliente.");
			
		} else {
			
			JOptionPane.showMessageDialog(null, "El n�mero de cuenta del cliente es: " 
												+ cliente[ind_cliente][0] + "\n"
												+ "El tipo de cuenta es:  " 
												+ cliente[ind_cliente][1] + "\n"
												+ "El rut del cliente es:  "
												+ cliente[ind_cliente][2] + "\n"
												+ "El nombre del cliente es:  " 
												+ cliente[ind_cliente][3] + " "
												+ cliente[ind_cliente][4]);
			
		}
		
	}
	
	/* M�todo que permite el cambio de clave para un cliente en particular.
	 * Tambi�n registra el cambio de clave como un movimiento de cuenta. */
	public static void cambiarClave(String[][] cliente, String[][] movimiento,
									int ind_cliente) {
		
		boolean valido1 = false;
		boolean valido2 = false;
		
		while(!valido1) {
		
		    
			String clave = JOptionPane.showInputDialog(null, "Ingrese su clave" 
															 + " actual:");
			
			//Preparaci�n de la clave si es la clave inicial (el RUT)
			if (cliente[ind_cliente][2].equals(cliente[ind_cliente][5])) {
				
    			clave = clave.toUpperCase();
    			clave = clave.replace(".", "");
    			clave = clave.replace("-", "");
				break;
    			
			}
			
			if(clave.equals(cliente[ind_cliente][5])) {
				
				while(!valido2) {
					
					String nueva_clave = JOptionPane.showInputDialog(null, 
										"Ingrese su nueva clave secreta:");
					String nueva_clave2 = JOptionPane.showInputDialog(null, 
										  "Ingrese nuevamente"
										  + " su nueva clave secreta:");	
					
					if(nueva_clave.equals(nueva_clave2)) {
						
						cliente[ind_cliente][5] = nueva_clave;
						JOptionPane.showMessageDialog(null, "El cambio de clave"
												+ " se ha realizado con �xito");
						Cuenta.ingresarMovimiento(movimiento, ind_cliente, 
												  "Cambio de clave", 0);
						valido2 = true;
						
					} else {
						
						JOptionPane.showMessageDialog(null, "Error. Las dos " 
									+ "claves no coinciden. Intente de nuevo");
						
					}
					
				}
				
				valido1 = true;
				
			} else { 
				
				JOptionPane.showMessageDialog(null, "Error. La clave ingresada" 
										 + " es incorrecta. Intente de nuevo");
				
			}
			
		}
		
	}
	
	/* M�todo que permite verificar si un RUT es v�lido. */
	public static boolean validarRut(String rut) {

		boolean validacion = false;
		
		try {
			
			rut = rut.toUpperCase();
			rut = rut.replace(".", "");
			rut = rut.replace("-", "");
			int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

			char dv = rut.charAt(rut.length() - 1);

			int m = 0, s = 1;
			
			for (; rutAux != 0; rutAux /= 10) {
				
				s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
				
			}
			
			if (dv == (char) (s != 0 ? s + 47 : 75)) {
				
				validacion = true;
				
			}

		} catch (java.lang.NumberFormatException e) {
			
		} catch (Exception e) {
			
		}
		
		return validacion;
		
	}
    
	/* M�todo que genera un n�mero de cuenta aleatorio (dependiendo del tipo
	 * de cuenta) y lo entrega para su posterior uso. */
    public static String crearNumeroCuenta(String[][] cliente, int tipo, 
    									   int ind_cuenta) {
		
    	String numCuenta = "";
    	//Si es cuenta corriente, comenzar� con 555
		if (tipo == 1) {
			
			boolean valido = false;
			
			while (!valido) {
				
				valido = true;
				numCuenta = "555" + Principal.generarNumeroAleatorio(111111,
																	999999);
				
				for (int i = 0; i < cliente.length; i++) {
					
					if (numCuenta.equals(cliente[i][0])) {
						
						valido = false;
						
					}
					
				}
				
			}
			
			cliente[ind_cuenta][0] = numCuenta;
			
		}
		//Si es cuenta de ahorro, comenzar� con 666
		if (tipo == 2) {
			
			boolean valido = false;
			
			while (!valido) {
				
				valido = true;
				numCuenta = "666" + Principal.generarNumeroAleatorio(111111,
																	999999);
				
				for (int i = 0; i < cliente.length; i++) {
					
					if (numCuenta.equals(cliente[i][0])) {
						
						valido = false;
						
					}
					
				}
				
			}
			
			cliente[ind_cuenta][0] = numCuenta;
			
		}
		//Si es cuenta vista, comenzar� con 777
		if (tipo == 3) {
			
			boolean valido = false;
			
			while (!valido) {
				
				valido = true;
				numCuenta = "777" + Principal.generarNumeroAleatorio(111111,
							 										999999);
					
				for (int i = 0; i < cliente.length; i++) {
					
					if (numCuenta.equals(cliente[i][0])) {
						
						valido = false;
						
					}
					
				}
				
			}
			
			cliente[ind_cuenta][0] = numCuenta;
			
		}
		
		return numCuenta;
		
	}
    
    /* M�todo que copia los datos del n�mero de cuenta y los traslada desde el 
     * arreglo de clientes al arreglo de cuentas, transformando los datos 
     * de String a int*/
    public static void copiarNumeroCuenta(String[][] cliente, int[][] cuenta, 
    									  int ind_cliente) {
		
		cuenta[ind_cliente][0] = Integer.parseInt(cliente[ind_cliente][0]);
		
	}
    
}
