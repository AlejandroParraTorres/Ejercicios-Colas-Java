package Ejercicio2;

public class Clientes extends Thread {
	private Peluqueria p;
	public Clientes(Peluqueria p) {
		this.p=p;
	}
	
	
	public void run() {
		int numeroClientes;
		for(int i=0;i<48;i++) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				System.out.println(e.getStackTrace());
			}
			System.out.println("Han pasado " + (i+1) + " x10minutos");
			numeroClientes=(int)(Math.random()*4);
			if(numeroClientes>0 && Peluqueria.getClientesEsperando()<3) {
				p.entranClientes(numeroClientes);
			}
			
		}
		
		p.setAbierto(false);
		if(Peluqueria.getClientesEsperando()>0) {
			System.out.println();
			System.out.println("AVISO,la peluqueria va a cerrar");
			System.out.println("Lo sentimos, los " + Peluqueria.getClientesEsperando() + " clientes que están esperando se marchan");
		}
		System.out.println("INFORME DEL DÍA: se han atendido a un total de " + Peluqueria.getClientesAtendidosTotales() + " clientes");
		System.out.println("SE CIERRA LA PELUQUERÍA");
		System.out.println("-----------FIN DEL PROGRAMA-----------");
	}

}
