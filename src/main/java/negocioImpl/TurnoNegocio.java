package negocioImpl;

import java.util.List;

import dao.IDaoTurno;
import daoImpl.daoTurno;
import entidad.Turno;
import negocio.ITurnoNegocio;

public class TurnoNegocio implements ITurnoNegocio {

	private IDaoTurno daoTurno;
	
	public TurnoNegocio() {
		
	}


	public IDaoTurno getDaoTurno() {
		return daoTurno;
	}


	public void setDaoTurno(IDaoTurno daoTurno) {
		this.daoTurno = daoTurno;
	}



	public void Add(Turno turno) {
		
		daoTurno.Add(turno);;
		
	}


	public List<Turno> ReadAll() {
		
		return daoTurno.ReadAll();
	}


	public void Update(Turno turno) {
		
		daoTurno.Update(turno);
		
	}


	public void Delete(Turno turno) {
		
		daoTurno.Delete(turno);
		
	}

}
