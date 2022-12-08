package Ejercicio2;
public class Peluquero extends Thread {
	
	private Peluqueria p;
	private String nombre;
	
	public Peluquero(Peluqueria p,String nombre) {
		this.p=p;
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void run() {
		try {
			while(p.isAbierto()) {
				p.atenderClientes(this.nombre);
				Thread.sleep((int)(Math.random()*(3000-1000+1)+1000));
			}
			
		}catch(InterruptedException e) {
			System.out.println(e.getStackTrace());
		}
		
	}

}
