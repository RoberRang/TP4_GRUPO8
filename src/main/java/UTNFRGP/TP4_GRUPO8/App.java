package UTNFRGP.TP4_GRUPO8;

import java.time.LocalDate;
import java.util.List;

import dao.daoEspecialidad;
import dao.daoMedico;
import dao.daoPaciente;
import entidad.Especialidad;
import entidad.Medico;
import entidad.Paciente;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	daoEspecialidad daoesp = new daoEspecialidad();

    	
    	for (int i = 1; i < 13; i++) {
    	    Especialidad espe = new Especialidad();
    	    espe.setNombre("Gastroenterologia_" + i);
    	    daoesp.Add(espe);
    	}

    	daoMedico daomed = new daoMedico();
    	List<Especialidad> especialidades = daoesp.ReadAll();

    	for (int i = 1; i < 13; i++) {
    	    Medico med1 = new Medico();
    	    med1.setNombre("Medico_Nom_" + i);
    	    med1.setApellido("Medico_Ape_" + i);
    	    med1.setSexo('M');
    	    med1.setFNac(LocalDate.parse("1988-05-01"));
    	    med1.setDirección("Calle Nula " + i);
    	    med1.setLocalidad("Localidad_" + i);
    	    med1.setCorreo("medico_" + i + "_@intramed.net");
    	    med1.setTeléfono("telefono_" + i);
    	    
    	    // Asignacion de una especialidad al médico 
    	    // asignamos una especialidad a cada médico de forma secuencial
    	    Especialidad especialidad = especialidades.get(i - 1); // con i-1 porque el indice arranca en 0
    	    med1.setEspecialidad(especialidad);
    	    
    	    daomed.Add(med1);
    	}
    	
    	daoPaciente daopac = new daoPaciente();
	    	
    	for (int i = 1; i < 13; i++) {
    	    Paciente pac1 = new Paciente();
    	    
    	    pac1.setNombre("Pedrito_" + i);
    	    pac1.setApellido("Ramirez_"+i);
    	    pac1.setCorreoElectronico("paciente_90@gmail.com_"+i);
    	    pac1.setDireccion("La plata 403_"+i);
    	    pac1.setDni("2588632_"+i);
    	    pac1.setFechaNacimiento("1988-05-01");
    	    pac1.setLocalidad("CABA_"+i);
    	    pac1.setProvincia("Buenos Aires_"+i);
    	    pac1.setTelefono("215585_"+i);
    	    
    	    daopac.Add(pac1);
    	}
    
				
    }
}
