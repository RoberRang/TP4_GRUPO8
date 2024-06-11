package negocioImpl;

import java.util.List;

import dao.IDaoMedico;
import entidad.Medico;
import negocio.IMedicoNegocio;
import daoImpl.daoMedico;

public class MedicoNegocio implements IMedicoNegocio {


	private IDaoMedico daoMedico;
	
	public MedicoNegocio() {
		
	}

	
	public IDaoMedico getDaoMedico() {
		return daoMedico;
	}



	public void setDaoMedico(IDaoMedico daoMedico) {
		this.daoMedico = daoMedico;
	}



	public void Add(daoMedico daomedico) {
		
		this.daoMedico = daomedico;
		
	}


	public List<Medico> ReadAll() {
	
		return daoMedico.ReadAll();
	}


	public void Update(Medico medico) {
		
		//Revisar, debería ser boolean
		this.daoMedico.Update(medico);
		
	}


	public void Delete(Medico medico) {
		
		this.daoMedico.Delete(medico);
		
	}


}
