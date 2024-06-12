package negocio;

import java.util.List;

import entidad.Usuario;

public interface IUsuarioNegocio {
	
	public void Add(Usuario usuario);
	public List<Usuario> ReadAll();
}
