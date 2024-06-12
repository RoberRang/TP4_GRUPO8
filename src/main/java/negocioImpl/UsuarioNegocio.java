package negocioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IDaoUsuario;
import daoImpl.daoUsuario;
import entidad.Usuario;
import negocio.IUsuarioNegocio;

@Service
public class UsuarioNegocio implements IUsuarioNegocio {
	
	@Autowired
	private IDaoUsuario daoUsuario;
	
	public UsuarioNegocio() {
		
	}
	
	
	public IDaoUsuario getDaoUsuario() {
		return daoUsuario;
	}


	public void setDaoUsuario(IDaoUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}



	public void Add(Usuario usuario) {
		
		daoUsuario.Add(usuario);
		
	}


	public List<Usuario> ReadAll() {
	
		return daoUsuario.ReadAll();
	}



}
