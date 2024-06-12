package daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import dao.IDaoEspecialidad;
import entidad.Especialidad;
import entidad.Usuario;
import resources.ConfigHibernate;

@Repository
public class daoEspecialidad implements IDaoEspecialidad {
	
	public daoEspecialidad () {
		
	}
	
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

}
