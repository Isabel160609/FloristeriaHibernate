package es.pildoras.conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ActualizaProductos {

	public static <T> void modificarProducto(int Productoid,int campoModifica, String datoAmodificar) {
		// TODO Auto-generated method stub

		SessionFactory miFactory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Productos.class).buildSessionFactory();
		
		Session miSesion = miFactory.openSession();
		
		try {
			
			
			
			miSesion.beginTransaction();
			
			Productos miProducto= miSesion.get(Productos.class, Productoid);
			switch (campoModifica) {
			case 1: 
				miProducto.setClase(datoAmodificar);
				break;
			case 2:
				miProducto.setNombre(datoAmodificar);
				break;
			case 3:
				 miProducto.setPrecio(Double.parseDouble(datoAmodificar));
				break;
			case 4:
				 miProducto.setOtro(datoAmodificar);
				break;
			case 5:
				 miProducto.setTicket_id(Integer.parseInt(datoAmodificar));
				break;
			}
			
//			if(campoModifica.equalsIgnoreCase("clase")) miProducto.setClase((String)datoAmodificar);
//			else if(campoModifica.equalsIgnoreCase("nombre")) miProducto.setNombre((String)datoAmodificar);
//			else if(campoModifica.equalsIgnoreCase("precio")) miProducto.setPrecio((double)datoAmodificar);
//			else if(campoModifica.equalsIgnoreCase("otro")) miProducto.setOtro((String)datoAmodificar);
			
			miSesion.getTransaction().commit();
			
			System.out.println("registro 1 modificado con exito");
			

			miSesion.close();
			
		} finally {
			miFactory.close();
		}
	
	}

}
