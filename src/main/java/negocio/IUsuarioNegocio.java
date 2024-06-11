package negocio;

import java.util.List;

import daoImpl.daoUsuario;
import entidad.Usuario;

public interface IUsuarioNegocio {
	
	public void Add(daoUsuario usuario);
	public List<Usuario> ReadAll();
}
