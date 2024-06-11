package UTNFRGP.TP4_GRUPO8;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import daoImpl.daoMedico;
import daoImpl.daoTurno;

import java.time.LocalDate;

import entidad.EstadoTurno;
import entidad.Medico;
import entidad.Turno;
import resources.AppConfig;

public class App2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 1- Mostrar los médicos ordenados por legajo de mayor a menor. Los campos que
		// se deben mostrar son todos. HQL SELECT ALL.

		//
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		daoMedico medicoDao = (daoMedico)appContext.getBean("nuevoDaoMedico");
		List<Medico> medicos =  medicoDao.mostrarMedicosOrdenadosPorLegajoDesc();

		for (Medico medico : medicos) {
			int legajo = (int) medico.getLegajo();
			String nombre = (String) medico.getNombre();
			String apellido = (String) medico.getApellido();

			System.out.println("Legajo: " + legajo + ", Nombre: " + nombre + ", Apellido: " + apellido);
		}

		// 2) Mostrar todos los médicos ordenados según su legajo de menor a mayor,
		// mostrar son legajo, nombre y apellido. Realizarlo SELECT SOME COLUMNS

		List<Object[]> medicosAsc = medicoDao.mostrarMedicosOrdenadosPorLegajoAsc();

		for (Object[] medico : medicosAsc) {
			int legajo = (int) medico[0];
			String nombre = (String) medico[1];
			String apellido = (String) medico[2];

			System.out.println("Legajo: " + legajo + ", Nombre: " + nombre + ", Apellido: " + apellido);
		}

		// 3) Mostrar todos los turnos que posee el médico con legajo 1234 en el día
		// 01/01/2025
		// Los campos que se deben mostrar son legajo, fecha de alta y estado.
		// Realizarlo como se explica en el video HQL INNER JOIN

		

		/*
		 * int legajoMedico = 1234;
		 * LocalDate fecha = LocalDate.of(2025, 1, 1);
		 * 
		 * 
		 * Turno turno = turnoDao.mostrarTurnoMedicoPorLegajoYFecha(legajoMedico,
		 * fecha);
		 * 
		 * 
		 * if (turno != null) {
		 * System.out.println(turno.toString());
		 * } else {
		 * System.out.println("No se encontró ningún turno para el médico con legajo " +
		 * legajoMedico + " en la fecha " + fecha);
		 * }
		 */

		int legajoMedico = 3;
		String fecha = "2025-01-01";

		List<Object[]> listaTurnos = (List<Object[]>) medicoDao.MostrarListadoTurnosPorLegajoYFecha(legajoMedico,
				fecha);

		if (listaTurnos.isEmpty()) {
			System.out.println(
					"No se encontró ningún turno para el médico con legajo " + legajoMedico + " en la fecha " + fecha);
		} else {

			for (Object[] objeto : listaTurnos) {
				Integer legajo = (Integer) objeto[0];
				String date = objeto[1].toString();
				String estado = objeto[2].toString();
				System.out.println("Legajo: " + legajo + ", Fecha: " + date + ", Estado: " + estado + ".");
			}
		}

		// 4) Mostrar todos los legajos de los médicos El campo que se debe mostrar es
		// legajo.
		// daoMedico medicoDao = new daoMedico();

		// Obtener y mostrar todos los legajos de los médicos
		List<Integer> legajos = medicoDao.obtenerLegajosMedicos();

		// Mostrar los legajos
		for (Integer legajo : legajos) {
			System.out.println(legajo);
		}

		// 5 5) Mostrar el médico con mayor número de legajo
		// daoMedico medicoDao = new daoMedico();

		int maxLegajo = medicoDao.obtenerMaxLegajoMedico();
		System.out.println("Máximo número de legajo entre los médicos: " + maxLegajo);

		//daoTurno turnoDao = new daoTurno();		
		daoTurno turnoDao = (daoTurno)appContext.getBean("nuevoDaoTurno");

		String fechaInicio = "1988-05-01";
		String fechaFin = "2025-01-01";

		EstadoTurno ausente = EstadoTurno.AUSENTE;
		EstadoTurno presente = EstadoTurno.PRESENTE;		
		EstadoTurno pendiente = EstadoTurno.PENDIENTE;

		double porcentajeAusentes = turnoDao.obtenerPorcentajeTurnos(ausente, fechaInicio, fechaFin);
		double porcentajePresentes = turnoDao.obtenerPorcentajeTurnos(presente, fechaInicio, fechaFin);		
		double porcentajePendientes = turnoDao.getPorcentajeTotalTurnosPorEstado(pendiente, fechaInicio, fechaFin);		 

		System.out.println("Porcentaje de turnos ausentes: " + porcentajeAusentes + "%");
		System.out.println("Porcentaje de turnos presentes: " + porcentajePresentes + "%");
		System.out.println("Porcentaje de turnos Pendidntes:" + porcentajePendientes + "%");
		//((ConfigurableApplicationContext)(appContext)).close();

	}

	// Otra forma punto 4

	/*
	 * 4) Mostrar todos los legajos de los médicos
	 * El campo que se debe mostrar es legajo. Realizarlo como se explica en el
	 * video HQL
	 * SELECT ONE COLUMN
	 * 
	 * 
	 * public static void ReadPunto4() {
	 * ConfigHibernate hb = new ConfigHibernate();
	 * Session session= hb.abrirConexion();
	 * 
	 * List<Integer>listaLegajoMedicos =
	 * (List<Integer>)session.createQuery("SELECT md.legajo FROM Medico md").list();
	 * 
	 * for (Integer legajo: listaLegajoMedicos) {
	 * 
	 * System.out.println("Legajo medico: "+legajo);
	 * }
	 * 
	 * hb.cerrarConexion();
	 * }
	 */
	
}