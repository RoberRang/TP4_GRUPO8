package daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import dao.IDaoTurno;
import entidad.EstadoTurno;
import entidad.Turno;
import resources.ConfigHibernate;

@Repository
public class daoTurno implements IDaoTurno {

	public void Add(Turno turno) {

		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();
		session.save(turno);

		session.getTransaction().commit();
		ch.cerrarConexion();

	}

	public List<Turno> ReadAll() {

		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();
		@SuppressWarnings({ "unchecked" })
		List<Turno> list = (List<Turno>) session.createQuery("from Turno").list();

		ch.cerrarConexion();

		return list;
	}

	public void Update(Turno turno) {

		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();
		session.update(turno);
		session.getTransaction().commit();

		ch.cerrarConexion();
	}

	public void Delete(Turno turno) {

		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();
		session.delete(turno);
		session.getTransaction().commit();

		ch.cerrarConexion();
	}

	/*
	 * public Turno mostrarTurnoMedicoPorLegajoYFecha(int legajoMedico, LocalDate
	 * fecha) {
	 * ConfigHibernate ch = new ConfigHibernate();
	 * Session session = ch.abrirConexion();
	 * 
	 * session.beginTransaction();
	 * 
	 * // Consulta HQL para obtener el turno del médico con el legajo especificado
	 * en la fecha especificada
	 * Turno turno = (Turno) session.createQuery(
	 * "SELECT t FROM Turno t " +
	 * "WHERE t.medico.legajo = :legajoMedico " +
	 * "AND t.fecha = :fecha")
	 * .setParameter("legajoMedico", legajoMedico)
	 * .setParameter("fecha", fecha.toString()) // Convierte LocalDate a String
	 * .uniqueResult();
	 * 
	 * session.getTransaction().commit();
	 * ch.cerrarConexion();
	 * 
	 * return turno;
	 * }
	 */

	// punto6
	public double obtenerPorcentajeTurnos(EstadoTurno estado, String fechaInicio, String fechaFin) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();

		// Consulta HQL para obtener la cantidad de turnos en el estado especificado
		// entre las fechas especificadas
		Long cantidadTurnos = (Long) session.createQuery(
				"SELECT COUNT(t) FROM Turno t " +
						"WHERE t.estado = :estado " +
						"AND t.fecha BETWEEN :fechaInicio AND :fechaFin")
				.setParameter("estado", estado)
				.setParameter("fechaInicio", fechaInicio)
				.setParameter("fechaFin", fechaFin)
				.uniqueResult();

		session.getTransaction().commit();
		ch.cerrarConexion();

		// Obtener el total de turnos entre las fechas dadas
		long totalTurnos = obtenerTotalTurnos(fechaInicio, fechaFin);

		// Calcular el porcentaje de turnos en el estado especificado
		return (double) cantidadTurnos / totalTurnos * 100;
	}

	private long obtenerTotalTurnos(String fechaInicio, String fechaFin) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();

		// Consulta HQL para obtener el total de turnos entre las fechas especificadas
		Long totalTurnos = (Long) session.createQuery(
				"SELECT COUNT(t) FROM Turno t " +
						"WHERE t.fecha BETWEEN :fechaInicio AND :fechaFin")
				.setParameter("fechaInicio", fechaInicio)
				.setParameter("fechaFin", fechaFin)
				.uniqueResult();

		session.getTransaction().commit();
		ch.cerrarConexion();

		return totalTurnos != null ? totalTurnos : 0;
	}

	public double getPorcentajeTotalTurnosPorEstado(EstadoTurno estado, String fechaIni, String fechaFin) {
		double porcentajeT = 0;
		int cantidadTurnos = 0;
		int totalTurnos = 1;

		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Object[]> objTurnos = (List<Object[]>) session.createQuery(
				"SELECT t FROM Turno t WHERE t.fecha BETWEEN :fechaInicio AND :fechaFin")
				.setParameter("fechaInicio", fechaIni)
				.setParameter("fechaFin", fechaFin)
				.list();

		session.getTransaction().commit();
		ch.cerrarConexion();

		for (Object objTurno2 : objTurnos) {
			Turno turno = (Turno) objTurno2;
			if (turno.getEstado().equals(estado))
				cantidadTurnos++;
		}
		if (cantidadTurnos > 0) {
			totalTurnos = objTurnos.size();
			porcentajeT = (double) cantidadTurnos / totalTurnos * 100;
		}

		return porcentajeT;
	}
}
