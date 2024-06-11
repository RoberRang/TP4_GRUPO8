package negocio;

import java.util.List;

import daoImpl.daoEspecialidad;
import entidad.Especialidad;

public interface IEspecialidadNegocio {
	
	  public void Add(daoEspecialidad daoEspecialidad);
	
	  public List<Especialidad> ReadAll();
	

}
