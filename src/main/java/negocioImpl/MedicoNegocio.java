package negocioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IDaoMedico;
import entidad.Medico;
import negocio.IMedicoNegocio;

@Service
public class MedicoNegocio implements IMedicoNegocio {

	@Autowired
	private IDaoMedico daoMedico;
	
	public MedicoNegocio() {
		
	}

	
	public IDaoMedico getDaoMedico() {
		return daoMedico;
	}



	public void setDaoMedico(IDaoMedico daoMedico) {
		this.daoMedico = daoMedico;
	}
	
	// FIN SPRING CORE


	public void Add(Medico medico) {
		
		daoMedico.Add(medico);
		
	}


	public List<Medico> ReadAll() {
	
		return daoMedico.ReadAll();
	}


	public void Update(Medico medico) {
		
		daoMedico.Update(medico);
		
	}


	public void Delete(Medico medico) {
		
		daoMedico.Delete(medico);
		
	}


}
