package dao;

import java.util.List;

import org.hibernate.Session;

import Idao.IDaoEspecialidad;
import entidad.Especialidad;
import entidad.Usuario;

public class daoEspecialidad implements IDaoEspecialidad {
	
	public void Add(Especialidad especialidad) {
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		session.save(especialidad);
		
		session.getTransaction().commit();
		ch.cerrarConexion();
		
	}

	public List<Especialidad> ReadAll() {
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		List<Especialidad> list = (List<Especialidad>)session.createQuery("from Especialidad").list();
		
		ch.cerrarConexion();
		
		return list;
	}

	@Override
	public void Update(Especialidad especialidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(Especialidad especialidad) {
		// TODO Auto-generated method stub
		
	}	
}
