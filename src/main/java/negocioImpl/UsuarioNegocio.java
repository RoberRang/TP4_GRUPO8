package negocioImpl;

import java.util.List;

import dao.IDaoUsuario;
import daoImpl.daoUsuario;
import entidad.Usuario;
import negocio.IUsuarioNegocio;


public class UsuarioNegocio implements IUsuarioNegocio {
	
	private IDaoUsuario daoUsuario;
	
	public UsuarioNegocio() {
		
	}
	
	
	public IDaoUsuario getDaoUsuario() {
		return daoUsuario;
	}


	public void setDaoUsuario(IDaoUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}



	public void Add(daoUsuario usuario) {
		
		this.daoUsuario = usuario;
		
	}


	public List<Usuario> ReadAll() {
	
		return daoUsuario.ReadAll();
	}



}
