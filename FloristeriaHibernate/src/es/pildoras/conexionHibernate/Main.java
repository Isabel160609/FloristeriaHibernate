package es.pildoras.conexionHibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


	public static  void main(String[] args) {
		
		
		
		boolean sortir = false;

		do {
			switch (menu()) {
			case 1:
				String clase=Teclado.leerString("de que clase es el producto?");
				String nombre=Teclado.leerString("Que nombre tiene  el producto?");
				double precio=Teclado.leerDouble("que precio tiene el producto?");
				String otro=Teclado.leerString("para arbol insertar altura, para flor insertar color , para decoracion insertar madera o plastico?");
				GuardaProducto.CrearProducto(clase, nombre, precio, otro);;
				break;
			case 2:
				int id=Teclado.leerInt("que id quieres eliminar");
				EliminarProductos.eliminarProducto(id);
				break;
			case 3:
				ConsultaProductos.imprimirStock();
				break;
			case 4:
				int idAmodificar=Teclado.leerInt("que id quieres modificar");
				int campoModifica=Teclado.leerInt("Que campo quieres modificar introduce 1 para clase, 2 para nombre, 3 para precio y 4 para otro");
				
				 String datoAmodificar=Teclado.leerString("que dato quieres introducir");
				
				ActualizaProductos.modificarProducto(idAmodificar, campoModifica, datoAmodificar);
				break;
			case 5:
				ImprimeCantidadesStock.imprimirCantidades();
				break;
			case 6:
				ArrayList<Integer>productosVendidos=new ArrayList<Integer>();
				int id2=-1;
				while(id2!=0){
					
						id2=Teclado.leerInt("cual es el id del producto vendido?");
						if (id2!=0) {
							productosVendidos.add(id2);
						}
				}
				crearTicket.CrearTicket(productosVendidos);
//				int ticketId=Teclado.leerInt("dame id del ticket");
//				crearTicket.relacionarProductos(productosVendidos, ticketId);
				break;
			case 7:
				ConsultaTickets.imprimirTickets();
				break;
			case 8:
				int id3=Teclado.leerInt("cual es el id del ticket a eliminar?");
				EliminarTicket.EliminarTicket(id3);
				break;
			case 9:
				ConsultaTickets.ventasTotales();
				break;
			case 0:
				System.out.println("Gràcies per utilitzar l'aplicació");
				sortir = true;
				break;

			}
		} while (!sortir);
	}

	public static byte menu() {
		Scanner entrada = new Scanner(System.in);
		byte opcio;
		final byte MINIMO = 0;
		final byte MAXIMO = 9;

		do {
			System.out.println("\nMENú PRINCIPAL");
			System.out.println("1. crear producto y a�adirlo al stock 1.");
			System.out.println("2. eliminarProducto 2.");
			System.out.println("3. imprimir stock 3.");
			System.out.println("4. modificar un producto 4.");
			System.out.println("5. imprimir cantidades stock 5.");
			System.out.println("6. crear ticket y mostrarlo 6.");
			System.out.println("7. mostrar todos los tickets 7.");
			System.out.println("8. eliminar ticket 8.");
			System.out.println("9. Ventas totales9.");

			System.out.println("0. Sortir de l'aplicació.\n");
			opcio = entrada.nextByte();
			if (opcio < MINIMO || opcio > MAXIMO) {
				System.out.println("Escull una opció vàlida");
			}
		} while (opcio < MINIMO || opcio > MAXIMO);
		return opcio;
	}

	
		
	
}
