package es.pildoras.conexionHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;

public class ConsultaProductos {

	public static void imprimirStock() {
		// TODO Auto-generated method stub
		

		SessionFactory miFactory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Productos.class).buildSessionFactory();
		
		Session miSesion = miFactory.openSession();
		
		try {
			//comenza sesion
			
			miSesion.beginTransaction();
			
			//consulta de clientes
			
			List<Productos> listaProductos=miSesion.createQuery("FROM Productos").getResultList();
			
			//mostrar los clientes
			
			listaProductos.forEach(x->System.out.println(x));
			
			
			//comit
			miSesion.getTransaction().commit();
			
			//cerrar sesion
			
			miSesion.close();
			
		} finally {
			miFactory.close();
		}
	}

	public static List<Productos> ListarProductosporIdTicket(int idTicket) {
		// TODO Auto-generated method stub
		

		SessionFactory miFactory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Productos.class).buildSessionFactory();
		
		Session miSesion = miFactory.openSession();
		
		try {
			//comenza sesion
			
			miSesion.beginTransaction();
			
			//consulta de clientes
			
			List<Productos> listaProductos=miSesion.createQuery("FROM Productos Where ticket_id= "+idTicket).getResultList();
			
			
			
			//comit
			miSesion.getTransaction().commit();
			
			//cerrar sesion
			
			miSesion.close();
			
			return listaProductos;
		} finally {
			miFactory.close();
		}
	}

}
