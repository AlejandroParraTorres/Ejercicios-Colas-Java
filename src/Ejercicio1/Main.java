package Ejercicio1;

public class Main {

	public static void main(String[] args) {
		Peluqueria p= new Peluqueria();
		
		Peluquero peluquero= new Peluquero(p,"Julio");
		Clientes clientes= new Clientes(p);
		
		peluquero.start();
		clientes.start();

	}

}
