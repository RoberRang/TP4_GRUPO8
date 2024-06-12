package negocio;

import java.util.List;

import entidad.Especialidad;

public interface IEspecialidadNegocio {
	
	  public void Add(Especialidad especialidad);
	
	  public List<Especialidad> ReadAll();
	

}
