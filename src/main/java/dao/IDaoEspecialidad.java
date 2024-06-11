package dao;

import java.util.List;

import entidad.Especialidad;

public interface IDaoEspecialidad {
  
  	  public void Add(Especialidad especialidad);
	
	  public List<Especialidad> ReadAll();
    
}
