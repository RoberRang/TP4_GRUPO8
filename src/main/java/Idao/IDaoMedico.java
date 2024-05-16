package Idao;

import java.util.List;

import entidad.Medico;


public interface IDaoMedico {
	
	public void Add(Medico medico);
	
	public List<Medico> ReadAll();
	
	public void Update(Medico medico);
	
	public void Delete(Medico medico);

}
