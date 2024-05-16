package Idao;

import java.util.List;

import entidad.Paciente;

public interface IDaoPaciente {
	public void Add(Paciente paciente);
	
	public List<Paciente> ReadAll();
	
	public void Update(Paciente paciente);
	
	public void Delete(Paciente paciente);
}
