package negocioImpl;

import java.util.List;

import dao.IDaoEspecialidad;
import entidad.Especialidad;
import negocio.IEspecialidadNegocio;
import daoImpl.daoEspecialidad;

public class EspecialidadNegocio implements IEspecialidadNegocio {

	private IDaoEspecialidad daoEspecialidad; 
	
	public EspecialidadNegocio() {
		
	}
	
	public IDaoEspecialidad getDaoEspecialidad() {
		return daoEspecialidad;
	}

	public void setDaoEspecialidad(IDaoEspecialidad daoEspecialidad) {
		this.daoEspecialidad = daoEspecialidad;
	}
	
	// FIN SPRING CORE
	
	public void Add(Especialidad especialidad) {
		
		daoEspecialidad.Add(especialidad);
		
	}
	
	public List<Especialidad> ReadAll() {
		
		return daoEspecialidad.ReadAll();
	}

	
}
