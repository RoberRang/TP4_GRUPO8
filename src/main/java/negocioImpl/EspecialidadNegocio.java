package negocioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IDaoEspecialidad;
import entidad.Especialidad;
import negocio.IEspecialidadNegocio;
import daoImpl.daoEspecialidad;

@Service
public class EspecialidadNegocio implements IEspecialidadNegocio {
	
	@Autowired
	private IDaoEspecialidad daoEspecialidad; 
	
	public EspecialidadNegocio() {
		
	}
	
	public EspecialidadNegocio(daoEspecialidad daoespe) {
		this.daoEspecialidad = daoespe;
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
