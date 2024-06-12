package negocioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IDaoTurno;
import entidad.Turno;
import negocio.ITurnoNegocio;

@Service
public class TurnoNegocio implements ITurnoNegocio {

	@Autowired
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
		
		daoTurno.Add(turno);
		
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
