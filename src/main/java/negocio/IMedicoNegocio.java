package negocio;

import java.util.List;

import daoImpl.daoMedico;
import entidad.Medico;

public interface IMedicoNegocio {

public void Add(daoMedico daomedico);
	
	public List<Medico> ReadAll();
	
	public void Update(Medico medico);
	
	public void Delete(Medico medico);
}
