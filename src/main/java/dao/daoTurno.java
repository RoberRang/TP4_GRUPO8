package dao;

import java.util.List;

import org.hibernate.Session;

import entidad.Turno;

public class daoTurno {

	public void Add(Turno turno) {
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		session.save(turno);
		
		session.getTransaction().commit();
		ch.cerrarConexion();
		
	}
	

	public List<Turno> ReadAll() {
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		List<Turno> list = (List<Turno>)session.createQuery("from Turno").list();
		
		ch.cerrarConexion();
		
		return list;
	}
	

	public void Update(Turno turno) {
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		session.update(turno);
		session.getTransaction().commit();
		
		ch.cerrarConexion();
	}
	

	public void Delete(Turno turno) {
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		session.delete(turno);
		session.getTransaction().commit();
		
		ch.cerrarConexion();
	}
}
