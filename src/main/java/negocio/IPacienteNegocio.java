package negocio;

import java.util.List;

import daoImpl.daoPaciente;
import entidad.Paciente;

public interface IPacienteNegocio {

public void Add(daoPaciente daopaciente);
	
	public List<Paciente> ReadAll();
	
	public void Update(Paciente paciente);
	
	public void Delete(Paciente paciente);
}
