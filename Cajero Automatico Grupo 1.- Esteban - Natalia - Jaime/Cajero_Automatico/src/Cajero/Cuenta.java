package Cajero;

import javax.swing.JOptionPane;

public class Cuenta {
	
	/* Método que permite abonar dinero a la cuenta de un cliente, y que 
	 * registra el movimiento realizado. */
    public static void abonarDinero(int[][] cuenta, String[][] movimiento, 
    								int ind_cliente) {
      	
    	int abono = 0;
		//Filtro para que el abono sea mayor a cero.
		do {
			
			abono = Integer.parseInt(JOptionPane.showInputDialog(
					"Por favor ingrese la cantidad a abonar"));
			
			if (abono <= 0) {
				
				JOptionPane.showMessageDialog(null, "Debe ingresar una "
													+ "cantidad mayor a cero.");
				
			}
			
			
		} while (abono <= 0);
    	
    	cuenta[ind_cliente][1]=(cuenta[ind_cliente][1]+abono);	    		
    	JOptionPane.showMessageDialog(null,"Abono realizado con éxito. \n"
    										+ "Su nuevo saldo es: "
    										+ cuenta[ind_cliente][1] );
    	ingresarMovimiento(movimiento, ind_cliente, "Abono +", abono);
            
   	}
	
    /* Método que permite retirar dinero desde la cuenta de un cliente siempre 
     * que ésta tenga fondos suficientes, y que registra el movimiento realizado. */
	public static void retirarDinero(int[][] cuenta, String[][] movimiento, 
									 int ind_cliente) {
		
		int retiro = 0;
		//Filtro para que el retiro sea mayor a cero.
		do {
			
			retiro = Integer.parseInt(JOptionPane.showInputDialog(
 					"Por favor ingrese la cantidad a retirar"));
			
			if (retiro <= 0) {
				
				JOptionPane.showMessageDialog(null, "Debe ingresar una "
													+ "cantidad mayor a cero.");
				
			}
			
			
		} while (retiro <= 0);
		//Filtro para que el retiro no exceda los fondos que hay en la cuenta.
		if (retiro <= cuenta[ind_cliente][1]) {
			 
			cuenta[ind_cliente][1] = (cuenta[ind_cliente][1]- retiro);
			JOptionPane.showMessageDialog(null, "Retiro realizado con éxito. \n"
												+ "Su nuevo saldo es: "
												+ cuenta[ind_cliente][1]);
			ingresarMovimiento(movimiento, ind_cliente, "Retiro -", retiro);
		 
        } else {
        	 
        	JOptionPane.showMessageDialog(null,"Fondos insuficientes, su saldo es: "
        										+ cuenta[ind_cliente][1]);
             
        } 
	    
	}
	
	/* Método que permite conocer el saldo de un cliente al momento
	 * de la consulta. */
    public static void consultarSaldo(int[][] cuenta, int ind_cliente) {
    	
    	JOptionPane.showMessageDialog(null,"Su saldo actual es: " 
    										+ cuenta[ind_cliente][1]);
    	   
    }	
	
    /* Método que muestra los últimos movimientos realizados en la cuenta del
     * usuario. Son considerados movimientos: los abonos, los retiros y los 
     * cambios de clave. Lo más reciente se mostrará primero. */
	public static void consultarUltimosMovimientos(String[][] movimiento,
													int ind_cliente) {
		
		int cero_mov = 0;
		
		for (int j = 0; j < movimiento[0].length; j++) {
			
			if (movimiento[ind_cliente][j].equals("")) {
				
				cero_mov++;
				
			}
			
		}
		
		if (cero_mov == movimiento[0].length) {
			
			JOptionPane.showMessageDialog(null, "No hay movimientos que mostrar.");
			
		} else {
			
			String ultimosMov = "";
			
			for (int j = 0; j < movimiento[0].length; j++) {
				
				if (!(movimiento[ind_cliente][j].equals(""))) {
					
					ultimosMov += movimiento[ind_cliente][j] + "\n";
					
				}
				
			}
			
			ultimosMov.substring(0, ultimosMov.length() - 1);
			
			JOptionPane.showMessageDialog(null, "Los últimos movimientos son: \n"
												+ ultimosMov);
			
		}
		
	}
	
	/* Método que entrega las cuentas que han sido creadas pero que no tienen
	 * ningún cliente asignado. */
	public static String mostrarCuentasVacantes(String[][] cliente) {
		
		String cuentas = "";
		
		for (int i = 0; i < cliente.length; i++) {
			
			if (!(cliente[i][0].equals("")) && cliente[i][2].equals("")) {
				
				cuentas += i + ".- " + cliente[i][0] + "\n"; 
				
			}
			
		}
		
		return cuentas;
		
	}
	
	/* Método que permite registrar distintos tipos de movimientos en la 
	 * cuenta del cliente. También ordena los movimientos para que los más 
	 * recientes se encuentren primero y los más antiguos se vayan
	 * eliminando. */
	public static void ingresarMovimiento(String[][] movimiento, int ind_cliente,
										  String tipo_mov, int monto) {
		
		String mov = "";
		
		if (monto == 0) {
			
			mov = tipo_mov;
			
		} else {
			
			mov = tipo_mov + monto;
			
		}
		
		for (int j = movimiento[0].length - 1; j > 0; j-- ) {
			
			String aux = movimiento[ind_cliente][j];
			movimiento[ind_cliente][j] = movimiento[ind_cliente][j - 1];
			movimiento[ind_cliente][j - 1] = aux;
			
		}
		
		movimiento[ind_cliente][0] = mov;
		
	}
	
}
