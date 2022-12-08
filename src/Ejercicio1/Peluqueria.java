package Ejercicio1;

public class Peluqueria {
	
	private static int clientesEsperando=0;
	private static int clientesTotales=0;
	private static int clientesAtendidosTotales=0;
	private boolean abierto=false;

	public Peluqueria() {
		abierto=true;
		System.out.println("SE ABRE LA PELUQUERIA");
	}
	
	public static int getClientesEsperando() {
		return clientesEsperando;
	}



	public static void setClientesEsperando(int clientesEsperando) {
		Peluqueria.clientesEsperando = clientesEsperando;
	}






	public static int getClientesTotales() {
		return clientesTotales;
	}






	public static void setClientesTotales(int clientesTotales) {
		Peluqueria.clientesTotales = clientesTotales;
	}






	public static int getClientesAtendidosTotales() {
		return clientesAtendidosTotales;
	}






	public static void setClientesAtendidosTotales(int clientesAtendidosTotales) {
		Peluqueria.clientesAtendidosTotales = clientesAtendidosTotales;
	}






	public boolean isAbierto() {
		return abierto;
	}

	public void setAbierto(boolean abierto) {
		this.abierto = abierto;
	}




	public synchronized void atenderClientes(String nombre) {
			try {
				if(clientesEsperando>0) {
					System.out.println(nombre + " ha llamado a un cliente a cortarse el pelo");
					clientesEsperando--;
					clientesAtendidosTotales++;
					System.out.println("Hay " + clientesEsperando + " clientes esperando");
					notifyAll();
				}else if(clientesEsperando==0) {
					System.out.println(nombre + " esta esperando clientes");
					wait();
					notifyAll();
				}
				
			}catch(InterruptedException e) {
				System.out.println(e.getStackTrace());
			}
		
			
	}
	
	public synchronized void entranClientes(int numeroClientes) {
		
			try {
				System.out.println("Han entrado " + numeroClientes + " clientes");
				if(clientesEsperando==3) {
					wait();
					notifyAll();
				}else if(clientesEsperando+numeroClientes<=3) {
					clientesEsperando+=numeroClientes;
					System.out.println("Se han sentado " + numeroClientes + " clientes");
					clientesTotales+=numeroClientes;
					System.out.println("Se han sentado " + clientesTotales + " en total");
					notifyAll();
				}else if(clientesEsperando+numeroClientes>3) {
					for(int i=0;i<numeroClientes;i++) {
						while(clientesEsperando<3) {
							clientesEsperando++;
							clientesTotales++;
						}
					}
					notifyAll();
				}
				
				System.out.println("Ahora hay " + clientesEsperando + " clientes esperando");
				
			}catch(InterruptedException e) {
				System.out.println(e.getStackTrace());
			}
			
			
		
		
	}
	
	
	

}
