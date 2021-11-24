package es.pildoras.conexionHibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ImprimeCantidadesStock {

	public static void imprimirCantidades() {
		// TODO Auto-generated method stub

		SessionFactory miFactory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Productos.class).buildSessionFactory();
		
		Session miSesion = miFactory.openSession();
		
		try {
			
			miSesion.beginTransaction();
			
			//consulta de clientes
			
			List<Productos> listaProductos=miSesion.createQuery("FROM Productos").getResultList();
			
			Map<String, Integer> map=new HashMap<String, Integer>();
			
			for (int i=0;i<listaProductos.size();i++) {
				if (!map.containsKey(listaProductos.get(i).getClase())){
					map.put(listaProductos.get(i).getClase(), 1);
				}else {
					map.put(listaProductos.get(i).getClase(), map.get(listaProductos.get(i).getClase())+1);
				}
			}
			
		
			

			miSesion.getTransaction().commit();
			
			System.out.println(map);
			
			miSesion.close();
			
		} finally {
			miFactory.close();
		}
	
	}

}
