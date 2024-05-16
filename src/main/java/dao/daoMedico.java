package dao;

import java.util.List;

import org.hibernate.Session;

import Idao.IDaoMedico;
import entidad.Medico;

public class daoMedico implements IDaoMedico {
	
	@Override
	public void Add(Medico medico) {
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		session.save(medico);
		
		session.getTransaction().commit();
		ch.cerrarConexion();
		
	}
	
	@Override
	public List<Medico> ReadAll() {
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		List<Medico> list = (List<Medico>)session.createQuery("from Medico").list();
		
		ch.cerrarConexion();
		
		return list;
	}
	
	@Override
	public void Update(Medico medico) {
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		session.update(medico);
		session.getTransaction().commit();
		
		ch.cerrarConexion();
	}
	
	@Override
	public void Delete(Medico medico) {
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		session.delete(medico);
		session.getTransaction().commit();
		
		ch.cerrarConexion();
	}

}
