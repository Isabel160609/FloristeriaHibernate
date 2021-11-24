package es.pildoras.conexionHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class crearTicket {

	public static void CrearTicket(ArrayList<Integer> listaId) {

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Ticket.class).addAnnotatedClass(Productos.class)
				.buildSessionFactory();

		Session miSesion = miFactory.openSession();

		try {
			double precioTotal = 0;

			miSesion.beginTransaction();

		List<Productos> listaProductos = miSesion.createQuery("FROM Productos").getResultList();

			for (int i = 0; i < listaId.size(); i++) {
				for (int x = 0; x < listaId.size(); x++) {
					if (listaId.get(i)==listaProductos.get(x).getId()) {
						precioTotal+=listaProductos.get(x).getPrecio();
						
					}
				}
			}

			Ticket ticket1 = new Ticket(precioTotal);
			
		
			
			miSesion.getTransaction().commit();
			
			
		
			miSesion.beginTransaction();

			miSesion.save(ticket1);
			
			for (int i = 0; i < listaId.size(); i++) {
				for (int x = 0; x < listaId.size(); x++) {
					if (listaId.get(i)==listaProductos.get(x).getId()) {
						ActualizaProductos.modificarProducto(listaProductos.get(x).getId(),5, String.valueOf(ticket1.getId()));
						System.out.println(ticket1.getId());
					}
				}
			}

			

			miSesion.save(ticket1);
			
			miSesion.getTransaction().commit();

			System.out.println("registro insertado con exito");

			// lectura de registro

			System.out.println("Lectura de registro con id: " + ticket1.getId());

			// miSesion.beginTransaction();
			Ticket productoInsertado = miSesion.get(Ticket.class, ticket1.getId());

			System.out.println("registro " + productoInsertado);

			// miSesion.getTransaction().commit();

			System.out.println("terminado");

			miSesion.close();

		} finally {
			miSesion.close();
			miFactory.close();
		}
	}
}
	
