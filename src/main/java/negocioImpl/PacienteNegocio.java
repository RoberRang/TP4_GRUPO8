package negocioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IDaoPaciente;
import entidad.Paciente;
import negocio.IPacienteNegocio;

@Service
public class PacienteNegocio implements IPacienteNegocio {
	
	@Autowired
	private IDaoPaciente daoPaciente;
	
	public PacienteNegocio() {
		
	}
	
	
	public IDaoPaciente getDaoPaciente() {
		return daoPaciente;
	}


	public void setDaoPaciente(IDaoPaciente daoPaciente) {
		this.daoPaciente = daoPaciente;
	}



	public void Add(Paciente paciente) {
		
		daoPaciente.Add(paciente);
		
	}

	
	public List<Paciente> ReadAll() {
		
		return daoPaciente.ReadAll();
	}

	
	public void Update(Paciente paciente) {
		
		this.daoPaciente.Update(paciente);
		
	}

	
	public void Delete(Paciente paciente) {
		
		this.daoPaciente.Delete(paciente);
		
	}

}
