package UTNFRGP.TP4_GRUPO8;

import java.time.LocalDate;
import java.util.List;

import dao.daoEspecialidad;
import dao.daoMedico;
import entidad.Especialidad;
import entidad.Medico;

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

    
        
        
				
    }
}
