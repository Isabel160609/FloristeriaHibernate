package es.pildoras.conexionHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminarTicket {

	public static void EliminarTicket(int idTicket) {

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Ticket.class).addAnnotatedClass(Productos.class)
				.buildSessionFactory();

		Session miSesion = miFactory.openSession();

		try {
			
			miSesion.beginTransaction();
			
			Ticket elTicket=miSesion.get(Ticket.class, idTicket);
			
			if (elTicket!=null) {
				
				System.out.println("Voy a eliminar el producto con id: " +elTicket.getId());
				
				miSesion.delete(elTicket);
			}
			
			miSesion.getTransaction().commit();
			
			if (elTicket!=null)System.out.println("registro eliminado con exito");
			else System.out.println("El Ticket no existe");
		
			//miSesion.close();

			
			List<Productos> listaProductos = ConsultaProductos.ListarProductosporIdTicket( idTicket);
			
			miSesion.beginTransaction();
			
			
			
			//List<Productos> listaProductos=miSesion.createQuery("FROM Productos").getResultList();
			
		
			
			
			
			
			
			miSesion.getTransaction().commit();
		
			miSesion.beginTransaction();

			
			
			for (int i = 0; i < listaProductos.size(); i++) {
				//for (int x = 0; x < listaId.size(); x++) {
					//if (listaId.get(i)==listaProductos.get(x).getId()) {
						ActualizaProductos.modificarProducto(listaProductos.get(i).getId(),5,"0");
					//}
				//}
			}


			
			miSesion.getTransaction().commit();

			System.out.println("registro insertado con exito");

			

			// miSesion.getTransaction().commit();

			System.out.println("terminado");

			miSesion.close();

		} finally {
			//miSesion.close();
			miFactory.close();
		}
	}
}
	
