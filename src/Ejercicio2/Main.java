package Ejercicio2;

public class Main {

	public static void main(String[] args) {
		Peluqueria p= new Peluqueria();
		
		Peluquero peluquero= new Peluquero(p,"Julio");
		Peluquero peluquero2=new Peluquero(p,"Parra");
		Clientes clientes= new Clientes(p);
		
		peluquero.start();
		peluquero2.start();
		clientes.start();

	}

}
