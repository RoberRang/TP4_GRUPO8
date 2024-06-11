package dao;

import java.util.List;

import entidad.Usuario;

public interface IDaoUsuario {

	public void Add(Usuario usuario);
	public List<Usuario> ReadAll();
}
