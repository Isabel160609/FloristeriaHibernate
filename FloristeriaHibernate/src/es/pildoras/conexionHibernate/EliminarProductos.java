package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminarProductos {

	public static void eliminarProducto(int idProducto) {
		// TODO Auto-generated method stub

		SessionFactory miFactory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Productos.class).buildSessionFactory();
		
		Session miSesion = miFactory.openSession();
		
	try {
			
			miSesion.beginTransaction();
			
			Productos elProducto=miSesion.get(Productos.class, idProducto);
			
			if (elProducto!=null) {
				
				System.out.println("Voy a eliminar el producto con id: " +elProducto.getId());
				
				miSesion.delete(elProducto);
			}
			
			miSesion.getTransaction().commit();
			
			if (elProducto!=null)System.out.println("registro eliminado con exito");
			else System.out.println("El producto no existe");
		
			miSesion.close();
			
		} finally {
			
			miFactory.close();
		}
	
	}

}
