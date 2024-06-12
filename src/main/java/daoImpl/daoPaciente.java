package daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import dao.IDaoPaciente;
import entidad.Paciente;
import resources.ConfigHibernate;

@Repository
public class daoPaciente implements IDaoPaciente {
	

	public void Add(Paciente paciente) {
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		session.save(paciente);
		
		session.getTransaction().commit();
		ch.cerrarConexion();
		
	}
	

	public List<Paciente> ReadAll() {
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		@SuppressWarnings({ "unchecked" })
		List<Paciente> list = (List<Paciente>)session.createQuery("from Paciente").list();
		
		ch.cerrarConexion();
		
		return list;
	}
	

	public void Update(Paciente paciente) {
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		session.update(paciente);
		session.getTransaction().commit();
		
		ch.cerrarConexion();
	}
	

	public void Delete(Paciente paciente) {
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		session.delete(paciente);
		session.getTransaction().commit();
		
		ch.cerrarConexion();
	}

}
