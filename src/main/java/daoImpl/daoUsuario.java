package daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import dao.IDaoUsuario;
import entidad.Usuario;
import resources.ConfigHibernate;

@Repository
public class daoUsuario implements IDaoUsuario {
	
	public void Add(Usuario usuario) {
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		session.save(usuario);
		
		session.getTransaction().commit();
		ch.cerrarConexion();
		
	}

	public List<Usuario> ReadAll() {
		
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		
		session.beginTransaction();
		@SuppressWarnings({ "unchecked" })
		List<Usuario> list = (List<Usuario>)session.createQuery("from Usuario").list();
		
		ch.cerrarConexion();
		
		return list;
	}	

}
