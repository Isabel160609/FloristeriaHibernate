package es.pildoras.conexionHibernate;

import javax.persistence.*;


@Entity
@Table(name="productes")
public class Productos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_producte")
	private int id;
	
	@Column(name="clase")
	private String clase;
	
	@Column(name="nom")
	private String nombre;
	
	@Column(name="preu")
	private double precio;
	
	@Column(name="otro")
	private String otro;

	@Column(name="ticket_id")
	private int ticket_id;
	
	public Productos() {
		
	}

	

	public Productos(String clase, String nombre, double precio, String otro) {
		this.clase=clase;
		this.nombre = nombre;
		this.precio = precio;
		this.otro = otro;
		this.ticket_id=0;
	}



	public String getClase() {
		return clase;
	}



	public void setClase(String clase) {
		this.clase = clase;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public String getOtro() {
		return otro;
	}



	public void setOtro(String otro) {
		this.otro = otro;
	}



	public int getTicket_id() {
		return ticket_id;
	}



	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}



	@Override
	public String toString() {
		return "Productos [id=" + id + ", clase=" + clase + ", nombre=" + nombre + ", precio=" + precio + ", otro="
				+ otro + ", ticket_id=" + ticket_id + "]";
	}



	


	
	
}
