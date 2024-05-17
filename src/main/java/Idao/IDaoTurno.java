package Idao;

import java.util.List;

import entidad.Turno;

public interface IDaoTurno {

	public void Add(Turno turno);
	
	public List<Turno> ReadAll();
	
	public void Update(Turno turno);
	
	public void Delete(Turno turno);
}
