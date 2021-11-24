package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GuardaProducto {

	public static void CrearProducto(String clase, String nombre, double precio, String otro) {

		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Productos.class)
				.buildSessionFactory();

		Session miSesion = miFactory.openSession();

		try {

			Productos producto1 = new Productos(clase, nombre, precio, otro);

			miSesion.beginTransaction();

			miSesion.save(producto1);

			miSesion.getTransaction().commit();

			System.out.println("registro insertado con exito");

			// lectura de registro

			System.out.println("Lectura de registro con id: " + producto1.getId());

			// miSesion.beginTransaction();
			Productos productoInsertado = miSesion.get(Productos.class, producto1.getId());

			System.out.println("registro " + productoInsertado);

			// miSesion.getTransaction().commit();

			System.out.println("terminado");

			miSesion.close();

		} finally {

			miFactory.close();
		}
	}

}
