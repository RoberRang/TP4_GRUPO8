package negocio;

import java.util.List;

import daoImpl.daoMedico;
import entidad.Medico;

public interface IMedicoNegocio {

public void Add(Medico medico);
	
	public List<Medico> ReadAll();
	
	public void Update(Medico medico);
	
	public void Delete(Medico medico);
}
