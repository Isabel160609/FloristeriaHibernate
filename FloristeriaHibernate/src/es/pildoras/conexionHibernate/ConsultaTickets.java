package es.pildoras.conexionHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;

public class ConsultaTickets {

	public static void imprimirTickets() {
		// TODO Auto-generated method stub

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Ticket.class)
				.buildSessionFactory();

		Session miSesion = miFactory.openSession();

		try {
			// comenza sesion

			miSesion.beginTransaction();

			// consulta de clientes

			List<Ticket> listaTicket = miSesion.createQuery("FROM Ticket").getResultList();

			// mostrar los clientes

			listaTicket.forEach(
					x -> System.out.println(x + " " + ConsultaProductos.ListarProductosporIdTicket(x.getId())));
			// for (int i=0;i<)

			// comit
			miSesion.getTransaction().commit();

			// cerrar sesion

			miSesion.close();

		} finally {
			miFactory.close();
		}
	}

	public static void ventasTotales() {
			// TODO Auto-generated method stub
			

			SessionFactory miFactory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Ticket.class).buildSessionFactory();
			
			Session miSesion = miFactory.openSession();
			
			try {
				//comenza sesion
				
				miSesion.beginTransaction();
				
				//consulta de clientes
				
				List<Ticket> listaTicket=miSesion.createQuery("FROM Ticket").getResultList();
				
				//mostrar los clientes
				
				double VentasTotales=0;
				
				for (int i=0;i<listaTicket.size();i++) {
					VentasTotales+=listaTicket.get(i).getPrecioTotal();
				}
				
				System.out.println("el precio total de venrtas es: "+  VentasTotales);
				//comit
				miSesion.getTransaction().commit();
				
				//cerrar sesion
	
			
				miSesion.close();
				
			} finally {
				miFactory.close();
			}
	
	}
}
