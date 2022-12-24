package Managers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Entidades.Aula;

public class AulaManager {
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
		Aula aula = new Aula();

		aula.setTituloAula("Aula Taller Primera Planta");
		aula.setMetros(30);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(aula);
		session.getTransaction().commit();
		session.close();

	}
	
	
	public Aula obtener(long id) {
		Session session = sessionFactory.openSession();
		Aula aula = session.get(Aula.class, id);
		session.close();
		return aula;
	}
	
	public void informacion(long id) {
		Aula aula = obtener(id);
		System.out.println("Titulo Aula: " + aula.getTituloAula());
		System.out.println("Metros: " + aula.getMetros());
	}


	public void update(long id, String nombre, int metros) {

		Aula aula = obtener(id);

		if (nombre != null)
			aula.setTituloAula(nombre);

		if (metros > -1)
			aula.setMetros(metros);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(aula);
		session.getTransaction().commit();
		session.close();

	}

	public void delete(long id) {
		Aula aula = obtener(id);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(aula);
		session.getTransaction().commit();
		session.close();
	}

}