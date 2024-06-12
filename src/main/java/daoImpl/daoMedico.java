package daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import dao.IDaoMedico;
import entidad.Medico;
import resources.ConfigHibernate;

@Repository
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
	
	//Metodos tp4
	public List<Medico> mostrarMedicosOrdenadosPorLegajoDesc() {
	    ConfigHibernate ch = new ConfigHibernate();
	    Session session = ch.abrirConexion();    
	
	    @SuppressWarnings({ "unchecked", "unused" })
		List<Medico> listaMedicos = (List<Medico>) session.createQuery("FROM Medico m ORDER BY m.legajo DESC").list();	    
	    
	    ch.cerrarConexion();
	    return listaMedicos;
	}
	
	public List<Object[]> mostrarMedicosOrdenadosPorLegajoAsc() {
	    ConfigHibernate ch = new ConfigHibernate();
	    Session session = ch.abrirConexion();
	    
	    
	    session.beginTransaction();
	    @SuppressWarnings("unchecked")
	    List<Object[]> listaMedicos = session.createQuery("SELECT m.legajo, m.nombre, m.apellido FROM Medico m ORDER BY m.legajo ASC").list();
	    
	   
	    ch.cerrarConexion();
	    
	    return listaMedicos;
	}
	
	 public List<Integer> obtenerLegajosMedicos() {
	        ConfigHibernate ch = new ConfigHibernate();
	        Session session = ch.abrirConexion();
	        
	        session.beginTransaction();
	        
	       
	        @SuppressWarnings("unchecked")
			List<Integer> listaLegajos = (List<Integer>) session.createQuery("SELECT m.legajo FROM Medico m").list();
	        
	        session.getTransaction().commit();
	        ch.cerrarConexion();
	        
	        return listaLegajos;
	    }
	 
	public int obtenerMaxLegajoMedico() {
	        ConfigHibernate ch = new ConfigHibernate();
	        Session session = ch.abrirConexion();
	        
	        session.beginTransaction();	        
	        
	        Integer maxLegajo = (Integer) session.createQuery("SELECT MAX(m.legajo) FROM Medico m").uniqueResult();
	        
	        session.getTransaction().commit();
	        ch.cerrarConexion();
	        
	        return maxLegajo != null ? maxLegajo : 0; // Devuelve 0 si no se encuentra ningún médico
	    }
	
	//PUNTO 3
	
	public List<Object[]> MostrarListadoTurnosPorLegajoYFecha(int legajoMedico, String fecha) {
		ConfigHibernate ch = new ConfigHibernate();
	    Session session = ch.abrirConexion();
	    
	    List<Object[]> listaTurnos = (List<Object[]>)session.createQuery("SELECT m.legajo, lt.fecha, lt.estado FROM Medico as m INNER JOIN m.listaTurnos lt " +
                "WHERE m.legajo = :legajoMedico " +
                "AND lt.fecha = :fecha")
	    		.setParameter("legajoMedico", legajoMedico)
                .setParameter("fecha", fecha) 
                .list();  	
	    
	    ch.cerrarConexion();
		
		return listaTurnos;
	}
}
