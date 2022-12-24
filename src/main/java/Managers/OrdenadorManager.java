package Managers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Entidades.Ordenador;

public class OrdenadorManager {
	protected SessionFactory sessionFactory;

	public void setup() {

		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);

		}
	}

	public void exit() {
		// code to close Hibernate Session factory
	}

	public void create() {
		Ordenador ordenador = new Ordenador();

		ordenador.setMarca("Acer");
		ordenador.setAnno(2005);
		ordenador.setTipo("Sobremesa");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(ordenador);
		session.getTransaction().commit();
		session.close();

	}
	
	
	public Ordenador obtener(long id) {
		Session session = sessionFactory.openSession();
		Ordenador ordenador = session.get(Ordenador.class, id);
		session.close();
		return ordenador;
	}
	
	public void informacion(long id) {
		Ordenador ordenador = obtener(id);
		System.out.println("Marca: " + ordenador.getMarca());
		System.out.println("Tipo: " + ordenador.getTipo());
		System.out.println("Año: " + ordenador.getAnno());
	}


	public void update(long id, String marca,String tipo, int anno) {

		Ordenador ordenador = obtener(id);

		if (marca != null)
			ordenador.setMarca(marca);
		
		if (tipo != null)
			ordenador.setMarca(tipo);

		if (anno > -1)
			ordenador.setAnno(anno);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(ordenador);
		session.getTransaction().commit();
		session.close();

	}

	public void delete(long id) {
		Ordenador ordenador = obtener(id);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(ordenador);
		session.getTransaction().commit();
		session.close();
	}

}