package negocio;

import java.util.List;

import daoImpl.daoTurno;
import entidad.Turno;

public interface ITurnoNegocio {

	public void Add(daoTurno daoturno);
	
	public List<Turno> ReadAll();
	
	public void Update(Turno turno);
	
	public void Delete(Turno turno);
}
