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

	
	public void Add(daoEspecialidad daoEspecialidad) {
		this.daoEspecialidad = daoEspecialidad;
		
	}
	
	public List<Especialidad> ReadAll() {
		
		return daoEspecialidad.ReadAll();
	}

	
}
