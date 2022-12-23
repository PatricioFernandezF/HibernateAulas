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
		Aula aula= new Aula();
		aula.setTituloAula("Aula Taller Primera Planta");
		aula.setMetros(30);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(aula);
		session.getTransaction().commit();
		session.close();

	}

	public void obtener() {

	}

	public void update() {

	}

	public void delete() {

	}

}