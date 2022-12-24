package Managers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Entidades.Aula;
import Entidades.Ordenador;

public class OrdenadorManager {



	public void create() {
		Ordenador ordenador = new Ordenador();
		
		
		ordenador.setMarca("Acer");
		ordenador.setAnno(2005);
		ordenador.setTipo("Sobremesa");
		
		Ordenador ordenador2=new Ordenador("Lenovo",2022,"Sobremesa");
		Ordenador ordenador3=new Ordenador("HP",2020,"Portatil");
		
		
		
		Session session = ManagerPrincipal.sessionFactory.openSession();
		session.beginTransaction();
		session.save(ordenador);
		session.save(ordenador2);
		session.save(ordenador3);
		session.getTransaction().commit();
		session.close();
		
		setAula(1,1);
		setAula(2,1);
		setAula(3,1);

	}
	
	public void setAula(long idOr,long idAul) {
		Ordenador ordenador = obtener(idOr);
		
		AulaManager manageraula = new AulaManager();
		Aula aula=manageraula.obtener(1);
		
		ordenador.setAula(aula);

		Session session = ManagerPrincipal.sessionFactory.openSession();
		session.beginTransaction();
		session.update(ordenador);
		session.getTransaction().commit();
		session.close();
	}
	
	
	public Ordenador obtener(long id) {
		Session session = ManagerPrincipal.sessionFactory.openSession();
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

		Session session = ManagerPrincipal.sessionFactory.openSession();
		session.beginTransaction();
		session.update(ordenador);
		session.getTransaction().commit();
		session.close();

	}

	public void delete(long id) {
		Ordenador ordenador = obtener(id);
		
		Session session = ManagerPrincipal.sessionFactory.openSession();
		session.beginTransaction();
		session.delete(ordenador);
		session.getTransaction().commit();
		session.close();
	}

}